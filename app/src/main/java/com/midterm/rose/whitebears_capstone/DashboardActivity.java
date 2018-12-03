package com.midterm.rose.whitebears_capstone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class DashboardActivity extends AppCompatActivity implements HttpCall.AsyncResponse{
    private final String ON_SCHEDULE = "On time";
    private final String OVERDUE = "Overdue";

    private RecyclerView mRecyclerView;
    private TaskListAdapter mAdapter;
    private String userName;

    RadioGroup rg;

    ArrayList<Project> allProjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        HttpCall hc = new HttpCall();
        hc.delegate = this;
        userName = getIntent().getExtras().getString("userName");
        hc.execute("getTasks", userName);
    }

    int completedOnTime, completedOverdue, overdue, onSchedule;

    private void updateProject(String projectName){
        completedOnTime = 0;
        completedOverdue = 0;
        overdue = 0;
        onSchedule = 0;

        ArrayList<Task> allTasks = new ArrayList<>();
        if(projectName.equals("All")) {
            for (Project project : allProjects) {
                incrementStatusCounters(project.getTasks());


                for(Task task : project.getTasks())
                    allTasks.add(task);
            }
        }else {
            for (Project project : allProjects) {
                if (project.getTitle().equals(projectName)) {
                    incrementStatusCounters(project.getTasks());

                    for(Task task : project.getTasks())
                        allTasks.add(task);

                    break;
                }
            }
        }

        PieChartHelper.populatePieChart(completedOnTime, completedOverdue, overdue, onSchedule);

        mAdapter = new TaskListAdapter(this, allTasks);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void incrementStatusCounters(ArrayList<Task> tasks){
        for(Task task : tasks){
            switch(task.getStatus()){
                case OVERDUE:
                    if(task.isCompleted()){
                        completedOverdue++;
                    }
                    else {
                        overdue++;
                    }
                    break;
                case ON_SCHEDULE:
                    if(task.isCompleted()){
                        completedOnTime++;
                    }
                    else {
                        onSchedule++;
                    }
                    break;
            }
        }
    }

    @Override
    public void processFinish(String output) {
        ArrayList<Task> alltasks = new ArrayList<>();
        try {
            JSONArray obj = new JSONArray(output);
            Gson gson = new Gson();
            for(int i = 0; i < obj.length(); i++){
                JSONObject task = obj.getJSONObject(i);
                SimpleDateFormat myDate= new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                myDate.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
                if(Long.parseLong(task.get("CompletedDate").toString().replaceAll("\\D+","")) != 62135596800000L){
                    task.put("CompletedDate", myDate.format(new Date(Long.parseLong(task.get("CompletedDate").toString().replaceAll("\\D+","")))));
                }
                else{
                    task.remove("CompletedDate");
                }
                if(Long.parseLong(task.get("StartDate").toString().replaceAll("\\D+","")) != 62135596800000L){
                    task.put("StartDate", myDate.format(new Date(Long.parseLong(task.get("StartDate").toString().replaceAll("\\D+","")))));
                }
                else{
                    task.remove("StartDate");
                }
                if(Long.parseLong(task.get("DueDate").toString().replaceAll("\\D+","")) != 62135596800000L){
                    task.put("DueDate", myDate.format(new Date(Long.parseLong(task.get("DueDate").toString().replaceAll("\\D+","")))));
                }
                else{
                    task.remove("DueDate");
                }
                Task task1 = gson.fromJson(task.toString() , Task.class);

                alltasks.add(task1);
            }

            //Get all projects
            for(Task task : alltasks){
                boolean found = false;
                for(Project project : allProjects){

                    if(task.getProjectName().equals(project.getTitle())){
                        ArrayList<Task> pTasks =   project.getTasks();
                        pTasks.add(task);
                        found = true;
                        break;
                    }
                }
                if(!found){
                    Project project = new Project();
                    project.setTitle(task.getProjectName());
                    ArrayList<Task> pTask = new ArrayList<>();
                    pTask.add(task);
                    project.setTasks(pTask);
                    allProjects.add(project);
                }
            }

            rg = findViewById(R.id.projectGroup);

            PieChartHelper.pieChartView = findViewById(R.id.chart);

            mRecyclerView = findViewById(R.id.my_recycler_view);

            ArrayList<Task> allTasks = new ArrayList<>();

            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 5, 50, 5);

            RadioButton rb = new RadioButton(this);
            rb.setText("All");
            rb.setLayoutParams(params);
            rg.addView(rb);

            for (Project p : allProjects) {
                rb = new RadioButton(this);
                rb.setText(p.getTitle());

                rb.setLayoutParams(params);
                rg.addView(rb);

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton checkedRadioButton = group.findViewById(checkedId);
                        if (checkedRadioButton.isChecked()) {
                            updateProject(checkedRadioButton.getText() + "");
                        }
                    }
                });

                for (Task t : p.getTasks())
                    allTasks.add(t);
            }

            updateProject("All");

            ((RadioButton) rg.getChildAt(0)).setChecked(true);
        }
        catch (Exception e){
            String ex = e.getMessage();
        }
    }
}

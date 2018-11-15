package com.midterm.rose.whitebears_capstone;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class DashboardActivity extends AppCompatActivity {
    private final String ON_SCHEDULE = "On Schedule";
    private final String OVERDUE = "Overdue";
    private final String COMPLETED_ON_TIME = "Completed (On Time)";
    private final String COMPLETED_OVERDUE = "Completed (Overdue)";

    private RecyclerView mRecyclerView;
    private TaskListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Project p = generateOneProject();


        PieChartHelper.pieChartView = findViewById(R.id.chart);
        PieChartHelper.populatePieChart(p.getTasks());

        // Create recycler view.
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new TaskListAdapter(this, p.getTasks());
        // Connect the adapter with the recycler view.
        mRecyclerView.setAdapter(mAdapter);
        // Give the recycler view a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private Project generateOneProject(){
        Project p = new Project();

        ArrayList<Task> tasks = new ArrayList<>();

        Task t1 = new Task(0, 0, 0, "High", "Task1", "Desc1", ON_SCHEDULE, "Project1", new Date(), new Date(), new Date());
        t1.addUser(new User("Joe", "Bob"));


        Task t2 = new Task(1, 1, 1, "Medium", "Task2", "Desc2", ON_SCHEDULE, "Project2", new Date(), new Date(), new Date());
        t2.addUser(new User("Billy", "Bob"));

        Task t3 = new Task(2, 2, 2, "High", "Task3", "Desc3", ON_SCHEDULE, "Project3", new Date(), new Date(), new Date());
        t3.addUser(new User("Jatin", "Singh"));
        t3.addUser(new User("Raf", "Sigwalt"));


        Task t4 = new Task(3, 3, 3, "Medium", "Task3", "Desc3", COMPLETED_ON_TIME, "Project3", new Date(), new Date(), new Date());
        t4.addUser(new User("Sup", "MahBrotha"));

        Task t5 =new Task(4, 4, 4, "Medium", "Task4", "Desc4", COMPLETED_OVERDUE, "Project4", new Date(), new Date(), new Date());
        t5.addUser(new User("Test", "User"));


        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);
        tasks.add(t4);
        tasks.add(t5);
        p.setTasks(tasks);

        return p;
    }

    private Project[] generateMultipleProjects(){
        return null;
    }
}

package com.midterm.rose.whitebears_capstone;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Project p = generateOneProject();


        PieChartHelper.pieChartView = findViewById(R.id.chart);
        PieChartHelper.populatePieChart(p.getTasks());
    }

    private Project generateOneProject(){
        Project p = new Project();

        ArrayList<Task> tasks = new ArrayList<>();

        tasks.add(new Task(0, 0, 0, "High", "Task1", "Desc1", ON_SCHEDULE, "Project1", new Date(), new Date(), new Date()));

        tasks.add(new Task(1, 1, 1, "Medium", "Task2", "Desc2", ON_SCHEDULE, "Project2", new Date(), new Date(), new Date()));

        tasks.add(new Task(2, 2, 2, "Medium", "Task2", "Desc2", ON_SCHEDULE, "Project2", new Date(), new Date(), new Date()));

        tasks.add(new Task(3, 3, 3, "Medium", "Task3", "Desc3", COMPLETED_ON_TIME, "Project3", new Date(), new Date(), new Date()));

        tasks.add(new Task(4, 4, 4, "Medium", "Task4", "Desc4", COMPLETED_OVERDUE, "Project4", new Date(), new Date(), new Date()));

        p.setTasks(tasks);

        return p;
    }

    private Project[] generateMultipleProjects(){
        return null;
    }
}

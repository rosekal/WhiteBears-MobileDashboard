package com.midterm.rose.whitebears_capstone;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartHelper {
    public static PieChartView pieChartView;

    public static void populatePieChart(ArrayList<Task> tasks){

        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(Task.completedOnTime, Color.GREEN).setLabel("Completed On Time"));
        pieData.add(new SliceValue(Task.completedOverdue, Color.YELLOW).setLabel(" Completed Overdue"));
        pieData.add(new SliceValue(Task.overdue, Color.RED).setLabel("Overdue"));
        pieData.add(new SliceValue(Task.onSchedule, Color.BLUE).setLabel("On Schedule"));

        PieChartData pieChartData = new PieChartData(pieData);

        pieChartData.setHasCenterCircle(true)
                .setCenterText1("Tasks Overview")
                .setCenterText1FontSize(15)
                .setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView.setPieChartData(pieChartData);
    }
}

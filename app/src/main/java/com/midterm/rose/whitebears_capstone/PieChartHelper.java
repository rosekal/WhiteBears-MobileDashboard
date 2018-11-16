package com.midterm.rose.whitebears_capstone;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class PieChartHelper {
    public static PieChartView pieChartView;

    public static void populatePieChart(int completedOnTime, int completedOverdue, int overdue, int onSchedule){

        List<SliceValue> pieData = new ArrayList<>();
        pieData.add(new SliceValue(completedOnTime, Color.rgb(158, 255, 166)).setLabel(completedOnTime+""));
        pieData.add(new SliceValue(completedOverdue, Color.rgb(255, 226, 158)).setLabel(completedOverdue+""));
        pieData.add(new SliceValue(overdue, Color.rgb(255, 158, 158)).setLabel(overdue+""));
        pieData.add(new SliceValue(onSchedule, Color.rgb(158, 158, 255)).setLabel(onSchedule+""));

        PieChartData pieChartData = new PieChartData(pieData);

        pieChartData.setHasLabels(true);

        pieChartData.setHasCenterCircle(true)
                .setCenterText1("Tasks Overview")
                .setCenterText1FontSize(15)
                .setCenterText1Color(Color.parseColor("#0097A7"));

        pieChartView.setPieChartData(pieChartData);
    }
}

package com.example;

import java.awt.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;

public class Motion_chart {
    
    private JFreeChart chart;
    XYDataset dataset;

    public Motion_chart(XYDataset _dataset)
    {
        dataset = _dataset;
        chart = ChartFactory.createXYLineChart("Motion", "Time", "Value", dataset);
        // chart.setBackgroundPaint(Color.DARK_GRAY);
        // chart.setBorderPaint(Color.GRAY);
    }

    public ChartPanel getChart()
    {
        ChartPanel cp = new ChartPanel(chart, 600, 600, 10, 10, 10000, 10000, false, false, true, true, true, false);
        return cp;
    }
}

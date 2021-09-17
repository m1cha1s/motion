package com.example;

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
    }

    public ChartPanel getChart()
    {
        return new ChartPanel(chart);
    }
}

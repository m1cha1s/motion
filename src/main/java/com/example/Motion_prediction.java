package com.example;

import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Motion_prediction {
    private double x_0;
    private double v_0;
    private double a_0;
    private double t_0;

    private double dt;

    private double x;
    private double v;
    private double a;
    private double t;

    private double x_trig;
    private double a_trig;

    private XYSeries data_x = new XYSeries("X(t)[m]");
    private XYSeries data_v = new XYSeries("V(t)[m/s]");
    private XYSeries data_a = new XYSeries("a(0)[m/s^2]");
    private XYSeries ground = new XYSeries("Ground");
    private XYSeriesCollection data = new XYSeriesCollection();

    public Motion_prediction()
    {
        data.addSeries(data_x);
        data.addSeries(data_v);
        data.addSeries(data_a);
        data.addSeries(ground);
    }

    public void setValues(double _x_0, double _v_0, double _a_0, double _t_0, double _dt, double _x_trig, double _a_trig)
    {
        x = x_0 = _x_0;
        v = v_0 = _v_0;
        a = a_0 = _a_0;
        t = t_0 = _t_0;
        x_trig = _x_trig;
        a_trig = _a_trig;

        dt = _dt;

        data_x.clear();
        data_v.clear();
        data_a.clear();
        ground.clear();
    }

    public double x_t()
    {
        x = x + v*dt + 0.5*a*dt*dt;
        return x;
    }

    public double v_t()
    {
        v = v + a*dt;
        return v;
    }

    public double a_t()
    {
        return a;
    }

    public void simulate(double time)
    {
        while(t < time)
        {
            if(x < x_trig) a = a_trig;
            
            data_a.add(t, a_t());
            data_v.add(t, v_t());
            data_x.add(t, x_t());
            ground.add(t, 0);
            t += dt;
        }
    }

    public XYDataset getDataset()
    {
        return data;
    }
}

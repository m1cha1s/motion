package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.data.xy.XYDataset;

public class Gui implements ActionListener
{
    private JFrame window = new JFrame(); // Main window
    private JPanel settings = new JPanel(); // Settings panel

    private JPanel panel_time = new JPanel();
    private JLabel label_time = new JLabel("Time");
    private JTextField text_time = new JTextField("10");

    private JPanel panel_x = new JPanel();
    private JLabel label_x = new JLabel("X(0)");
    private JTextField text_x = new JTextField("200");

    private JPanel panel_v = new JPanel();
    private JLabel label_v = new JLabel("V(0)");
    private JTextField text_v = new JTextField("10");

    private JPanel panel_a = new JPanel();
    private JLabel label_a = new JLabel("a(0)");
    private JTextField text_a = new JTextField("-10");

    private JPanel panel_t_0 = new JPanel();
    private JLabel label_t_0 = new JLabel("t(0)");
    private JTextField text_t_0 = new JTextField("0");

    private JPanel panel_dt = new JPanel();
    private JLabel label_dt = new JLabel("dt");
    private JTextField text_dt = new JTextField("0.1");

    private JButton simulate = new JButton("Simulate");

    private Motion_prediction motion;
    private Motion_chart chart;

    public Gui(Motion_prediction _motion)
    {
        motion = _motion;
        chart = new Motion_chart(motion.getDataset());

        simulate.addActionListener(this);

        window.setTitle("Motion");
        window.setSize(400, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(0,2));

        settings.setLayout(new GridLayout(2,4));

        
        panel_time.setLayout(new GridLayout(2,0));
        panel_time.add(label_time);
        panel_time.add(text_time);
        settings.add(panel_time);

        panel_x.setLayout(new GridLayout(2,0));
        panel_x.add(label_x);
        panel_x.add(text_x);
        settings.add(panel_x);

        panel_v.setLayout(new GridLayout(2,0));
        panel_v.add(label_v);
        panel_v.add(text_v);
        settings.add(panel_v);

        panel_a.setLayout(new GridLayout(2,0));
        panel_a.add(label_a);
        panel_a.add(text_a);
        settings.add(panel_a);

        panel_t_0.setLayout(new GridLayout(2,0));
        panel_t_0.add(label_t_0);
        panel_t_0.add(text_t_0);
        settings.add(panel_t_0);

        panel_dt.setLayout(new GridLayout(2,0));
        panel_dt.add(label_dt);
        panel_dt.add(text_dt);
        settings.add(panel_dt);

        settings.add(simulate);

        window.add(settings);
        window.add(chart.getChart());

        window.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        motion.setValues(Double.parseDouble(text_x.getText()), Double.parseDouble(text_v.getText()), Double.parseDouble(text_a.getText()), Double.parseDouble(text_t_0.getText()), Double.parseDouble(text_dt.getText()));
        motion.simulate(Double.parseDouble(text_time.getText()));
    }
}

package com.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jfree.data.xy.XYDataset;

public class Gui implements ActionListener
{
    private JFrame window = new JFrame(); // Main window
    private JPanel panel = new JPanel(new GridBagLayout()); // Main window panel
    private JFrame graph = new JFrame(); // Graph panel
    private JPanel settings = new JPanel(new GridBagLayout()); // Settings panel

    private JLabel label_time = new JLabel("Time");
    private JTextField text_time = new JTextField("10");

    private JLabel label_x = new JLabel("X(0)");
    private JTextField text_x = new JTextField("200");

    private JLabel label_v = new JLabel("V(0)");
    private JTextField text_v = new JTextField("10");

    private JLabel label_a = new JLabel("a(0)");
    private JTextField text_a = new JTextField("-10");

    private JLabel label_t_0 = new JLabel("t(0)");
    private JTextField text_t_0 = new JTextField("0");

    private JLabel label_dt = new JLabel("dt");
    private JTextField text_dt = new JTextField("0.1");

    private JLabel label_x_trig = new JLabel("X trig");
    private JTextField text_x_trig = new JTextField("100");

    private JLabel label_a_trig = new JLabel("A trig");
    private JTextField text_a_trig = new JTextField("10");

    private JButton simulate = new JButton("Simulate");

    private Motion_prediction motion;
    private Motion_chart chart;

    public Gui(Motion_prediction _motion)
    {
        motion = _motion;
        chart = new Motion_chart(motion.getDataset());

        simulate.addActionListener(this);

        window.setTitle("Motion");
        window.setSize(400, 100);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setAlwaysOnTop(true);

        
        graph.setTitle("Motion chart");
        graph.setSize(800,700);
        graph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graph.setLayout(new BorderLayout());


        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;

        gbc.gridy = 0;
        settings.add(label_time, gbc);
        gbc.gridy = 1;
        settings.add(text_time, gbc);

        gbc.gridx = 1;

        gbc.gridy = 0;
        settings.add(label_x, gbc);
        gbc.gridy = 1;
        settings.add(text_x, gbc);

        gbc.gridx = 2;

        gbc.gridy = 0;
        settings.add(label_v, gbc);
        gbc.gridy = 1;
        settings.add(text_v, gbc);

        gbc.gridx = 3;

        gbc.gridy = 0;
        settings.add(label_a, gbc);
        gbc.gridy = 1;
        settings.add(text_a, gbc);

        gbc.gridx = 4;

        gbc.gridy = 0;
        settings.add(label_t_0, gbc);
        gbc.gridy = 1;
        settings.add(text_t_0, gbc);

        gbc.gridx = 5;

        gbc.gridy = 0;
        settings.add(label_dt, gbc);
        gbc.gridy = 1;
        settings.add(text_dt, gbc);

        gbc.gridx = 6;

        gbc.gridy = 0;
        settings.add(label_x_trig, gbc);
        gbc.gridy = 1;
        settings.add(text_x_trig, gbc);

        gbc.gridx = 7;

        gbc.gridy = 0;
        settings.add(label_a_trig, gbc);
        gbc.gridy = 1;
        settings.add(text_a_trig, gbc);

        gbc.gridx = 8;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        settings.add(simulate, gbc);

        window.add(settings, BorderLayout.CENTER);
        graph.add(chart.getChart(), BorderLayout.CENTER);
      
        window.setVisible(true);
        graph.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        motion.setValues(Double.parseDouble(text_x.getText()), 
                         Double.parseDouble(text_v.getText()), 
                         Double.parseDouble(text_a.getText()), 
                         Double.parseDouble(text_t_0.getText()), 
                         Double.parseDouble(text_dt.getText()), 
                         Double.parseDouble(text_x_trig.getText()), 
                         Double.parseDouble(text_a_trig.getText()));

        motion.simulate(Double.parseDouble(text_time.getText()));
    }
}

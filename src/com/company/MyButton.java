package com.company;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.Observable;
        import java.util.Observer;

public class MyButton extends JButton implements Observer{
    private Counter counter;
    private MyPanel panel;
    private int ARG;
    private static int num=0;
    private int localnum;

    public MyButton(Counter counter, MyPanel panel){
        num++;
        localnum=num;
        System.out.println(num);
        this.setText("Add");
        MyButtonListener listener = new MyButtonListener();
        this.addActionListener(listener);

        this.counter = counter;
        this.panel = panel;
    }

    @Override
    public void update(Observable o, Object arg) {
        counter = (Counter) o;
        ARG = (int) arg;
        panel.setStr(counter.getCounter());
        panel.repaint();
        int test=counter.getCounter();
        if (ARG==1  && test ==3)
            System.exit(1244);
    }

    private class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            counter.increment(localnum);
        }
    }

    public void setCounter(Counter a){
        this.counter=a;
    }
    public void setPanel(MyPanel a){
        this.panel=a;
    }
}
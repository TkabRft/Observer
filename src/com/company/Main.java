package com.company;

import javax.swing.*;
import java.awt.*;

//PropertyChangeListener
//PropertyChangeSupport

public class Main extends JFrame{
    public Main(){
        this.setTitle("MVC");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int i=0;
        Container pane = this.getContentPane();
        pane.setLayout(new GridLayout(2, 1));

        Counter counter = new Counter(); //model
        MyPanel panel = new MyPanel(counter); //viewer
        MyButton button[] = new MyButton[2];//controllers
        MyPanel panel2 = new MyPanel(counter);
        //MyButton button2 = new MyButton(counter, panel);

        pane.add(panel);
        while (i<2){
            button[i]= new MyButton(counter, panel);
            pane.add(button[i]);
           /*
            button[i].setCounter(counter);
            button[i].setPanel(panel);
            */
            counter.addObserver(button[i]);
            i++;
        }
        pane.add(panel2);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
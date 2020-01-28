package com.company;

import java.util.Observable;

public class Counter extends Observable {
    private int counter;

    public Counter(){
        counter = 0;
    }

    public int getCounter(){
        return counter;
    }

    public void increment(int num){
        counter++;

        this.setChanged();
        this.notifyObservers(num);
    }
}
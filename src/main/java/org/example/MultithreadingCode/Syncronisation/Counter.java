package org.example.MultithreadingCode.Syncronisation;

public class Counter {
    private int count=0;

    public synchronized void increment(){
        count++;
    }
    public int getcount(){
        return count;
    }


}

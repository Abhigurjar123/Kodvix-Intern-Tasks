package org.example.MultithreadingCode.ThreadCommunication;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        MyThread1 t1= new MyThread1(resource);
        MyThread2 t2= new MyThread2(resource);
        t1.start();
        t2.start();

    }
}

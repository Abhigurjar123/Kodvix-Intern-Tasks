package org.example.MultithreadingCode.Locks.Lockfairness;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        FairLock example= new FairLock();
     //   UnfairLock example= new UnfairLock();
        Runnable task= new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };
        Thread t1 = new Thread(task,"Thread1");
        Thread t2 = new Thread(task,"Thread2");
        Thread t3 = new Thread(task,"Thread3");
        t1.start();
        t2.start();
        t3.start();


    }
}

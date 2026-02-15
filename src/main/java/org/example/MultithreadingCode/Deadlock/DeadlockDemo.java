package org.example.MultithreadingCode.Deadlock;

public class DeadlockDemo {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        MyThread1 t1 = new MyThread1(lock1, lock2);
        MyThread2 t2 = new MyThread2(lock1, lock2);

        t1.start();
        t2.start();
    }
}


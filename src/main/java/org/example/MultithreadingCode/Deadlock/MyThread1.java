package org.example.MultithreadingCode.Deadlock;

class MyThread1 extends Thread {

    Object lock1;
    Object lock2;

    MyThread1(Object l1, Object l2) {
        this.lock1 = l1;
        this.lock2 = l2;
    }

    public void run() {

        synchronized (lock1) {
            System.out.println("Thread1 got lock1");

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (lock2) {
                System.out.println("Thread1 got lock2");
            }
        }
    }
}

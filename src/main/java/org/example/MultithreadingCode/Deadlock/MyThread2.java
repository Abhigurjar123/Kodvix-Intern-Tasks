package org.example.MultithreadingCode.Deadlock;

class MyThread2 extends Thread {

    Object lock1;
    Object lock2;

    MyThread2(Object l1, Object l2) {
        this.lock1 = l1;
        this.lock2 = l2;
    }

    public void run() {

        synchronized (lock2) {
            System.out.println("Thread2 got lock2");

            try { Thread.sleep(100); } catch (Exception e) {}

            synchronized (lock1) {
                System.out.println("Thread2 got lock1");
            }
        }
    }
}

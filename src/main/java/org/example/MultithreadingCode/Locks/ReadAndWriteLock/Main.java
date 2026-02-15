package org.example.MultithreadingCode.Locks.ReadAndWriteLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ReadWriteCounter counter= new ReadWriteCounter();
        Runnable writetask= new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName()+" Incremented "+counter.getCount());

                }
            }
        };
        Runnable readtask= new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <10 ; i++) {
                    System.out.println(Thread.currentThread().getName()+" Count "+ counter.getCount());

                }
            }
        };
        Thread writethread= new Thread(writetask,"Thread-0");
        Thread readthread1= new Thread(readtask,"Thread-1");
        Thread readthread2= new Thread(readtask,"Thread-2");
        writethread.start();

        readthread1.start();
        readthread2.start();

        writethread.join();
        readthread1.join();
        readthread2.join();

        System.out.println("Total Count "+counter.getCount());
    }
}

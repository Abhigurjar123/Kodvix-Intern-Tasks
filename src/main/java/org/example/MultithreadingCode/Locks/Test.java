package org.example.MultithreadingCode.Locks;

public class Test {
    public static void main(String[] args) {
        BankAccount sbi= new BankAccount();
        Runnable task= new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Runnable task2= new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(70);
            }
        };

        Thread t1= new Thread(task,"Thread1");
        Thread t2= new Thread(task2,"Thread2");
        t1.start();
        t2.start();
    }
}

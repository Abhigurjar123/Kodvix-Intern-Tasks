package org.example.MultithreadingCode.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

       private Lock lock= new ReentrantLock();
    public void withdraw(int amount) {
        try {
            if( lock.tryLock(3500, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName() + " is trying to withdraw... " + amount);
                try {
                    if (balance >= amount) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " withdraw successfuly" + " current Balance: " + balance);
                    }else{
                        System.out.println("Insuffisient Balance");
                    }
                } catch (Exception e) {
                     e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }else {
                System.out.println(Thread.currentThread().getName()+" is unable to get Lock will try later");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

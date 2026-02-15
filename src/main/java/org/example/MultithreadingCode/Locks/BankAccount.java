package org.example.MultithreadingCode.Locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
    private int balance = 100;

       private Lock lock= new ReentrantLock();
    public void withdraw(int amount) {
        boolean isLocked = false;
        try {
            isLocked = lock.tryLock(3500, TimeUnit.MILLISECONDS);
            if (!isLocked) {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock.");
                return;
            }

            System.out.println(Thread.currentThread().getName() + " trying to withdraw: " + amount);

            if (balance >= amount) {
                Thread.sleep(3000);
                balance -= amount;
                System.out.println("Withdrawal successful. Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (isLocked) {
                lock.unlock();
            }
        }
    }


}

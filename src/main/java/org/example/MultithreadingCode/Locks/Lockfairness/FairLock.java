package org.example.MultithreadingCode.Locks.Lockfairness;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLock extends  Thread{

    private Lock fairLock= new ReentrantLock(true);
    public  void accessResource(){
        fairLock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" Acquired the Lock");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        } catch (Exception e){

        } finally {
            System.out.println(Thread.currentThread().getName()+" Released lock");
            fairLock.unlock();
        }
    }
}

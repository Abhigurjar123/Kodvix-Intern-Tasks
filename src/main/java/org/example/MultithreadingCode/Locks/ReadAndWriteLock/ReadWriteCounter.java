package org.example.MultithreadingCode.Locks.ReadAndWriteLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteCounter {

    private int count=0;
    private ReadWriteLock lock= new ReentrantReadWriteLock();
    private Lock readLock= lock.readLock();
    private Lock writeLock= lock.writeLock();

    public  void increment(){
        writeLock.lock();
        try{
            count++;

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }finally {
            writeLock.unlock();
        }
    }
    public int getCount(){
        readLock.lock();
        try{
            return count;
        }finally {
            readLock.unlock();
        }
    }

}

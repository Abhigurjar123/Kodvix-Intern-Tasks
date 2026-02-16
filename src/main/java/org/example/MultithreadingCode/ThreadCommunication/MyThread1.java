package org.example.MultithreadingCode.ThreadCommunication;

public class MyThread1 extends  Thread{
    private SharedResource resource;

    public MyThread1(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            resource.produce(i);
        }
    }
}

package org.example.MultithreadingCode.ThreadCommunication;

public class MyThread2 extends  Thread{
    private SharedResource resource;

    public MyThread2(SharedResource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i <10; i++) {
            resource.consume();
        }
    }
}

package org.example.MultithreadingCode.ThreadCommunication;

public class SharedResource {
     private int data;
     private boolean hasData= false;

     public synchronized void produce(int value){
         while(hasData){
             try {
                 System.out.println("Producer waiting...");
                 wait();
             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
         }
         data=value;
         System.out.println("produced"+data);
         hasData=true;
         notify();
     }
     public synchronized   void consume(){
         while(!hasData){
             try {
                 System.out.println("Consumer waiting...");
                 wait();
             } catch (InterruptedException e) {
                 Thread.currentThread().interrupt();
             }
         }
         System.out.println("consumed"+data);
         hasData=false;
         notify();
     }


}

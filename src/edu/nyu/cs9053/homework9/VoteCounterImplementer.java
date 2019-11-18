package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class VoteCounterImplementer implements VoteCounter{

    private final Semaphore binarySemaphore;

    public VoteCounterImplementer(Semaphore binarySemaphore){
        this.binarySemaphore = binarySemaphore;
    }

    @Override
    public QueueNumber count(Queue from) {
        try {
            binarySemaphore.acquire();
            if (!from.isEmpty()){
                return from.getQueueNumber();
            }
            binarySemaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

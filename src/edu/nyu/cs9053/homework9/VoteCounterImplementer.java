package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class VoteCounterImplementer implements VoteCounter{

    private final Semaphore binarySemaphore;

    VoteCounterImplementer(Semaphore binarySemaphore){
        this.binarySemaphore = binarySemaphore;
    }

    @Override
    public QueueNumber count(Queue from) {
        try {
            binarySemaphore.acquire();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        try {
            if (!from.isEmpty()) {
                return from.getQueueNumber();
            }
            return null;
        }
        finally {
            binarySemaphore.release();
        }
    }
}

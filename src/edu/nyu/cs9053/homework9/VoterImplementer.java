package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class VoterImplementer implements Voter{

    private final Semaphore binarySemaphore;

    VoterImplementer(Semaphore binarySemaphore){
        this.binarySemaphore = binarySemaphore;
    }

    @Override
    public QueueNumber vote(Queue queue) {
        // ret null if need to wait
        try {
            binarySemaphore.acquire();
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
        try {
            if (!queue.full()) {
                Ballot ballot = new BallotImplementer();
                QueueNumber queueNumber = queue.addBallot(ballot); // capcity + 1
                return queueNumber;
            }
            return null;
        }
        finally {
            binarySemaphore.release();
        }
    }
}

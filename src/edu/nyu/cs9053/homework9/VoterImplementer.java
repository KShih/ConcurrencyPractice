package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class VoterImplementer implements Voter{

    private final Semaphore binarySemaphore;

    public VoterImplementer(Semaphore binarySemaphore){
        this.binarySemaphore = binarySemaphore;
    }

    @Override
    public QueueNumber vote(Queue queue) {
        // ret null if need to wait
        try{
            binarySemaphore.acquire();
            try{
                Ballot ballot = new BallotImplementer(binarySemaphore);

                QueueNumber queueNumber = queue.addBallot(ballot); // capcity + 1
                return queueNumber;
            }catch (UnsupportedOperationException uoe){
                // queue is full, need to wait count to remove item
                binarySemaphore.release();
            }
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return null;
    }
}

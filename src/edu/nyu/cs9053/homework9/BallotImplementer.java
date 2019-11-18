package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BallotImplementer implements Ballot {

    private final Semaphore binarySemaphore;

    public BallotImplementer(Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
    }

    @Override
    public boolean isYes() {
        Random random = new Random();

        binarySemaphore.release();
        return random.nextBoolean();
    }
}

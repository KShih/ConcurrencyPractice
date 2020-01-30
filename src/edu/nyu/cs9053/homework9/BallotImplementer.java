package edu.nyu.cs9053.homework9;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class BallotImplementer implements Ballot {

    private Random random;

    BallotImplementer(){
        random = new Random();
    }

    @Override
    public boolean isYes() {
        return random.nextBoolean();
    }
}

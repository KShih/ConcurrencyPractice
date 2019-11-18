package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {

    private static final Semaphore binarySemaphore = new Semaphore(1);

    public static Voter createVoter() {
        return new VoterImplementer(binarySemaphore);
    }

    public static VoteCounter createVoteCounter() {
        return new VoteCounterImplementer(binarySemaphore);
    }
}

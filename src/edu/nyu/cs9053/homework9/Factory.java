package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {

    private static final Semaphore BINARY_SEMAPHORE = new Semaphore(1);

    public static Voter createVoter() {
        return new VoterImplementer(BINARY_SEMAPHORE);
    }

    public static VoteCounter createVoteCounter() {
        return new VoteCounterImplementer(BINARY_SEMAPHORE);
    }
}

package it.g2.commons;

import java.util.Random;

/**
 * Created by gigitsu on 08/02/15.
 */
public abstract class Algorithm {
    private int opcount = 0;

    public int getOpCount() { return opcount; }

    protected void resetOpCount() { opcount = 0; }

    protected void incOpCount() { ++opcount; }

    protected static final class RandomNumberGeneratorHolder {
        public static final Random randomNumberGenerator = new Random();
    }
}

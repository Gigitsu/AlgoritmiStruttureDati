package it.g2.Labs.l20100111.monomeri;

import it.g2.Labs.l20100111.exceptions.IllegalAminoacido;

import java.util.Arrays;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Aminoacido extends Monomero {
    private static String[] allowed = {"aalanina", "ccistenina", "dacido aspartico", "eacido glutamminico", "ffenilanina"};

    public Aminoacido(Character symbol, String name) {
        super(symbol, name);
    }

    @Override
    protected void checkValues(Character symbol, String name) {
        if (Arrays.binarySearch(allowed, (symbol + name).toLowerCase()) < 0)
            throw new IllegalAminoacido(symbol, name);
    }
}

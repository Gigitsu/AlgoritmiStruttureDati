package it.g2.Labs.l20100111.exceptions;

/**
 * Created by gigitsu on 10/02/15.
 */
public abstract class IllegalMonomero extends IllegalArgumentException {
    public IllegalMonomero(Character symbol, String name, String monomero) {
        super("La combinazione " + symbol + " + " + name +
                " non corrisponde a nessun " + monomero + " noto");
    }
}

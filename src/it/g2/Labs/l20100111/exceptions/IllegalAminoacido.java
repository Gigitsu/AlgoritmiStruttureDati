package it.g2.Labs.l20100111.exceptions;

/**
 * Created by gigitsu on 10/02/15.
 */
public class IllegalAminoacido extends IllegalMonomero {
    public IllegalAminoacido(Character symbol, String name) {
        super(symbol, name, "Aminoacido");
    }
}

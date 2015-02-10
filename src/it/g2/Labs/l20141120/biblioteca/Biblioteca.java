package it.g2.Labs.l20141120.biblioteca;

import it.g2.Labs.l20141120.biblioteca.strutture.ArrayDict;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Biblioteca extends BibliotecaAbs {
    public Biblioteca() {
        volumi = new ArrayDict<String, Record>();
    }
}

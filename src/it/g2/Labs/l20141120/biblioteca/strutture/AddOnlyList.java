package it.g2.Labs.l20141120.biblioteca.strutture;

/**
 * Created by gigitsu on 10/02/15.
 */
public interface AddOnlyList<S> extends Iterable<S> {
    void add(S e);
    String toString();
}

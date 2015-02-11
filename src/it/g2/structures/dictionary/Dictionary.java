package it.g2.structures.dictionary;

/**
 * Created by gigitsu on 09/02/15.
 */
public interface Dictionary<K extends Comparable<? super K>, E> {
    void insert(K key, E item);
    void delete(K key);
    E search (K key);
}

package it.g2.Labs.l20141120.biblioteca.strutture;

/**
 * Created by gigitsu on 10/02/15.
 */
public interface Dictionary<K, V> extends Iterable<V> {
    void insert(K key, V item);
    void delete(K key);
    V search(K key);
}

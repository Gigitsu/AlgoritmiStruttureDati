package it.g2.structures.dictionary;

import it.g2.search.BinarySearch;

import java.util.Arrays;

/**
 * Created by gigitsu on 09/02/15.
 */
public class RawDictionary<K extends Comparable<? super K>,E> extends AbstractDictionary<K, E> {
    @SuppressWarnings("unchecked")
    private Pair<K, E>[] buffer = new Pair[0];
    private BinarySearch searcher = new BinarySearch();

    public void insert(K key, E item) {
        Pair<K, E> p = new Pair<>(key, item);

        int f = searcher.indexOf(Arrays.asList(buffer), p);
        if (f >= 0) {
            buffer[f] = p;
            return;
        }

        Pair<K, E>[] tmp = buffer;
        buffer = new Pair[buffer.length + 1];

        int i = 0;
        while (i < tmp.length) {
            if (tmp[i].compareTo(p) < 0)
                buffer[i] = tmp[i++];
            else
                break;
        }

        buffer[i++] = p;

        //i += i < tmp.length && tmp[i].compareTo(p) == 0 ? 2 : 1;

        while (i < tmp.length + 1) {
            buffer[i] = tmp[i - 1];
            ++i;
        }
    }

    public void delete(K key) {
        Pair<K, E> p = new Pair<>(key, null);
        int f = searcher.indexOf(Arrays.asList(buffer), p);
        if (f < 0) throw new IllegalArgumentException("Key not found");

        Pair<K, E>[] tmp = buffer;
        buffer = new Pair[buffer.length - 1];

        System.arraycopy(tmp, 0, buffer, 0, f);
        System.arraycopy(tmp, f+1, buffer, f, tmp.length - f - 1);

    }

    public E search(K key) {
        Pair<K, E> p = new Pair<>(key, null);
        int f = searcher.indexOf(Arrays.asList(buffer), p);
        if (f < 0) throw new IllegalArgumentException("Key not found");
        return buffer[f].getItem();
    }
}

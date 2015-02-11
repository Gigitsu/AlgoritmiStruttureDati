package it.g2.structures.dictionary;

import it.g2.commons.HalvingDoublingArray;
import it.g2.search.SequentialSearch;

/**
 * Created by gigitsu on 09/02/15.
 */
public class HalvingDoublingDictionary<K extends Comparable<? super K>, E> extends AbstractDictionary<K, E> {
    private SequentialSearch searcher = new SequentialSearch();
    private HalvingDoublingArray<Pair<K, E>> buffer = new HalvingDoublingArray<>();

    @Override
    public void insert(K key, E item) {
        Pair<K, E> p = new Pair<>(key, item);
        int f = searcher.indexOf(buffer, p);

        if (f < 0) buffer.add(p);
        else buffer.set(f, p);
    }

    @Override
    public void delete(K key) {
        int f = searcher.indexOf(buffer, new Pair<K, E>(key, null));
        if (f < 0) throw new IllegalArgumentException("Key not found");
        buffer.remove(f);
    }

    @Override
    public E search(K key) {
        int f = searcher.indexOf(buffer, new Pair<K, E>(key, null));
        if (f < 0) throw new IllegalArgumentException("Key not found");
        return buffer.get(f).getItem();
    }
}

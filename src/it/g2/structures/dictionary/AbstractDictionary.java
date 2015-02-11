package it.g2.structures.dictionary;

/**
 * Created by gigitsu on 09/02/15.
 */
public abstract class AbstractDictionary<K extends Comparable<? super K>, E> implements Dictionary<K,E> {
    protected class Pair<K extends Comparable<? super K>, E> implements Comparable<Pair<K, E>> {
        private K key;
        private E item;

        public Pair(K key, E item) {
            this.key = key;
            this.item = item;
        }

        public E getItem() { return item; }

        @Override
        @SuppressWarnings("unchecked")
        public int compareTo(Pair o) {
            return key.compareTo((K)o.key);
        }
    }
}

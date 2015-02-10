package it.g2.Labs.l20141120.biblioteca.strutture;

import java.util.Iterator;

/**
 * Created by gigitsu on 10/02/15.
 */
public class ArrayDict<K, V> implements Dictionary<K, V> {
    private int n = -1;
    private Coppia[] list = new Coppia[1];

    @Override
    public void insert(K key, V item) {
        if (search(key) != null)
            throw new IllegalArgumentException("Chiave " + key + " già usata");

        if (n == list.length - 1) {
            Coppia[] tmp = list;
            list = new Coppia[tmp.length*2];
            System.arraycopy(tmp, 0, list, 0, tmp.length);
        }

        list[++n] = new Coppia<K, V>(key, item);
    }

    @Override
    public void delete(K key) {
        int i = indexOf(key);

        if (i < 0) throw new IllegalArgumentException("Chiave " + key + " non trovata");

        if ((n - 1) < list.length / 4) {
            Coppia[] tmp = list;
            list = new Coppia[tmp.length/2];
            System.arraycopy(tmp, 0, list, 0, n + 1);
        }

        for (int j = i; j < n; j++)
            list[i] = list[i+1];

        n--;
    }

    @Override
    public V search(K key) {
        int i = indexOf(key);

        if (i < 0 ) return null;
        else return (V)list[i].getItem();
    }

    private int indexOf(K key) {
        for (int i = 0; i <= n; i++)
            if (list[i].getKey().equals(key))
                return i;

        return -1;
    }

    @Override
    public Iterator<V> iterator() {
        return new DictIterator<>((Coppia<K,V>[])list);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Coppia c:list) {
            sb.append("Posizione [ ");
            sb.append(c.getKey());
            sb.append(" ] Volume [ ");
            sb.append(c.getItem());
            sb.append(" ];" + System.getProperty("line.separator"));
        }
        return sb.toString();
    }

    private class Coppia<T, E> {
        private T key;
        private E item;

        public Coppia(T key, E item) {
            this.key = key;
            this.item = item;
        }

        public E getItem() {
            return item;
        }

        public T getKey() {
            return key;
        }

        @Override
        public boolean equals(Object obj) {
            try {
                Coppia<T, E> c = (Coppia<T, E>)obj;
                return c.key.equals(key);
            } catch (ClassCastException e) {
                return false;
            }
        }
    }

    private class DictIterator<E> implements Iterator<E> {
        int i = 0;
        private Coppia<?, E>[] list;

        public DictIterator(Coppia<?, E>[] list) {
            this.list = list;
        }

        @Override
        public boolean hasNext() {
            return i < list.length;
        }

        @Override
        public E next() {
            return list[i++].getItem();
        }
    }
}

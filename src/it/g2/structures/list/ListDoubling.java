package it.g2.structures.list;

import it.g2.commons.HalvingDoublingArray;

import java.util.Iterator;

/**
 * Created by gigitsu on 10/02/15.
 */
public class ListDoubling<T> implements List<Index, T> {
    private HalvingDoublingArray<T> buffer = new HalvingDoublingArray<>();

    @Override
    public boolean isEmpty() {
        return buffer.size() == 0;
    }

    @Override
    public T readList(Index index) {
        return buffer.get(index.getIndex());
    }

    @Override
    public void writeList(T e, Index index) {
        buffer.set(index.getIndex(), e);
    }

    @Override
    public Index firstList() {
        return new Index();
    }

    @Override
    public boolean endList(Index index) {
        return index.getIndex() == buffer.size();
    }

    @Override
    public Index next(Index index) {
        if (endList(index))
            throw new IllegalArgumentException("Raggiunto fine lista");

        return new Index(index.getIndex()+1);
    }

    @Override
    public Index previous(Index index) {
        if (firstList().equals(index))
            throw new IllegalArgumentException("Primo lista, nessun precedente");

        return new Index(index.getIndex()-1);
    }

    @Override
    public void insert(T e, Index index) {
        if (endList(index)) buffer.add(e);
        else buffer.add(index.getIndex(), e);
    }

    @Override
    public void remove(Index index) {
        if (endList(index))
            throw new IllegalArgumentException("Impossibile rimuovere fine lista");
        buffer.remove(index.getIndex());
    }

    @Override
    public Iterator<T> iterator() {
        return new ListDoublingIterator<>();
    }

    private class ListDoublingIterator<E> implements Iterator<E> {
        Index i = new Index();

        @Override
        public boolean hasNext() {
            return !endList(i);
        }

        @Override
        public E next() {
            @SuppressWarnings("unchecked")
            E item = (E) readList(i);
            i = ListDoubling.this.next(i);
            return item;
        }
    }
}

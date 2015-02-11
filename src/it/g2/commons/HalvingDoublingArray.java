package it.g2.commons;

import java.util.*;

/**
 * Created by gigitsu on 13/01/15.
 */
public class HalvingDoublingArray<T> implements List<T> {
    private Object[] buffer;
    private int s = -1; //last useful index

    public HalvingDoublingArray() {
        this(10);
    }

    public HalvingDoublingArray(int size) {
        this.buffer = new Object[size];
    }

    public int size() {
        return s +1;
    }

    public T pop() {
        T t = get(s);
        if(buffer.length / 4 >= --s) halving();

        return t;
    }

    public void push(T item) {
        try {
            buffer[++s] = item;
        } catch (ArrayIndexOutOfBoundsException e) {
            doubling();
            buffer[s] = item;
        }
    }

    @Override
    public boolean isEmpty() {
        return s >= 0;
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        @SuppressWarnings("unchecked")
        final T t = (T) buffer[index];
        return t;
    }

    @Override
    public T set(int index, T item) {
        checkIndex(index);

        buffer[index] = item;
        return item;
    }

    @Override
    public boolean add(T item) {
        push(item);
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index > s) throw new ArrayIndexOutOfBoundsException(index);

        add((T)buffer[s]);

        for (int i = s-1; i > index; i--)
            buffer[i] = buffer[i-1];

        buffer[index] = element;
    }

    @Override
    public T remove(int index) {
        @SuppressWarnings("unchecked")
        T item = (T)buffer[index];

        for (int i = index; i < s; i++)
            buffer[i] = buffer[i+1];

        pop(); //remove last item and trigger halving if necessary
        return item;
    }

    @Override
    public void clear() {
        this.buffer = new Objects[10];
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(buffer, s);
    }

    @Override
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new HalvingDoublingIterator<>(index);
    }

    @Override
    public Iterator<T> iterator() {
        return listIterator();
    }

    private void doubling() {
        Object[] temp = buffer;
        buffer = new Object[Math.max(temp.length, 1) * 2];
        System.arraycopy(temp, 0, buffer, 0, temp.length);
    }

    private void halving() {
        buffer = Arrays.copyOf(buffer, buffer.length / 2);
    }

    private void checkIndex(int index) {
        if(index > s) throw new ArrayIndexOutOfBoundsException(index);
    }

    //region Unsupported operations
    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }
    //endregion

    private class HalvingDoublingIterator<E> implements ListIterator<E> {
        private int i;

        public HalvingDoublingIterator(int index) {
            i = index;
        }

        @Override
        public boolean hasNext() {
            return i <= s;
        }

        @Override
        public E next() {
            checkIndex(i);

            @SuppressWarnings("unchecked")
            E item = (E)buffer[i++];
            return item;
        }

        @Override
        public boolean hasPrevious() {
            return i >= 0;
        }

        @Override
        public E previous() {
            checkIndex(i);

            @SuppressWarnings("unchecked")
            E item = (E)buffer[i--];
            return item;
        }

        @Override
        public int nextIndex() {
            return i + 1;
        }

        @Override
        public int previousIndex() {
            return i - 1;
        }

        //region Unsupported operations
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(E t) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(E item) {
            throw new UnsupportedOperationException();
        }
        //endregion
    }
}

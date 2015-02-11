package it.g2.structures.list;

import java.util.Iterator;

/**
 * Created by gigitsu on 10/02/15.
 */
public class ListCursor<T> implements List<Cursor, T> {
    private static final int MAX_LENGTH = 100;
    private static Cursor freePosition = new Cursor(1);
    private static Cell<Cursor, Object>[] space = new Cell[MAX_LENGTH];
    static {
        int i = 0;
        space[i++] = new Cell<>(new Cursor(), null);
        for (; i < space.length - 1;)
            space[i] = new Cell<>(new Cursor(++i), null);

        space[i] = new Cell<>(new Cursor(), null);
    }

    private Cursor firstItemPosition = null;

    @Override
    public boolean isEmpty() {
        return firstItemPosition == null;
    }

    @Override
    public Cursor firstList() {
        return new Cursor();
    }

    @Override
    public T readList(Cursor cursor) {
        @SuppressWarnings("unchecked")
        T item = (T) space[getPosition(cursor).getCursor()].getItem();
        return item;
    }

    @Override
    public void writeList(T e, Cursor cursor) {
        space[getPosition(cursor).getCursor()].setItem(e);
    }

    @Override
    public boolean endList(Cursor cursor) {
        return (isEmpty() && cursor.equals(firstList())) ||
                getPosition(cursor).equals(new Cursor());
    }

    @Override
    public Cursor next(Cursor cursor) {
        if (endList(cursor)) throw new IndexOutOfBoundsException("Raggiunto fine lista");
        else return getPosition(cursor);
    }

    @Override
    public Cursor previous(Cursor cursor) {
        if (cursor.equals(firstList()))
            throw new IndexOutOfBoundsException("Nessun precedente per primo list");

        for (Cursor tmp = firstList(); !endList(tmp); tmp=next(tmp))
            if (cursor.equals(next(tmp)))
                return tmp;

        throw new IndexOutOfBoundsException("Posizione non trovata");
    }

    @Override
    public void insert(T e, Cursor cursor) {
        if (!cursor.equals(firstList()))
            checkCursorOwnership(cursor);

        if (isEmpty())
            firstItemPosition = new Cursor();

        Cursor next = getPosition(cursor);
        Cursor available = getAvailablePosition();

        space[available.getCursor()] = new Cell<Cursor, Object>(next, e);

        if (cursor.equals(firstList()))
            firstItemPosition = available;
        else
            space[cursor.getCursor()].setNext(available);
    }

    @Override
    public void remove(Cursor cursor) {
        if (!cursor.equals(firstList()))
            checkCursorOwnership(cursor);

        Cursor torm = getPosition(cursor); // to remove

        if (cursor.equals(firstList()))
            firstItemPosition = space[torm.getCursor()].getNext();
        else
            space[cursor.getCursor()].setNext(
                    space[torm.getCursor()].getNext()
            );

        space[torm.getCursor()].setNext(freePosition);
        freePosition = torm;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListCursorIterator<>();
    }

    private Cursor getAvailablePosition() {
        Cursor n = freePosition;
        freePosition = space[freePosition.getCursor()].getNext();
        return n;
    }

    private Cursor getPosition(Cursor cursor) {
        if (cursor.equals(firstList()) && !isEmpty())
            return firstItemPosition;
        else if (checkCursorOwnership(cursor))
            return space[cursor.getCursor()].getNext();

        throw new IllegalArgumentException("Posizione non valida");
    }

    private boolean checkCursorOwnership(Cursor c) {
        for (Cursor tmp = firstItemPosition; !tmp.equals(new Cursor()); tmp = space[tmp.getCursor()].getNext())
            if (c.equals(tmp)) return true;

        return false;
    }

    private class ListCursorIterator<E> implements Iterator<E> {
        Cursor c = firstList();

        @Override
        public boolean hasNext() {
            return !endList(c);
        }

        @Override
        public E next() {
            @SuppressWarnings("unchecked")
            E item = (E)readList(c);
            c = ListCursor.this.next(c);
            return item;
        }
    }
}

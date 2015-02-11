package it.g2.structures.list;

/**
 * Created by gigitsu on 10/02/15.
 */
class Cell<P extends Position, T> {
    private T item;
    private P next;

    public Cell(P cursor, T item) {
        this.item = item;
        this.next = cursor;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public void setNext(P next) {
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public P getNext() {
        return next;
    }
}

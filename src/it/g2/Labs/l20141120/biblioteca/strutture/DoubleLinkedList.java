package it.g2.Labs.l20141120.biblioteca.strutture;

import java.util.Iterator;

/**
 * Created by gigitsu on 10/02/15.
 */
public class DoubleLinkedList<S> implements AddOnlyList<S> {
    private Item<S> head = null;
    private Item<S> tail = null;

    public DoubleLinkedList() { }
    public DoubleLinkedList(S[] initial) {
        for (S i:initial)
            add(i);
    }

    @Override
    public void add(S e) {
        Item<S> item = new Item<>(e, null, tail);
        if (head == null) head = item;
        if (tail != null) tail.setNext(item);
        tail = item;
    }

    @Override
    public Iterator<S> iterator() {
        return new DoubleLinkedIterator<>(head);
    }

    private class Item<E> {
        private E value;
        private Item<E> next;
        private Item<E> previous;

        public Item(E value, Item<E> next, Item<E> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public E getValue() {
            return value;
        }

        public void setNext(Item<E> next) {
            this.next = next;
        }

        public Item<E> getNext() {
            return next;
        }

        public Item<E> getPrevious() {
            return previous;
        }
    }

    private class DoubleLinkedIterator<E> implements Iterator<E> {
        private Item<E> current;

        public DoubleLinkedIterator(Item<E> head) {
            this.current = new Item<>(null, head, null);
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            current = current.getNext();
            return current.getValue();
        }
    }
}

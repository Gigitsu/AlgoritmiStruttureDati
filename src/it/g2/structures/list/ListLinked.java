package it.g2.structures.list;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gigitsu on 18/02/15.
 */
public class ListLinked<T> implements List<Pointer<T>, T> {
	private Pointer<T> head = new Pointer<>(new Cell<Pointer<T>, T>(null, null));

	@Override
	public boolean isEmpty() {
		return head.getLink().getNext() == null && head.getLink().getItem() == null;
	}

	@Override
	public boolean endList(Pointer<T> p) {
		return p.getLink().getNext() == null;
	}

	@Override
	public T readList(Pointer<T> p) {
		return getCell(p).getItem();
	}

	@Override
	public void writeList(T e, Pointer<T> p) {
		getCell(p).setItem(e);
	}

	@Override
	public Pointer<T> firstList() {
		return head;
	}

	@Override
	public Pointer<T> next(Pointer<T> p) {
		return getCell(p).getNext();
	}

	@Override
	public Pointer<T> previous(Pointer<T> p) {
		if (p.equals(head))
			throw new IndexOutOfBoundsException("Nessun precedente per primo lista");

		for (Pointer<T> tmp = head; !endList(tmp); tmp = next(tmp))
			if (tmp.getLink().getNext().equals(p))
				return tmp;

		throw new IndexOutOfBoundsException("Posizione non trovata");
	}

	@Override
	public void insert(T e, Pointer<T> p) {
		Cell<Pointer<T>, T> nc = new Cell<>(new Pointer<>(p.getLink()), e);
		p.setLink(nc);
	}

	@Override
	public void remove(Pointer<T> p) {
		Cell<Pointer<T>, T> torm = getCell(p);
		p.setLink(torm.getNext().getLink());
	}

	@Override
	public Iterator<T> iterator() {
		return new ListLinkedIterator<>();
	}

	private Cell<Pointer<T>, T> getCell(Pointer<T> p) {
		if (endList(p))
			throw new IllegalArgumentException("Posizione non valida");

		return p.getLink();
	}

	private class ListLinkedIterator<E> implements Iterator<E> {
		private Pointer current = head;

		@Override
		public boolean hasNext() {
			return !endList(current);
		}

		@Override
		public E next() {
			@SuppressWarnings("unchecked")
			E item = (E)readList(current);
			current = ListLinked.this.next(current);
			return item;
		}
	}
}

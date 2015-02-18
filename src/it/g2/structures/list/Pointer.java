package it.g2.structures.list;

/**
 * Created by gigitsu on 18/02/15.
 */
public class Pointer<T> implements Position {
	private Cell<Pointer<T>, T> link;

	public Pointer(Cell<Pointer<T>, T> link) {
		this.link = link;
	}

	public Cell<Pointer<T>, T> getLink() {
		return link;
	}

	public void setLink(Cell<Pointer<T>, T> link) {
		this.link = link;
	}
}

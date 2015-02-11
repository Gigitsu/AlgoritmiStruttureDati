package it.g2.structures.list;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Cursor implements Position {
    private int i;

    public Cursor() {
        this(0);
    }

    public Cursor(int i) {
        this.i = i;
    }

    public void setCursor(int cursor) {
        this.i = cursor;
    }

    public int getCursor() {
        return i;
    }

    @Override
    public boolean equals(Object obj) {
        return  obj != null &&
                getClass().equals(obj.getClass()) &&
                i == ((Cursor) obj).getCursor();
    }
}

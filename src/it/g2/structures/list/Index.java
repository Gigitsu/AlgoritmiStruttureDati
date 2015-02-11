package it.g2.structures.list;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Index implements Position {
    private int i;

    public Index() {
        this(0);
    }

    public Index(int i) {
        this.i = i;
    }

    public int getIndex() {
        return i;
    }

    @Override
    public boolean equals(Object obj) {
        return getClass().equals(obj.getClass()) &&
                i == ((Index) obj).getIndex();
    }
}

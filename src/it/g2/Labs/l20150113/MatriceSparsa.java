package it.g2.Labs.l20150113;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by gigitsu on 09/02/15.
 */
public class MatriceSparsa<T> implements Iterable<T> {
    private T dvalue;
    private int nrows;
    private int ncols;
    protected ArrayList<Record<T>>[] values;

    public MatriceSparsa(int nrows, int ncols, T dvalue) {
        this.dvalue = dvalue;
        this.nrows = nrows;
        this.ncols = ncols;

        values = new ArrayList[nrows];

        for (int i = 0; i < nrows; i++)
            values[i] = new ArrayList<>(ncols);
    }

    public void cambiaValore(int row, int col, T value) {
        checkIndex(row, col);

        ArrayList<Record<T>> r = values[row];
        Record<T> c = new Record<>(col, value);
        int p = r.indexOf(c);

        if (p > 0) r.set(p, c);
        else r.add(c);
    }

    public T valore(int row, int col) {
        checkIndex(row, col);

        ArrayList<Record<T>> r = values[row];

        Record<T> c = new Record<>(col, null);
        int p = r.indexOf(c);

        if(p >= 0) return r.get(p).getValue();

        return dvalue;
    }

    public int numRighe() {
        return nrows;
    }

    public int numColonne() {
        return ncols;
    }

    public int numValoriSignificativi() {
        int n = 0;
        for (ArrayList<Record<T>> r:values)
            n += r.size();

        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new SparseMatrixIterator<>();
    }

    private void checkIndex(int row, int col) {
        if(row > nrows)
            throw new IndexOutOfBoundsException("La riga " + row + " non esiste");

        if (col > ncols)
            throw new IndexOutOfBoundsException("La colonna " + col + " non esiste");
    }

    private class Record<E> {
        private E value;
        private int col;

        public Record(int col, E value) {
            this.value = value;
            this.col = col;
        }

        public E getValue() {
            return value;
        }

        public int getCol() {
            return col;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Record)
                return ((Record)obj).col == this.col;

            return super.equals(obj);
        }
    }

    private class SparseMatrixIterator<E> implements Iterator<E> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < ncols * nrows;
        }

        @Override
        public E next() {
            int col = i % ncols;
            int row = (int)Math.floor(i / ncols);

            i++;

            @SuppressWarnings("unchecked")
            E item = (E)valore(row, col);
            return item;
        }
    }
}

package it.g2.Labs.l20100111;

import java.util.ArrayList;

/**
 * Created by gigitsu on 10/02/15.
 */
public class AList implements  ListaSemplice {
    int i = 0;
    ArrayList<Object> list = new ArrayList<>();

    @Override
    public void add(Object o) { list.add(o); }

    @Override
    public void reset() { i = 0; }

    @Override
    public Object next() {
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < list.size();
    }
}

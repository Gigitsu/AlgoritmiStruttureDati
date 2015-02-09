package it.g2.search;

import it.g2.commons.Algorithm;

import java.util.List;

/**
 * Created by gigitsu on 08/02/15.
 */
public abstract class AbstractSearch extends Algorithm {
    public static final int ASC = 1;
    public static final int DESC = -1;

    public <T extends Comparable<? super T>> int indexOf(List<T> list, T item) {
        return indexOf(list, item, ASC);
    }
    public abstract <T extends Comparable<? super T>> int indexOf(List<T> list, T item, int order);
}

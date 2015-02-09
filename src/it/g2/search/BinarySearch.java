package it.g2.search;

import java.util.List;

/**
 * Created by gigitsu on 08/02/15.
 */
public class BinarySearch extends AbstractSearch {
    @Override
    public <T extends Comparable<? super T>> int indexOf(List<T> list, T item, int order) {
        resetOpCount();

        return recursiveSearch(list, item, 0, list.size()-1, order);
    }

    private <T extends Comparable<? super T>> int recursiveSearch(List<T> list, T item, int from, int to, int order) {
        if (from > to) return -1;

        int m = (from + to) / 2;
        int c = item.compareTo(list.get(m))*order;

        incOpCount();
        if (c == 0) return m;
        else {
            incOpCount();
            return c < 0 ?
                    recursiveSearch(list, item, from, m-1, order) : //search in left  side
                    recursiveSearch(list, item, m+1, to, order);    //search in right side
        }
    }

}

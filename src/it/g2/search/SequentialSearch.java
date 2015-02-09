package it.g2.search;

import java.util.List;

/**
 * Created by gigitsu on 08/02/15.
 */
public class SequentialSearch extends AbstractSearch {
    @Override
    public <T extends Comparable<? super T>> int indexOf(List<T> list, T item, int order) {
        resetOpCount();

        for (int i = 0; i < list.size(); i++) {
            incOpCount();
            if (item.compareTo(list.get(i)) == 0)
                return i;
        }
        return -1;
    }
}

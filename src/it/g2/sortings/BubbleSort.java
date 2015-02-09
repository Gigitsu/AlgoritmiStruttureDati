package it.g2.sortings;

import java.util.List;

/**
 * Created by gigitsu on 07/02/15.
 */
public class BubbleSort extends AbstractSort {
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, int order) {
        resetOpCount();

        for (int i = 1; i < list.size(); i++) {
            T item = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                incOpCount();
                if (isUnordered(list.get(j), item, order))
                    swap(list, j, j + 1);
                else break;
            }
        }
    }
}

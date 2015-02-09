package it.g2.sortings;

import java.util.List;

/**
 * Created by gigitsu on 07/02/15.
 */
public class SelectionSort extends AbstractSort {
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, int order) {
        resetOpCount();

        for (int i = 0; i < list.size()-1; i++) {
            int min = indexOfMin(list, i, order);
            if (min != i) swap(list, min, i);
        }
    }
}

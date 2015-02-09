package it.g2.sortings;

import java.util.List;

/**
 * Created by gigitsu on 07/02/15.
 */
public class InsertionSort extends AbstractSort {
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, int order) {
        resetOpCount();

        swap(list, indexOfMin(list, 0, order), 0);
        for (int i = 2; i < list.size(); i++) {
            T item = list.get(i);
            for (int j = i-1; j >= 0; j--) {
                incOpCount();
                if (isUnordered(list.get(j), item, order)){
                    list.set(j+1, list.get(j));
                } else {
                    list.set(j+1, item);
                    break;
                }
            }
        }
    }
}

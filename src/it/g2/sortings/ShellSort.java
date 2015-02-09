package it.g2.sortings;

import java.util.List;

/**
 * Created by gigitsu on 08/02/15.
 */
public class ShellSort extends AbstractSort {
    @Override
    public <T extends Comparable<? super T>> void sort(List<T> list, int order) {
        resetOpCount();

        int inc = list.size() / 2;
        while (inc>0) {
            for (int i = 0; i < inc; i++) {
                for (int j = i + inc; j < list.size(); j += inc) {
                    T item = list.get(j);
                    for (int k = j - inc; k >= i; k -= inc) {
                        incOpCount();
                        if (isUnordered(list.get(k), item, order))
                            swap(list, k, k + inc);
                        else
                            break;
                    }
                }
            }
            inc = inc / 2;
        }
    }
}

package it.g2.sortings;

import java.util.Comparator;
import java.util.List;

/**
 * Created by gigitsu on 08/02/15.
 */
public class QuickSort extends AbstractSort {
    @Override
    public <T extends Comparable<T>> void sort(List<T> list, int order) {
        resetOpCount();
        recursiveSort(list, 0, list.size() - 1, order);
    }

    private <T extends Comparable<T>> void recursiveSort(List<T> list, int from, int to, int order) {
        if (to - from < 1) return;

        int split = partition(list, from, to, order);
        if(to - split + 1 > split - from) {
            recursiveSort(list, from, split - 1, order);
            recursiveSort(list, split + 1, to, order);
        } else {
            recursiveSort(list, split + 1, to, order);
            recursiveSort(list, from, split - 1, order);
        }
    }

    private <T extends Comparable<T>> int partition(List<T> list, int from, int to, int order) {
        int i = from + 1; int j = to; int m = (from + to)/2;
        T pivot = list.get(m);
        swap(list, from, m);

        while (true) {

            incOpCount();
            while (i <= to && isOrdered(list.get(i), pivot, order)) {
                ++i;
                incOpCount();
            }

            incOpCount();
            while (isOrdered(pivot, list.get(j), order)) {
                --j;
                incOpCount();
            }

            if (i<j) swap(list, i, j);
            else break;
        }

        swap(list, from, j);
        return j;
    }
}

package it.g2.sortings;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gigitsu on 08/02/15.
 */
public class MergeSort extends AbstractSort {
    @Override
    public <T extends Comparable<T>> void sort(List<T> list, int order) {
        resetOpCount();
        recursiveSort(list, 0, list.size()-1, order);
    }

    private <T extends Comparable<T>> void recursiveSort(List<T> list, int from, int to, int order) {
        if (from >= to) return;

        int m = (from + to) / 2;
        recursiveSort(list, from, m, order);
        recursiveSort(list, m+1, to, order);
        merge(list, from, m, to, order);
    }

    private <T extends Comparable<T>> void merge(List<T> list, int from, int m, int to, int order) {
        ArrayList<T> aus = new ArrayList<>(to-from);
        int i = from;
        int j = m+1;

        while (i <= m && j <= to) {
            incOpCount();
            if (isOrdered(list.get(i), list.get(j), order))
                aus.add(list.get(i++));
            else
                aus.add(list.get(j++));
        }

        if (i <= m) for (int k = 0; k <= m - i; k++)
            list.set(to - k, list.get(m - k));

        for (int k = 0; k < aus.size(); k++)
            list.set(k + from, aus.get(k));

    }

}

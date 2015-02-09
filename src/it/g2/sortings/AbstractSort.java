package it.g2.sortings;

import it.g2.commons.Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gigitsu on 07/02/15.
 */
public abstract class AbstractSort extends Algorithm {

    public static final int ASC = 1;
    public static final int DESC = -1;

    public <T extends Comparable<? super T>> void sort(List<T> list) {
        sort(list, ASC);
    }
    public abstract <T extends Comparable<? super T>> void sort(List<T> list, int order);

    public static List<Integer> mkRandomList() {
        return mkRandomList( RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(1000) );
    }

    public static List<Integer> mkRandomList(int size) {
        List<Integer> ls = new ArrayList<Integer>(size);

        for (int i = 0; i < size; ++i)
            ls.add( i, RandomNumberGeneratorHolder.randomNumberGenerator.nextInt(size*3) );

        return ls;
    }

    protected <T> void swap(List<T> list, int from, int to) {
        T tmp = list.get(to);
        list.set(to, list.get(from));
        list.set(from, tmp);
    }

    protected <T extends Comparable<? super T>> boolean isOrdered(T first, T second, int order) {
        return isUnordered(first, second, order*DESC);
    }

    protected <T extends Comparable<? super T>> boolean isUnordered(T first, T second, int order) {
        return order*first.compareTo(second) > 0;
    }

    protected <T extends Comparable<? super T>> int indexOfMin(List<T> ls, int offset, int order) {
        int min = offset;
        for (int i = offset+1; i < ls.size(); i++) {
            incOpCount();
            if (isUnordered(ls.get(min), ls.get(i), order))
                min = i;
        }
        return min;
    }
}

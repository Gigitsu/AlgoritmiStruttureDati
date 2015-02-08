package it.g2.sortings;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by gigitsu on 07/02/15.
 */
public class Test {
    public static void startTests() {
        System.out.println("*********** BUBBLE SORT ***********");
        testSorter(new BubbleSort());

        System.out.println("********* SELECTION  SORT *********");
        testSorter(new SelectionSort());

        System.out.println("********* INSERTION  SORT *********");
        testSorter(new InsertionSort());

        System.out.println("*********** SHELL  SORT ***********");
        testSorter(new ShellSort());

        System.out.println("*********** QUICK  SORT ***********");
        testSorter(new QuickSort());

        System.out.println("*********** MERGE  SORT ***********");
        testSorter(new MergeSort());
    }

    private static void testSorter(AbstractSort sorter) {
        List<Integer> rls = AbstractSort.mkRandomList(10);
        List<Integer> wls = Arrays.asList(10,9,8,7,6,5,4,3,2,1);

        System.out.print("Random unsorted: "); printList(rls);
        sorter.sort(rls);
        System.out.print(" => "); printList(rls);
        System.out.println(" in " + sorter.getOpCount() + " ops;");

        System.out.print("Already  sorted: "); printList(rls);
        sorter.sort(rls);
        System.out.print(" => "); printList(rls);
        System.out.println(" in " + sorter.getOpCount() + " ops;");

        System.out.print("Worst  unsorted: "); printList(wls);
        sorter.sort(wls);
        System.out.print(" => "); printList(wls);
        System.out.println(" in " + sorter.getOpCount() + " ops;");

        System.out.println("***********************************");
        System.out.println();
    }

    private static <T extends Comparable> void printList(List<T> list) {
        String patter = "%0"+Collections.max(list).toString().length()+"d ";

        System.out.print("[ ");
        for (T item:list) System.out.print(String.format(patter, item));
        System.out.print("]");
    }
}

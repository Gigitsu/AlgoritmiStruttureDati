package it.g2.search;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gigitsu on 08/02/15.
 */
public class Test {
    public static void startTests() {
        System.out.println("******** SEQUENTIAL SEARCH ********");
        testSearch(new SequentialSearch());

        System.out.println("********** BINARY SEARCH **********");
        testSearch(new BinarySearch());
    }

    private static void testSearch(AbstractSearch searcher) {
        List<Integer> ls  = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> ils = Arrays.asList(10,9,8,7,6,5,4,3,2,1);
        int random = (int) (Math.random()*10);

        System.out.print("Ordered  array [ 1 ... 10 ] indexOf 1 => ");
        System.out.print(searcher.indexOf(ls, 1));
        System.out.println(" in " + searcher.getOpCount() + " ops;");

        System.out.print("Ordered  array [ 1 ... 10 ] indexOf 10 => ");
        System.out.print(searcher.indexOf(ls, 10));
        System.out.println(" in " + searcher.getOpCount() + " ops;");

        System.out.print("Ordered  array [ 1 ... 10 ] indexOf 100 => ");
        System.out.print(searcher.indexOf(ls, 100));
        System.out.println(" in " + searcher.getOpCount() + " ops;");

        System.out.print("Ordered  array [ 1 ... 10 ] indexOf " + random + " => ");
        System.out.print(searcher.indexOf(ls, random));
        System.out.println(" in " + searcher.getOpCount() + " ops;");

        System.out.print("Inverted array [ 10 ... 1 ] indexOf " + random + " => ");
        System.out.print(searcher.indexOf(ils, random, AbstractSearch.DESC));
        System.out.println(" in " + searcher.getOpCount() + " ops;");

        System.out.println("***********************************");
        System.out.println();
    }
}

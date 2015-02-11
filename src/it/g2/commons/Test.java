package it.g2.commons;

import java.util.ListIterator;

/**
 * Created by gigitsu on 09/02/15.
 */
public class Test {
    public static void startTests() {
        testHDA();
    }

    private static void testHDA() {
        System.out.println("Testing halving doubling array class");
        HalvingDoublingArray<Integer> hda = new HalvingDoublingArray<Integer>();
        try {
            hda.get(100);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Upper array index exception 100");
        }
        try {
            hda.get(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Bottom array index exception -1");
        }

        for (int i = 0; i < 100; i++) {
            hda.push(i);
        }
        System.out.println("Inserted " + hda.size() + " elements");
        for (int i = 0; i < 100; i++) {
            hda.pop();
        }
        System.out.println("Removed all elements (new size is: " + hda.size() + ")");

        for (int i = 0; i < 13; i++) {
            hda.push(i);
        }

        ListIterator<Integer> riterator = hda.listIterator(hda.size()-1);

        System.out.print("Loop over " + hda.size() + " items with iterator => ");
        for (int i:hda) System.out.print(String.format("%02d ", i));
        System.out.println();

        System.out.print("Loop over " + hda.size() + " items with reversed iterator => ");
        while (riterator.hasPrevious()) System.out.print(String.format("%02d ", riterator.previous()));
        System.out.println();

        System.out.println("Removing item 5");
        hda.remove(5);
        riterator = hda.listIterator(hda.size()-1);

        System.out.print("Loop over " + hda.size() + " items with iterator => ");
        for (int i:hda) System.out.print(String.format("%02d ", i));
        System.out.println();

        System.out.print("Loop over " + hda.size() + " items with reversed iterator => ");
        while (riterator.hasPrevious()) System.out.print(String.format("%02d ", riterator.previous()));
        System.out.println();

        System.out.println("Reinserting item 5");
        hda.add(5, 5);

        System.out.print("Loop over " + hda.size() + " items with iterator => ");
        for (int i:hda) System.out.print(String.format("%02d ", i));
    }
}

package it.g2.structures;

import it.g2.structures.dictionary.Dictionary;
import it.g2.structures.dictionary.HalvingDoublingDictionary;
import it.g2.structures.dictionary.RawDictionary;
import it.g2.structures.list.List;
import it.g2.structures.list.ListCursor;
import it.g2.structures.list.ListDoubling;
import it.g2.structures.list.Position;

/**
 * Created by gigitsu on 09/02/15.
 */
public class Test {
    public static void startTests() {
        System.out.println("********* RAW  DICTIONARY *********");
        dictionaryTest(new RawDictionary<Integer,String>());

        System.out.println("*** HALVING DOUBLING DICTIONARY ***");
        dictionaryTest(new HalvingDoublingDictionary<Integer, String>());

        System.out.println("********** LIST DOUBLING **********");
        listDoublingTest(new ListDoubling<String>());

        System.out.println("*********** LIST CURSOR ***********");
        listDoublingTest(new ListCursor<String>());
    }

    private static void dictionaryTest(Dictionary<Integer, String> d) {
        System.out.print("Inserting [1 => Dylan]"); d.insert(1, "Dylan");
        System.out.print(" [2 => Groucho]"); d.insert(2, "Groucho");
        System.out.print(" [3 => Sherlock]"); d.insert(3, "Sherlock");
        System.out.print(" [4 => Xabaras]"); d.insert(4, "Xabaras");
        System.out.print(" [5 => John]"); d.insert(5, "John");
        System.out.println(" done.");

        System.out.print("Looking for key 1 => "); System.out.println(d.search(1));
        System.out.print("Looking for key 2 => "); System.out.println(d.search(2));
        System.out.print("Looking for key 3 => "); System.out.println(d.search(3));
        System.out.print("Looking for key 4 => "); System.out.println(d.search(4));
        System.out.print("Looking for key 5 => "); System.out.println(d.search(5));

        System.out.println("Inserting [3 => Watson] with existing key"); d.insert(3, "Watson");
        System.out.print("Looking for key 3 => "); System.out.println(d.search(3));

        System.out.println("Deleting key 4"); d.delete(4);
        System.out.print("Deleting again key 4 => ");
        try {
            d.delete(4);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.print("Looking for deleted key 4 => ");
        try {
            d.search(4);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.print("Looking for not existent key 50 => ");
        try {
            d.search(50);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("Reinserting key [4 => Xabaras]"); d.insert(4, "Xabaras");
        System.out.print("Looking for key 4 => "); System.out.println(d.search(4));
        System.out.println("***********************************");
        System.out.println();
    }

    private static <P extends Position> void listDoublingTest(List<P,String> list) {
        System.out.println("List isEmpty => " + list.isEmpty());

        list.insert(null, list.firstList());
        list.insert("b", list.firstList());
        list.insert("c", list.firstList());
        list.insert("d", list.firstList());
        list.insert("e", list.firstList());

        System.out.print("Filled list => [");

        for (String s:list)
            System.out.print(" " + s);
        System.out.println(" ]");

        System.out.print("Inserting f in second position => [");
        list.insert("f", list.next(list.firstList()));

        for (String s:list)
            System.out.print(" " + s);
        System.out.println(" ]");

        System.out.print("Deleting first element => [");
        list.remove(list.firstList());

        for (String s:list)
            System.out.print(" " + s);
        System.out.println(" ]");

        System.out.print("Deleting last element => [");
        P p = list.firstList();
        P q = p;
        while (!list.endList(p)) {
            q = p;
            p = list.next(p);
        }

        list.remove(q);

        for (String s:list)
            System.out.print(" " + s);
        System.out.println(" ]");

        System.out.print("Deleting third element => [");
        q = list.next(list.next(list.firstList()));
        list.remove(q);

        p = list.firstList();
        while (!list.endList(p)) {
            System.out.print(" " + list.readList(p));
            p = list.next(p);
        }
        System.out.println(" ]");

        System.out.print("Inserting 'fine' as last element => [");
        list.insert("fine", p);

        p = list.firstList();
        while (!list.endList(p)) {
            System.out.print(" " + list.readList(p));
            p = list.next(p);
        }
        System.out.println(" ]");

        System.out.print("Inserting 'pos4' in fourth position => [");
        P posizione4 = list.next(list.next(list.next(list.firstList())));
        list.insert("pos4", posizione4);

        for (String s:list)
            System.out.print(" " + s);
        System.out.println(" ]");

        System.out.print("Inserting new element 'pos3' before fourth element => [");
        list.insert("pos3", list.previous(posizione4));

        for (String s:list)
            System.out.print(" " + s);
        System.out.println(" ]");


        System.out.print("Set fourth element as 'sovrascritto' => [");
        posizione4 = list.next(list.next(list.next(list.firstList())));
        list.writeList("sovrascritto", posizione4);

        for (String s:list)
            System.out.print(" " + s);
        System.out.println(" ]");

        System.out.println("***********************************");
        System.out.println();
    }
}

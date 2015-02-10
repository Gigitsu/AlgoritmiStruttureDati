package it.g2.Labs.l20100111.monomeri;

import java.util.HashMap;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Aminoacidi {

    public static HashMap<Character, Aminoacido> aminoacidi;
    static {
        aminoacidi = new HashMap<>();
        aminoacidi.put('A', new Aminoacido('A', "Alanina"));
        aminoacidi.put('C', new Aminoacido('C', "Cistenina"));
        aminoacidi.put('D', new Aminoacido('D', "Acido aspartico"));
        aminoacidi.put('E', new Aminoacido('E', "Acido glutamminico"));
        aminoacidi.put('F', new Aminoacido('F', "Fenilanina"));
    }
}

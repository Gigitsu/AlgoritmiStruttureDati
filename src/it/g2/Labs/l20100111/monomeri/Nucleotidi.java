package it.g2.Labs.l20100111.monomeri;

import java.util.HashMap;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Nucleotidi {
    public static HashMap<Character, Nucleotide> nucleotidi;
    static {
        nucleotidi = new HashMap<>();
        nucleotidi.put('A', new Nucleotide('A', "Adenina"));
        nucleotidi.put('C', new Nucleotide('C', "Citosina"));
        nucleotidi.put('G', new Nucleotide('G', "Guanina"));
        nucleotidi.put('T', new Nucleotide('T', "Timina"));
    }
}

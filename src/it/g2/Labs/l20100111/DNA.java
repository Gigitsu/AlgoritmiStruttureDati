package it.g2.Labs.l20100111;

import it.g2.Labs.l20100111.monomeri.Nucleotide;

/**
 * Created by gigitsu on 10/02/15.
 */
public class DNA extends Polimero {
    public DNA(Nucleotide[] nucleotidi) {
        super();

        for (Nucleotide a:nucleotidi)
            add(a);
    }

    public void add(Nucleotide nucleotide) {
        sequenza.add(nucleotide);
    }
}

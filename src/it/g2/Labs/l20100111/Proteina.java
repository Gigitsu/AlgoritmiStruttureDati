package it.g2.Labs.l20100111;

import it.g2.Labs.l20100111.monomeri.Aminoacido;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Proteina extends Polimero {

    public Proteina(Aminoacido[] aminoacidi) {
        super();

        for (Aminoacido a:aminoacidi)
            add(a);
    }

    public void add(Aminoacido aminoacido) {
        sequenza.add(aminoacido);
    }
}

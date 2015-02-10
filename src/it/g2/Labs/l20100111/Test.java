package it.g2.Labs.l20100111;

import it.g2.Labs.l20100111.monomeri.Aminoacidi;
import it.g2.Labs.l20100111.monomeri.Aminoacido;
import it.g2.Labs.l20100111.monomeri.Nucleotide;
import it.g2.Labs.l20100111.monomeri.Nucleotidi;

import java.util.Random;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Test {
    public void main() {
        Nucleotide[] n = new Nucleotide[15];
        Aminoacido[] a = new Aminoacido[15];

        Character[] an = {'A','C','G','T'};
        Character[] aa = {'A','C','D','E', 'F'};

        Random r = new Random();

        for (int i = 0; i < 15; i++) {
            n[i] = Nucleotidi.nucleotidi.get(
                    an[r.nextInt(an.length)]
            );
        }

        for (int i = 0; i < 15; i++) {
            a[i] = Aminoacidi.aminoacidi.get(
                    aa[r.nextInt(aa.length)]
            );
        }

        DNA dna = new DNA(n);
        Proteina proteina = new Proteina(a);

        System.out.println("Sequenza DNA casuale: " + dna);
        System.out.println("Sequenza Proteina casuale: " + proteina);
    }
}

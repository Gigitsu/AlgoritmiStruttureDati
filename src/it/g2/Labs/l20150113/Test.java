package it.g2.Labs.l20150113;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gigitsu on 09/02/15.
 */
public class Test {
    private MatriceSparsa<String> text = new MatriceSparsa<>(4, 9, "0");
    private String[] dizionario = {"pane", "burro", "marmellata",
            "biscotti", "patatine", "aranciata", "cioccolata",
            "prosciutto", "formaggio"};

    public void main() {
        List<String> l = Arrays.asList(dizionario);

        // carrello 1
        text.cambiaValore(0,l.indexOf("pane"),"pane");
        text.cambiaValore(0,l.indexOf("burro"),"burro");
        text.cambiaValore(0,l.indexOf("formaggio"),"formaggio");

        // carrello 2
        text.cambiaValore(1,l.indexOf("cioccolata"),"cioccolata");
        text.cambiaValore(1,l.indexOf("biscotti"),"biscotti");
        text.cambiaValore(1,l.indexOf("patatine"),"patatine");

        // carrello 3
        text.cambiaValore(2,l.indexOf("prosciutto"),"prosciutto");
        text.cambiaValore(2,l.indexOf("formaggio"),"formaggio");
        text.cambiaValore(2,l.indexOf("aranciata"),"aranciata");

        // carrello 4
        text.cambiaValore(3,l.indexOf("pane"),"pane");
        text.cambiaValore(3,l.indexOf("prosciutto"),"prosciutto");
        text.cambiaValore(3,l.indexOf("marmellata"),"marmellata");
        text.cambiaValore(3,l.indexOf("formaggio"),"formaggio");
        text.cambiaValore(3,l.indexOf("patatine"),"patatine");

        int c = 0;
        for (String s:text) {
            if(c%9 == 0) {
                System.out.println();
                System.out.print("Carrello " + ( (int)(c/9) + 1) + ":");
            }

            if (!s.equals("0")) System.out.print(" " + s);

            c++;
        }

        System.out.println(); System.out.println();

        for (int i = 0; i < text.numRighe(); i++) {
            System.out.println("Similarità carrello " + (i + 1) + " con:");
            for (int j = 0; j < text.numRighe(); j++) {
                if (i == j) continue;
                System.out.print("    carrello " + (j + 1));

                int sim = 0;
                // similarity calculation
                for (int k = 0; k < text.numColonne(); k++) {
                    String item = text.valore(i, k);
                    if (!item.equals("0")) {
                        for (int m = 0; m < text.numColonne(); m++) {
                            if (item.equals(text.valore(j, m))) {
                                sim++;
                                break;
                            }
                        }
                    }
                }
                //end similarity calculation
                System.out.println(": " + sim);
            }
        }
    }
}

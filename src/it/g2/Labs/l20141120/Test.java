package it.g2.Labs.l20141120;

import it.g2.Labs.l20141120.biblioteca.Biblioteca;
import it.g2.Labs.l20141120.biblioteca.Record;
import it.g2.Labs.l20141120.biblioteca.Volume;
import it.g2.Labs.l20141120.biblioteca.strutture.DoubleLinkedList;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Test {
    public void main() {
        Biblioteca b = new Biblioteca();

        Volume pasdj = new Volume(2007,
                "Progetto di algoritmi e strutture dati in Java",
                "MacGrow Hill",
                new DoubleLinkedList<>(new String[]{
                        "Camil Demetrescu",
                        "Umberto Ferraro",
                        "Irene Finocchi",
                        "Giuseppe F. Italo"
                }));
        Volume asd = new Volume(2009,
                "Algoritmi e Strutture di Dati",
                "CittàStudi, Edizioni",
                new DoubleLinkedList<>(new String[]{
                        "Alan Bertossi"
                }));
        Volume pjf = new Volume(2008,
                "Programmazione Java: Fondamenti",
                "Pearson-Prentice Hall",
                new DoubleLinkedList<>(new String[]{
                        "Deitel & Deitel"
                }));
        Volume jss = new Volume(2010,
                "Java Software Structures",
                "Pearson Education",
                new DoubleLinkedList<>(new String[]{
                        "John Lewis",
                        "Joseph Chase"
                }));

        b.AggiungiRecord("A231", new Record(pasdj));
        b.AggiungiRecord("A232", new Record(pasdj));

        b.AggiungiRecord("D342", new Record(asd));

        b.AggiungiRecord("R435", new Record(pjf));
        b.AggiungiRecord("R436", new Record(pjf));
        b.AggiungiRecord("R437", new Record(pjf));

        b.AggiungiRecord("T964", new Record(jss));
        b.AggiungiRecord("T965", new Record(jss));

        b.PrestaVolume("D342");
        b.PrestaVolume("T965");

        System.out.print(b.toString());
    }
}

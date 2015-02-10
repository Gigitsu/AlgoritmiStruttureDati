package it.g2.Labs.l20141120.biblioteca;

import it.g2.Labs.l20141120.biblioteca.strutture.Dictionary;

/**
 * Created by gigitsu on 10/02/15.
 */
public abstract class BibliotecaAbs {
    protected Dictionary<String, Record> volumi;

    public void AggiungiRecord(String posizione, Record record) {
        volumi.insert(posizione, record);
    }

    public Record TrovaRecord(String posizione) {
        return volumi.search(posizione);
    }

    public Volume PrestaVolume(String posizione) {
        Record r = volumi.search(posizione);
        r.setPrestato(true);
        return r.getVolume();
    }

    @Override
    public String toString() {
        return volumi.toString();
    }
}

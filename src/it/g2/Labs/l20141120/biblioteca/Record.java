package it.g2.Labs.l20141120.biblioteca;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Record {
    private Volume volume;
    private boolean prestato;

    public Record(Volume volume) {
        this(volume, false);
    }

    public Record(Volume volume, boolean prestato) {
        this.volume = volume;
        this.prestato = prestato;
    }

    public Volume getVolume() {
        return volume;
    }

    public boolean getPrestato() {
        return prestato;
    }

    public void setPrestato(boolean prestato) {
        this.prestato = prestato;
    }

    @Override
    public String toString() {
        return volume.toString() + " " + (prestato ? " prestato;" : " disponibile;");
    }
}

package it.g2.Labs.l20100111;

/**
 * Created by gigitsu on 10/02/15.
 */
public abstract class Polimero {
    protected ListaSemplice sequenza = null;

    public Polimero() {
        sequenza = new AList();
    }

    @Override
    public String toString() {
        StringBuilder polimero = new StringBuilder();

        while(sequenza.hasNext())
            polimero.append(sequenza.next().toString());

        return polimero.toString();
    }
}

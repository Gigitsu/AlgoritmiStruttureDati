package it.g2.Labs.l20100111.monomeri;

/**
 * Created by gigitsu on 10/02/15.
 */
public abstract class Monomero {
    protected String name;
    protected Character symbol;

    public Monomero(Character symbol, String name) {
        checkValues(symbol, name);
        this.name = name;
        this.symbol = symbol;
    }

    public String getName(){
        return name;
    }
    public Character getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol.toString();
    }

    protected abstract void checkValues(Character symbol, String name);
}

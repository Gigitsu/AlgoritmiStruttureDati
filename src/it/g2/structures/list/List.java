package it.g2.structures.list;

/**
 * Created by gigitsu on 10/02/15.
 */
public interface List<P extends Position,T> extends Iterable<T> {

    /**
     * @return true se la lista è vuota falso altrimenti
     */
    public boolean isEmpty();

    /**
     * @param p posizione dell'elemento da leggere
     * @return il valore contenuto nell'elemento di posizione p
     * (sollevare eccezione PosizioneNonValida oppure OutOfBoundException)
     */
    public T readList(P p);

    /**
     * @param e valore da scrivere
     * @param p posizione in cui scrivere l'elemento
     * (sollevare eccezione PosizioneNonValida o IndexOutOfBoundsException)
     */
    public void writeList(T e, P p);

    /**
     * @return restituisce la posizione della testa della lista
     */
    public P firstList();

    /**
     * @param p posizione
     * @return true se la p è la posizione dopo l'ultimo elemento
     */
    public boolean endList(P p);

    /**
     * @param p posizione
     * @return posizione successiva alla posizione passata
     * sollevare una eccezione nel caso in cui viene passata l'ultima posizione
     */
    public P next(P p);

    /**
     * @param p posizione
     * @return la posizione dell'elemento precedente
     * lanciare una eccezione se poisizione == primolista
     */
    public P previous(P p);

    /**
     * @param e elemento
     * @param p posizione dopo la quale inserire un nuovo elemento
     * eccezione posizione non valida
     */
    public void insert(T e, P p);

    /**
     * @param p posizione
     * rimuove l'elemento in posizion passata
     * solleva un eccezione per posizione non valida
     */
    public void remove(P p);

}

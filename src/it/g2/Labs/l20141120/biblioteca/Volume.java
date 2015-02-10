package it.g2.Labs.l20141120.biblioteca;

import it.g2.Labs.l20141120.biblioteca.strutture.AddOnlyList;

/**
 * Created by gigitsu on 10/02/15.
 */
public class Volume {
    private int anno;
    private String titolo;
    private String editore;
    private AddOnlyList<String> autori;

    public Volume(int anno, String titolo, String editore, AddOnlyList<String> autori) {
        this.anno = anno;
        this.titolo = titolo;
        this.editore = editore;
        this.autori = autori;
    }

    public int getAnno() {
        return anno;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getEditore() {
        return editore;
    }

    public AddOnlyList<String> getAutori() {
        return autori;
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Volume v = (Volume) obj;

            return anno == v.anno &&
                    titolo.equals(v.titolo) &&
                    editore.equals(v.editore) &&
                    controllaAutori(v.autori);

        } catch (ClassCastException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Titolo: ");
        sb.append(getTitolo());
        sb.append(" Editore: ");
        sb.append(getEditore());
        sb.append(" Anno: ");
        sb.append(getAnno());
        sb.append(" Autori:");
        String prefix = " ";
        for (String a:autori) {
            sb.append(prefix + a);
            prefix = ", ";
        }

        return sb.toString();
    }

    private boolean controllaAutori(AddOnlyList<String> autori) {
        for (String ta:this.autori) {
            boolean se = false;
            for (String aa:autori) {
                se = ta.equals(aa);
                if (se) break;
            }
            if (!se) return false;
        }
        return true;
    }
}

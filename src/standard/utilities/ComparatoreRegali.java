package standard.utilities;

import standard.object.Regalo;

import java.util.Comparator;

public class ComparatoreRegali implements Comparator<Regalo> {
    public boolean alphabetic;

    /**
     * creazione del costuttore nel quale è istanziabile se è da ordinare in modo alfabetico o meno
     * @param alphabetic
     */
    public ComparatoreRegali(boolean alphabetic) {
        this.alphabetic = alphabetic;
    }

    /**
     * creazione costruttore standard per retorcompatibilita
     */
    public ComparatoreRegali() {
        this.alphabetic = true;
    }

    //vedere e settare senso alfabetico
    public boolean isAlphabetic() {
        return alphabetic;
    }

    public void setAlphabetic(boolean alphabetic) {
        this.alphabetic = alphabetic;
    }

    @Override
    public int compare(Regalo r1, Regalo r2) {
        if(alphabetic) return r1.getNome().compareTo(r2.getNome());
        else return r2.getNome().compareTo(r1.getNome());
    }

}

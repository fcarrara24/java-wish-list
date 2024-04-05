package standard;

import java.util.Comparator;

public class ComparatoreRegali implements Comparator<Regalo> {
    public boolean alphabetic;

    public ComparatoreRegali(boolean alphabetic) {
        this.alphabetic = alphabetic;
    }

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

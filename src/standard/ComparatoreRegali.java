package standard;

import java.util.Comparator;

public class ComparatoreRegali implements Comparator<Regalo> {
    @Override
    public int compare(Regalo r1, Regalo r2) {
        return r1.getNome().compareTo(r2.getNome());
    }
}

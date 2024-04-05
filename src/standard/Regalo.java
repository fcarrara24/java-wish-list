package standard;

import java.util.Objects;

public class Regalo {
    private String nome;

    public Regalo(String nome) {
        this.nome = nome;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
}

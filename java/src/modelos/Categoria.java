package modelos;

public enum Categoria {
    MORANGO("Morango"),
    TRUFADO("Trufado"),
    OUTROS("Outros");

    private final String nomeExibicao;

    Categoria(String nomeExibicao) {
        this.nomeExibicao = nomeExibicao;
    }

    @Override
    public String toString() {
        return nomeExibicao;
    }
}
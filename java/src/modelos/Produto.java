package modelos;

public class Produto {

    private String nome;
    private String descricao;
    private Categoria categoria;
    private double[] precos;

    public Produto(String nome, String descricao, Categoria categoria, double[] precos) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.precos = precos;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public double getPreco(Tamanho tamanho) {
        return precos[tamanho.ordinal()];
    }
}
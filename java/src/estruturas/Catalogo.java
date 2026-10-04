package estruturas;

import java.util.Locale;
import modelos.Categoria;
import modelos.Produto;
import modelos.Tamanho;

public class Catalogo {

    private Produto[] produtos;

    // CRIAR: Gavetas de 6 produtos
    public Catalogo() {
        produtos = new Produto[6];

        produtos[0] = new Produto(
                "Creme de Avelã com Morango",
                "Uma combinação deliciosa de creme de avelã e morangos frescos.",
                Categoria.MORANGO,
                new double[]{25.90, 30.89, 35.89});

        produtos[1] = new Produto(
                "Açaí Trufado Ninho",
                "Açaí Trufado de creme de Ninho nas laterais do copo com Leite Ninho e Leite Condensado em Camadas.",
                Categoria.TRUFADO,
                new double[]{25.90, 30.89, 35.89});

        produtos[2] = new Produto(
                "Leite Ninho com Leite Condensado e Banana",
                "Açaí ultra cremoso com leite ninho, leite condensado em 3 Camadas e no topo leite ninho, leite condensado e banana.",
                Categoria.OUTROS,
                new double[]{25.90, 30.89, 35.89});

        produtos[3] = new Produto(
                "Morango com Leite Ninho",
                "Açaí ultra cremoso com morango e leite ninho em camadas.",
                Categoria.MORANGO,
                new double[]{25.90, 30.89, 35.89});

        produtos[4] = new Produto(
                "Paçoca com Leite Ninho",
                "Açaí ultra cremoso com paçoca e leite ninho em camadas.",
                Categoria.OUTROS,
                new double[]{25.90, 30.89, 35.89});

        produtos[5] = new Produto(
                "Combo Trufado",
                "Açaí ultra cremoso com trufado e leite ninho em camadas.",
                Categoria.TRUFADO,
                new double[]{25.90, 30.89, 35.89});
    }

    // PERCORRER: Olha gavera por gaveta e mostra cada produto
    public void listar() {
        for (int i = 0; i < produtos.length; i++) {
            exibirProduto(produtos[i]);
        }
    }

    // BUSCAR: mostra os produtos que têm o pedaço digitado no nome
    public void buscarPorNome(String termo) {
        boolean achou = false;
        for (int i = 0; i < produtos.length; i++) {
            String nome = produtos[i].getNome().toLowerCase();
            if (nome.contains(termo.toLowerCase())) {
                exibirProduto(produtos[i]);
                achou = true;
            }
        }
        if (!achou) {
            System.out.println("Nenhum produto encontrado.");
        }
    }

    // ORDENAR: Bubble Sort por nome, em ordem alfabetica
    public void ordenarPorNome() {
        int n = produtos.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (produtos[j].getNome().compareToIgnoreCase(produtos[j + 1].getNome()) > 0) {
                    Produto temporario = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = temporario;
                }
            }
        }
    }

    // Mostra uma ficha de produto na tela
    private void exibirProduto(Produto produto) {
        System.out.println("--------------------------------------");
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Categoria: " + produto.getCategoria());
        System.out.println("Descrição: " + produto.getDescricao());
        for (Tamanho tamanho : Tamanho.values()) {
            System.out.println(String.format(Locale.of("pt", "BR"),
                    "  %s: R$ %.2f", tamanho, produto.getPreco(tamanho)));
        }
    }
}
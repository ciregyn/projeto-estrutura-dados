package estruturas;

public class Pilha {

    private String[] itens;
    private int quantidade;

    // Cria a pilha com um numero fixo de gavetas
    public Pilha(int capacidade) {
        itens = new String[capacidade];
        quantidade = 0;
    }

    public boolean estaVazia() {
        return quantidade == 0;
    }

    public boolean estaCheia() {
        return quantidade == itens.length;
    }

    // EMPILHAR: coloca um item em cima da pilha
    public boolean empilhar(String item) {
        if (estaCheia()) {
            return false;
        }
        itens[quantidade] = item;
        quantidade++;
        return true;
    }

    // DESEMPILHAR: tira o item de cima e devolve ele
    public String desempilhar() {
        if (estaVazia()) {
            return null;
        }
        quantidade--;
        String item = itens[quantidade];
        itens[quantidade] = null;
        return item;
    }

    // CONSULTAR O TOPO: so olha o item de cima, sem tirar
    public String consultarTopo() {
        if (estaVazia()) {
            return null;
        }
        return itens[quantidade - 1];
    }
}
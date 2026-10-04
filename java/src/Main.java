import estruturas.Catalogo;
import estruturas.Pilha;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Catalogo catalogo = new Catalogo();
        Pilha historico = new Pilha(10);
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao(leitor);

            switch (opcao) {
                case 1:
                    catalogo.listar();
                    break;
                case 2:
                    buscar(leitor, catalogo, historico);
                    break;
                case 3:
                    catalogo.ordenarPorNome();
                    System.out.println("Produtos ordenados por nome.");
                    break;
                case 4:
                    verUltimaBusca(historico);
                    break;
                case 5:
                    desfazerUltimaBusca(historico);
                    break;
                case 0:
                    System.out.println("Encerrando o programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente de novo.");
            }
        } while (opcao != 0);

        leitor.close();
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("===== CATÁLOGO DE AÇAÍ =====");
        System.out.println("1 - Listar produtos");
        System.out.println("2 - Buscar produto por nome");
        System.out.println("3 - Ordenar produtos por nome ");
        System.out.println("4 - Ver a última busca");
        System.out.println("5 - Desfazer a última busca");
        System.out.println("0 - Sair");
    }

    private static int lerOpcao(Scanner leitor) {
        System.out.print("Escolha uma opção: ");
        String texto = leitor.nextLine();
        try {
            return Integer.parseInt(texto.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void buscar(Scanner leitor, Catalogo catalogo, Pilha historico) {
        System.out.print("Digite o nome (ou um pedaço) do produto: ");
        String termo = leitor.nextLine().trim();

        if (termo.isEmpty()) {
            System.out.println("Você não digitou nada. Busca cancelada.");
            return;
        }

        catalogo.buscarPorNome(termo);

        if (!historico.empilhar(termo)) {
            System.out.println("Histórico cheio, esta busca não foi guardada.");
        }
    }

    private static void verUltimaBusca(Pilha historico) {
        String ultima = historico.consultarTopo();
        if (ultima == null) {
            System.out.println("Nenhuma busca no histórico.");
        } else {
            System.out.println("Última busca: " + ultima);
        }
    }

    private static void desfazerUltimaBusca(Pilha historico) {
        String removida = historico.desempilhar();
        if (removida == null) {
            System.out.println("Nenhuma busca para desfazer.");
        } else {
            System.out.println("Busca removida do histórico: " + removida);
        }
    }
}
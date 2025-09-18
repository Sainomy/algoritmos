import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SupermercadoApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Produtos disponíveis (usando o enum)
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(Descricao.ARROZ, 25.0, 10));
        produtos.add(new Produto(Descricao.FEIJAO, 8.0, 20));
        produtos.add(new Produto(Descricao.FARINHA, 6.0, 15));
        produtos.add(new Produto(Descricao.LEITE, 4.5, 30));

        Pedido pedidoAtual = null;

        int opcao;
        do {
            System.out.println("\n-------Supermercado------");
            System.out.println("1 - Novo pedido");
            System.out.println("2 - Realizar pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do cliente: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF do cliente: ");
                    String cpf = sc.nextLine();
                    Cliente cliente = new Cliente(nome, cpf);

                    pedidoAtual = new Pedido(cliente);

                    boolean adicionarMais;
                    do {
                        System.out.println("\nProdutos disponíveis:");
                        for (int i = 0; i < produtos.size(); i++) {
                            System.out.println((i + 1) + ") " + produtos.get(i));
                        }

                        System.out.print("Escolha o produto (número): ");
                        int prodIndex = sc.nextInt() - 1;
                        System.out.print("Quantidade: ");
                        int qtd = sc.nextInt();
                        sc.nextLine();

                        pedidoAtual.adicionarItem(produtos.get(prodIndex), qtd);

                        System.out.print("Adicionar mais produtos? (s/n): ");
                        adicionarMais = sc.nextLine().equalsIgnoreCase("s");
                    } while (adicionarMais);

                    System.out.println("\nPedido criado:\n" + pedidoAtual);
                    break;

                case 2:
                    if (pedidoAtual == null) {
                        System.out.println("Nenhum pedido criado ainda.");
                    } else {
                        System.out.println("\n" + pedidoAtual);
                        System.out.println("Formas de pagamento: 1) DINHEIRO  2) CHEQUE  3) CARTÃO");
                        int forma = sc.nextInt();
                        TipoPagamento fp = (forma == 1) ? TipoPagamento.DINHEIRO
                                : (forma == 2) ? TipoPagamento.CHEQUE
                                : TipoPagamento.CARTAO;

                        pedidoAtual.realizarPagamento(fp);
                        pedidoAtual = null;
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}

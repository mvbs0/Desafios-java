import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Criar o Scanner (FALTAVA ESSA LINHA)
        Scanner scanner = new Scanner(System.in);

        // Lista de produtos disponíveis no sistema
        List<Produto> produtosDisponiveis = new ArrayList<>();
        produtosDisponiveis.add(new Produto("Cimento", 42.0, 10));
        produtosDisponiveis.add(new Produto("Bloco", 1.10, 5000));
        produtosDisponiveis.add(new Produto("Telha", 23.0, 50));

        char opcao;
        do {
            System.out.println("\n---- MINI SISTEMA DE VENDAS ----");
            System.out.println("1. Registrar nova venda");
            System.out.println("2. Consultar produtos");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.next().charAt(0);

            switch (opcao) {
                case '1':
                    // Criar novo orçamento
                    Orcamento2 orcamento = new Orcamento2();

                    boolean continuar = true;
                    while (continuar) {
                        System.out.println("\n--- Produtos Disponíveis ---");
                        for (int i = 0; i < produtosDisponiveis.size(); i++) {
                            System.out.println((i + 1) + ". " + produtosDisponiveis.get(i));
                        }

                        System.out.print("Escolha o número do produto: ");
                        int indice = scanner.nextInt() - 1;

                        if (indice < 0 || indice >= produtosDisponiveis.size()) {
                            System.out.println("Produto inválido!");
                            continue;
                        }

                        System.out.print("Quantidade: ");
                        int quantidade = scanner.nextInt();

                        Produto produtoEscolhido = produtosDisponiveis.get(indice);
                        orcamento.adicionarProdutos(produtoEscolhido, quantidade);

                        System.out.print("Deseja adicionar outro produto? (s/n): ");
                        continuar = scanner.next().equalsIgnoreCase("s");
                    }

                    System.out.print("Pagamento à vista? (s/n): ");
                    boolean avista = scanner.next().equalsIgnoreCase("s");
                    orcamento.setPagamentoAvista(avista);

                    // Criar e confirmar venda
                    Venda venda = new Venda(orcamento);
                    venda.confirmarVenda();
                    venda.detalhesVenda();

                    System.out.println("\n--- Estoque Atualizado ---");
                    for (Produto p : produtosDisponiveis) {
                        System.out.println(p);
                    }
                    break;

                case '2':
                    System.out.println("\n--- Produtos Disponíveis ---");
                    for (Produto p : produtosDisponiveis) {
                        System.out.println(p);
                    }
                    break;

                case '3':
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != '3');

        scanner.close();
        System.out.println("Sistema de vendas encerrado.");
    }
}

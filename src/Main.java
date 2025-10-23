import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //criar scanner para ler opcao
        Scanner scanner = new Scanner(System.in);
        //criando atributo opcao
        char opcao;
        // Criação dos produtos, alterar para interaçao com o usuario
        List<Produto> produtos = new ArrayList<>();
        Produto p1 = new Produto("Cimento", 42.0, 10);
        Produto p2 = new Produto("Bloco", 1.10, 5000);
        Produto p3 = new Produto("Telhas''", 23.0, 50);
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);

        do{
            //Exibir o menu de opçoes para o usuario
            System.out.println("Menu de opções!");
            System.out.println("1. Registrar nova venda.");
            System.out.println("2. Consultar itens.");
            System.out.println("3. Sair.");
            System.out.println("Escolha uma opcao: ");

            //ler opção do usuarios
            opcao = scanner.next().charAt(0);
            //criando as ações de acordo com a opção escolhida
            switch (opcao){
                case'1':
                    Orcamento2 orcamento = new Orcamento2();
                    orcamento.adicionarProdutos(p1, 2);
                    orcamento.adicionarProdutos(p2,3 );
                    orcamento.listarProdutos();

                    //testando o if ternario e adicionando metodo de pagamento
                    System.out.println("\n--- Forma de pagamento ---");
                    System.out.println("1. À vista (20% de desconto)");
                    System.out.println("2. Parcelado (sem desconto)");
                    System.out.print("Escolha uma opção: ");

                    int opcaoPagamento = scanner.nextInt();
                    //verifica se o pagamento foi a vista,
                    boolean pagamentoAvista = opcaoPagamento == 1;
                    orcamento.setPagamentoAvista(pagamentoAvista);


                    double totalFinal = pagamentoAvista ? orcamento.calcularTotal() * 0.8 : orcamento.calcularTotal();
                    double desconto = pagamentoAvista ? orcamento.calcularTotal() * 0.2 : 0.0;
                    // alterar strings para variavel nomeada, lembrar do desonto
                    System.out.println(pagamentoAvista
                            ? "Desconto de 20% aplicado! Você economizou R$ " + desconto
                            : "Sem desconto aplicado.");

                    Venda venda = new Venda(orcamento);
                    venda.confirmarVenda();
                    venda.detalhesVenda();

                    System.out.println("Valor final da venda: R$ " + totalFinal);// alterar valor final para aceitar apenas duas casa decimais.

                    break;

                case'2':
                    for (Produto p : produtos) {
                        System.out.println(p);
                    }
                    break;
                case'3':
                    System.out.println("saindo do menu");
                    break;
            }
        } while (opcao != '3');
          scanner.close();
    }
}

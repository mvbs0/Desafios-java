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
            Estoque estoque = new Estoque();
            estoque.adicionarProduto(new Produto("Cimento", 42.0, 10));
            estoque.adicionarProduto(new Produto("Bloco", 1.10, 5000));
            estoque.adicionarProduto(new Produto("Telha", 23.0, 50));

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

                        System.out.println("--- Catálogo de Produtos ---");
                        for (int i = 0; i < estoque.getProdutos().size(); i++) {
                            System.out.println((i + 1) + " - " + estoque.getProdutos().get(i).getNome());
                        }

                        int escolha = -1;
                        while (escolha!=0) {
                            System.out.println("Digite o numero do produto (ou 0 para finalizar): ");
                            escolha=scanner.nextInt();
                            if (escolha > 0 && escolha <= estoque.getProdutos().size()) {
                                Produto escolhido = estoque.getProdutos().get(escolha - 1);
                                System.out.println("Digite a quantidade desejada: ");
                                int quantidade = scanner.nextInt();
                                orcamento.adicionarProdutos(escolhido, quantidade);
                            } else if (escolha != 0) {
                                System.out.println("Produto inválido!");
                            }

                        }
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
                        //Atributos criados para substituir string e atualizaçao do resultado mostrado para apenas duas casa decimais após a virgula. Pegurntar a caique porque que n conseguir por toda a frase dentro do string fomat
                        String comDesconto = String.format("%.2f", desconto );
                        String semDesconto ="Sem desconto aplicado.";

                        System.out.println(pagamentoAvista
                                ? "Desconto de 20% aplicado! Você economizou R$ " + comDesconto
                                : semDesconto);

                        Venda venda = new Venda(orcamento);
                        venda.confirmarVenda();
                        venda.detalhesVenda();

                        String resultado = String.format("%.2f" , totalFinal);
                        System.out.println("Valor final da venda: R$ " + resultado);
                        break;

                    case'2':
                        estoque.listarProdutos();
                        break;
                    case'3':
                        System.out.println("saindo do menu");
                        break;
                }
            } while (opcao != '3');
              scanner.close();
        }
    }

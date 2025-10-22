import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //criar scanner para ler opcao
        Scanner scanner = new Scanner(System.in);
        //criando atributo opcao
        char opcao;
        // Criação dos produtos
        Produto p1 = new Produto("Cimento", 42.0, 10);
        Produto p2 = new Produto("Bloco", 1.10, 5000);
        Produto p3 = new Produto("Telhas''", 23.0, 50);


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
                    Orcamento orcamento = new Orcamento2();
                    orcamento.adicionarProdutos(p1, 2);
                    orcamento.adicionarProdutos(p2,3 );
                    orcamento.listarProdutos();
                    //confirmar venda
                    Venda venda = new Venda(orcamento);
                    venda.confirmarVenda();
                    venda.detalhesVenda();

                    break;
                case'2':
                    Orcamento orcamento2 = new Orcamento2();
                    orcamento2.listarProdutos();
                    break;
                case'3':
                    System.out.println("saindo do menu");
                    break;
            }
        } while (opcao != '3');
          scanner.close();
    }
}

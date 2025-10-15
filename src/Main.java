//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Criação dos produtos
        Produto p1 = new Produto("Cimento", 42.0, 10);
        Produto p2 = new Produto("Bloco", 1.10, 5000);
        Produto p3 = new Produto("Telhas''", 23.0, 50);

        // Criação do orçamento
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarProdutos(p1, 2);
        orcamento.adicionarProdutos(p2, 1);
        orcamento.listarProdutos();

        // Confirmação da venda
        Venda venda = new Venda(orcamento);
        venda.confirmarVenda();
        venda.detalhesVenda();

        // Mostrando estoque após venda
        System.out.println("\n--- Estoque Atualizado ---");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
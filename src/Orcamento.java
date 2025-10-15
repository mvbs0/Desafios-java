
    import java.util.ArrayList;
    import java.util.List;

public class Orcamento {
    private List<Produto> produtos = new ArrayList<>();
    private List<Integer> quantidades = new ArrayList<>();

    // adiciona produtos ao orçamento
    public void adicionarProdutos(Produto produto, int quantidade){
        produtos.add(produto);
        quantidades.add(quantidade);
        System.out.println(quantidade + "x " + produto.getNome() + "adicionado ao orçamento");
    }
    //calcula o valor total
    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < produtos.size(); i++){
            total += produtos.get(i).getPreço() * quantidades.get(i);
        }
        return total;
    }
    //lista de produtos
    public void listarProdutos() {
        System.out.println("\n--- Produtos no Orçamento ---");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(quantidades.get(i) + "x " + produtos.get(i));
        }
        System.out.println("Total: R$ " + calcularTotal());
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Integer> getQuantidades() {
        return quantidades;
    }
}

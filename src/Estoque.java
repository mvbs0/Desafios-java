import java.util.ArrayList;
import java.util.List;


public class Estoque {
    private List<Produto>produtos;

    public Estoque(){
        this.produtos = new ArrayList<>();

    }
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado ao estoque: "+produto.getNome());
    }
    public void listarProdutos(){
        System.out.println("Estoque atual.");
        if (produtos.isEmpty()){
            System.out.println("Sem estoque disponivel no momento!");
        }

        for (Produto p : produtos){
            System.out.println(p);
        }
    }
public Produto buscarProduto(String nome){
        for(Produto p : produtos){
            if(p.getNome().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
}
    public List<Produto> getProdutos() {
        return produtos;
    }
}

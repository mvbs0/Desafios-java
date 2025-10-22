
public class Produto {
    //atributos(informações que vão compor a classe produto)
    private String nome;
    private double preco;
    private int estoque;
    //    //metodo construtor. este vai ser chamado quando um objeto desta classe for criado
    //    //etre parenteses estou passando os parametros do metodo, elas que guardam os dados colhidos pelo metodo

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }
    //metodos get e set

    public String getNome() {
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int getEstoque(){
        return estoque;
    }
    public void setEstoque(int estoque){
        this.estoque = estoque;
    }
    // metodo para atualizar um estoque após uma venda

    public void reduzirEstoque(int quantidade){
        if(quantidade <= estoque){
            estoque -= quantidade;
        } else{
            System.out.println("Estoque insuficiente para o produto " + nome);
        }
    }
    @Override
    public String toString() {
        return nome + " - R$ " + preco + " (Estoque: " + estoque + ")";
    }
}
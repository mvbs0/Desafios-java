public class Orcamento2 extends Orcamento {
    private boolean pagamentoAvista = false;
    public void setPagamentoAvista(boolean pagamentoAvista){
        this.pagamentoAvista = pagamentoAvista;
    }
    @Override
    public double calcularTotal() {
        double total = 0;// total para retornar

        int contador = 0;// indice que vai percorrer a lista começando do 0

        while (contador < getProdutos().size()) {// condição do looping while
            Produto produto = getProdutos().get(contador);
            int quantidade = getQuantidades().get(contador);
            total += produto.getPreco() * quantidade;
            contador++;
        }

        if (pagamentoAvista) {
            double desconto = total * 0.2;
            total -= desconto;
            System.out.println("Desconto de 20% aplicado! - r$" + desconto );

        }

        return total;


    }
}

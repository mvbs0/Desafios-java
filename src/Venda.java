public class Venda {
    private Orcamento orcamento;
    private boolean confirmada = false;

    public Venda(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public void confirmarVenda() {
        //verifica se o orcamento tem produtos
        if (orcamento.getProdutos().isEmpty()) {
            System.out.println("Não há produtos no orçamento para vender!");
            return;
        }

        // Reduz o estoque de cada produto
        for (int i = 0; i < orcamento.getProdutos().size(); i++) {
            Produto produto = orcamento.getProdutos().get(i);
            int quantidade = orcamento.getQuantidades().get(i);
            produto.reduzirEstoque(quantidade);
        }

        confirmada = true;
        System.out.println("Venda confirmada com sucesso! Total: R$ " + orcamento.calcularTotal());
    }

    public void detalhesVenda() {
        if (confirmada) {
            System.out.println("\n--- Detalhes da Venda ---");
            orcamento.listarProdutos();
        } else {
            System.out.println("A venda ainda não foi confirmada.");
        }
    }
}

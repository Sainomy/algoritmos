class Produto {
    private Descricao descricao;
    private double preco;
    private int quantidadeEstoque;

    public Produto(Descricao descricao, double preco, int quantidadeEstoque) {
        this.descricao = descricao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Descricao getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public boolean reduzirEstoque(int qtd) {
        if (qtd <= quantidadeEstoque) {
            quantidadeEstoque -= qtd;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return descricao + " - R$" + preco + " (Estoque: " + quantidadeEstoque + ")";
    }
}

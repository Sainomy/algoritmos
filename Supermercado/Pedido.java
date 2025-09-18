import java.util.ArrayList;
import java.util.List;

class Pedido {
    private Cliente cliente;
    private List<Item> itens = new ArrayList<>();
    private TipoPagamento tipoPagamento; // ajuste aqui

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {
        if (produto.reduzirEstoque(quantidade)) {
            itens.add(new Item(produto, quantidade));
        } else {
            System.out.println("⚠ Estoque insuficiente para " + produto.getDescricao());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Item item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void realizarPagamento(TipoPagamento tipoPagamento) { // ajuste aqui
        this.tipoPagamento = tipoPagamento;
        System.out.println("Pagamento realizado em: " + tipoPagamento);
        System.out.println("Total: R$" + calcularTotal());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(cliente).append("\n");
        sb.append("Itens do pedido:\n");
        for (Item item : itens) {
            sb.append("  ").append(item).append("\n");
        }
        sb.append("Total: R$").append(calcularTotal()).append("\n");
        return sb.toString();
    }
}

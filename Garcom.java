public class Garcom {
    private final Cozinha cozinha;
    private Pedido pedidoAtual;

    Garcom(Cozinha cozinha) {
        this.cozinha = cozinha;
        this.pedidoAtual = null;
    }

    public void anotarPedido(int id, int quantidade, int mesa) {
        if (id == 0) {
            this.finalizarPedido();
            return;
        }
        Prato prato = new Prato(id, quantidade, Prato.getPreco(id));
        if (pedidoAtual == null)
            pedidoAtual = new Pedido(mesa);

        this.pedidoAtual.addPrato(prato);
        System.out.println("Prato adicionado");
    }

    public void finalizarPedido() {
        if (this.cozinha.addPedidos(pedidoAtual))
            this.entregarPedido();
        else
            System.out.println("Tivemos um problema na cozinha.");
    }

    public void entregarPedido() {
        if (pedidoAtual == null) return;
        System.out.println("Aqui está o seu pedido");

    }
}

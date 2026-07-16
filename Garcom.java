public class Garcom {
    private final Cozinha cozinha;
    private Pedido pedidoAtual;

    Garcom(Cozinha cozinha) {
        this.cozinha = cozinha;
        this.pedidoAtual = null;
    }

    public void boasVindas(Cliente c) {
        System.out.println("Bem vindo ao Restaurante Java, " + c.getNome() + "!\nAqui você pode ver o menu:");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int mostrarMenu() {
        return (Integer.parseInt(IO.readln("""
            O que você gostaria de comer?
            1 - Hambúrguer............R$ 12,00
            2 - Pizza de Queijo.......R$ 30,00
            3 - Batata Frita..........R$ 8,00
            4 - Água..................R$ 2,00
            5 - Limonada..............R$ 4,00
            6 - Refrigerante..........R$ 5,00
            0 - Finalizar pedido\n
            """)));
    }

    public void fazerPedido(Cliente c, int id, int mesa){
        if (id == 0) {
            System.out.println("Obrigado por passar aqui!");
            return;
        }
        while (true) {
            while (id < 0 || id > 6)
                id = Integer.parseInt(IO.readln("Número indisponível, escolha um dos valores do menu\n"));

            int quantidade = 1;
            if (id != 0) {
                quantidade = Integer.parseInt(IO.readln("Quantos(as) você deseja?\n"));
                while (quantidade < 1)
                    quantidade = Integer.parseInt(IO.readln("Quantidade indisponível, digite novamente\nQuantos(as) você deseja?\n"));
            } else {
                System.out.print("\nAguarde o seu pedido");
                for(int i = 0; i < 3; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.print(".");
                }
            }

            this.anotarPedido(id, quantidade, mesa);
            if (id == 0)
                break;

            c.addConta(Prato.getPreco(id)*quantidade);
            id = Integer.parseInt(IO.readln("Mais algum prato? (Número do cardápio)\n"));
        }
    }

    public void pegarConta(Cliente c) {
        if (!c.pagar()) {
            System.out.println("Vai lavar louça pelo resto do dia!");
        } else {
            System.out.println("Muito obrigado pela preferência!");
        }
    }

    private void anotarPedido(int id, int quantidade, int mesa) {
        if (id == 0) {
            this.finalizarPedido();
            return;
        }
        Prato prato = new Prato(id, quantidade, Prato.getPreco(id));
        if (pedidoAtual == null)
            pedidoAtual = new Pedido(mesa);

        this.pedidoAtual.addPrato(prato);
    }

    private void finalizarPedido() {
        if (this.cozinha.addPedidos(pedidoAtual))
            this.entregarPedido();
        else
            System.out.println("Tivemos um problema na cozinha.");
    }

    private void entregarPedido() {
        if (pedidoAtual == null) return;
        System.out.println("Aqui está o seu pedido");

    }
}

public class Cliente implements Pagavel {
    private String nome;
    private boolean estudante;
    private int dinheiro, mesa, conta;
    private boolean servido;

    public Cliente(String nome, int dinheiro, boolean estudante) {
        this.nome = nome;
        this.estudante = estudante;
        this.mesa = (int)(Math.random()*60 +1);
    }

    private int lerMenu() {
        System.out.println();
        return (Integer.parseInt(IO.readln("""
            \nBem-vindo ao restaurante!
            O que você gostaria de comer?
            1 - Hambúrguer............R$12,00
            2 - Pizza de Queijo.......R$30,00
            3 - Batata Frita..........R$8,00
            4 - Água..................R$2,00
            5 - Limonada..............R$4,00
            6 - Refrigerante..........R$5,00
            0 - Finalizar pedido
            """)));
    }

    public void chamarGarcom(Garcom garcom) {
        int id = lerMenu();

        while (true) {
            while (id < 0 || id > 6)
                id = Integer.parseInt(IO.readln("Número indisponível, escolha um dos valores do menu"));

            int quantidade = 1;
            if (id != 0) {
                quantidade = Integer.parseInt(IO.readln("Quantos(as) você deseja?\n"));
                while (quantidade < 1)
                    quantidade = Integer.parseInt(IO.readln("Quantidade indisponível, digite novamente\nQuantos(as) você deseja?\n"));
            } else {
                System.out.println("Aguarde o seu pedido");
            }

            garcom.anotarPedido(id, quantidade, this.mesa);
            if (id == 0)
                break;

            this.conta = Prato.getPreco(id)*quantidade;
            id = Integer.parseInt(IO.readln("Mais algum prato? (Número do cardápio)\n"));
        }
    }

    @Override
    public void pagar() {
        if (!servido) return;

        if (this.estudante) this.conta = (int)(this.conta*0.90);

        if (this.dinheiro >= this.conta) {
            this.dinheiro -= this.conta;
        }
    }

}

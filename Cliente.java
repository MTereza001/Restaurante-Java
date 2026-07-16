public class Cliente implements Pagavel {
    private String nome;
    private boolean estudante;
    private int dinheiro, mesa, conta;
    private boolean servido;

    public Cliente(String nome, int dinheiro, boolean estudante) {
        this.nome = nome;
        this.estudante = estudante;
        this.dinheiro = dinheiro;
        this.mesa = (int)(Math.random()*60 +1);
        this.conta = 0;
        this.servido = false;
    }

    public void chamarGarcom(Garcom garcom) {
        garcom.boasVindas(this);
        int id = garcom.mostrarMenu();

        garcom.fazerPedido(this, id, this.mesa);
        this.servido = true;
    }

    public void pedirConta(Garcom garcom) {
        garcom.pegarConta(this);
        this.pagar();
    }

    public void addConta(int valor) {
        if (valor <= 0)
            return;

        this.conta += valor;
    }

    @Override
    public boolean pagar() {
        if (!servido) return true;

        if (this.estudante) this.conta = (int)(this.conta*0.90);

        if (this.dinheiro >= this.conta) {
            this.dinheiro -= this.conta;
            return true;
        }
        return false;
    }

    public int getConta() {
        return this.conta;
    }

    public int getDinheiro() {
        return this.dinheiro;
    }

    public String getNome() {
        return this.nome;
    }
}
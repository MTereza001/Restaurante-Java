public class Ingrediente {
    private String nome;
    private int quantidade;

    Ingrediente(String id, int quantidade){
        this.nome = id;
        this.quantidade = quantidade;
    }

    public String getId() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void addIngredientes(int quantidade) {
        this.quantidade += quantidade;
    }

    public boolean pegar(int quantidade) {
        this.quantidade -= quantidade;
        return quantidade < this.quantidade;
    }
}
import java.util.ArrayList;
import java.util.HashMap;

public class Cozinha {
    private ArrayList<Pedido> pedidos;
    private HashMap<String, Ingrediente> estoque;

    Cozinha() {
        this.pedidos = new ArrayList<>();
        this.estoque = new HashMap<>();

        Ingrediente i = new Ingrediente("batata", 10);
        estoque.put(i.getId(), i);
        i = new Ingrediente("verdura", 10);
        estoque.put(i.getId(), i);
        i = new Ingrediente("carne", 10);
        estoque.put(i.getId(), i);
        i = new Ingrediente("queijo", 10);
        estoque.put(i.getId(), i);
        i = new Ingrediente("pao", 10);
        estoque.put(i.getId(), i);
        i = new Ingrediente("limao", 10);
        estoque.put(i.getId(), i);
    }

    public boolean addPedidos(Pedido pedido){
        this.pedidos.add(pedido);
        return this.prepararPratos();
    }

    public void restocar(){
        this.estoque.forEach( (key, i) -> i.addIngredientes(10));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Enchendo o estoque...");
    }

    public boolean prepararPratos() {

        Pedido pedidoAtual = this.pedidos.removeFirst();
        ArrayList<Prato> pratos = pedidoAtual.getPratos();
        int mesa = pedidoAtual.getMesa();

        for(Prato prato : pratos) {
            int id = prato.id();
            int quantidade = prato.quantidade();
            boolean suficiente = true;
            switch (id) {
                case 1:
                    suficiente = (estoque.get("verdura").pegar(2 * quantidade) ||
                            estoque.get("carne").pegar(quantidade) ||
                            estoque.get("pao").pegar(2 * quantidade) ||
                            estoque.get("queijo").pegar(quantidade));
                case 2:
                    suficiente = estoque.get("queijo").pegar(2 * quantidade);
                case 3:
                    suficiente = estoque.get("batata").pegar(2 * quantidade);
                case 5:
                    suficiente = estoque.get("limao").pegar(2 * quantidade);
            }
            if (!suficiente)
                this.restocar();
        }
        return this.cozinhar(pedidoAtual);
    }

    private boolean cozinhar(Pedido pedidoAtual) {
        for (Prato prato : pedidoAtual.getPratos()) {/*TODO Thread.sleep(1000)...*/}

        if (!pedidos.isEmpty()) this.prepararPratos();
        return true;
    }

}
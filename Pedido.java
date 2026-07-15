import java.util.ArrayList;

public class Pedido {
    private ArrayList<Prato> pratos;
    private final int mesa;

    Pedido(int mesa) {
        this.pratos = new ArrayList<>();
        this.mesa = mesa;
    }

    public void addPrato(Prato prato) {
        pratos.add(prato);
    }

    public boolean removerPrato(Prato prato) {
        return pratos.remove(prato);
    }

    public ArrayList<Prato> getPratos() {
        return this.pratos;
    }

    public int getMesa() {
        return this.mesa;
    }

}
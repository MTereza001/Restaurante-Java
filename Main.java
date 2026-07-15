import java.util.ArrayList;

public class Main {

    void main() {
        Cozinha cozinha = new Cozinha();
        Garcom garcom = new Garcom(cozinha);
        ArrayList<Cliente> clientes = new ArrayList<>();

        Cliente cliente = new Cliente("Ronaldo", 100, true);
        clientes.add(cliente);
        cliente = new Cliente("Alessandra", 120, true);
        clientes.add(cliente);

        clientes.getFirst().chamarGarcom(garcom);
    }

}
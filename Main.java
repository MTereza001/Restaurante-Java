import java.util.ArrayList;

public class Main {

    void main() {
        Cozinha cozinha = new Cozinha();
        Garcom garcom = new Garcom(cozinha);
        ArrayList<Cliente> clientes = new ArrayList<>();

        String nome = IO.readln("\nQual o seu nome?\n");

        Cliente cliente = new Cliente(nome, 100, true);
        clientes.add(cliente);
        cliente = new Cliente("Alessandra", 120, true);
        clientes.add(cliente);

        Cliente user = clientes.getFirst();
        user.chamarGarcom(garcom);
        user.pedirConta(garcom);
    }

}
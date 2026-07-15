public record Prato(int id, int quantidade, int preco) {
    public Prato {
        if (id < 0 || id > 6)
            throw new IllegalArgumentException("ID de prato inválido");
        if (quantidade < 0)
            throw new IllegalArgumentException("Quantidade de pratos inválida");
    }

    public static int getPreco(int id) {
        return switch (id) {
            case 1 -> 12;
            case 2 -> 30;
            case 3 -> 8;
            case 4 -> 2;
            case 5 -> 4;
            case 6 -> 5;
            default -> -1;
        };
    }

    public static String getNome(int id) {
        return switch (id) {
            case 1 -> "hamburguer";
            case 2 -> "pizza de queijo";
            case 3 -> "batata frita";
            case 4 -> "agua";
            case 5 -> "limonada";
            case 6 -> "refrigerante";
            default -> "";
        };
    }

    public String getNome() {
        return switch (this.id) {
            case 1 -> "hamburguer";
            case 2 -> "pizza de queijo";
            case 3 -> "batata frita";
            case 4 -> "agua";
            case 5 -> "limonada";
            case 6 -> "refrigerante";
            default -> "";
        };
    }
}
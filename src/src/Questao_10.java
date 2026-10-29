import java.util.Arrays;
import java.util.List;

class Pedido {
    private int id;
    private double valor;

    public Pedido(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }

    public double getValor() { return valor; }
}

public class Questao_10 {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
                new Pedido(1, 150.50),
                new Pedido(2, 89.90),
                new Pedido(3, 200.00)
        );

        double total = pedidos.stream()
                .mapToDouble(Pedido::getValor)
                .sum();

        System.out.println(total);
    }
}
import java.util.Arrays;
import java.util.List;

public class Questao_03 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        numeros.forEach(n -> System.out.println(n * 2));
    }
}

import java.util.Arrays;
import java.util.List;

public class Questao_01 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(4, 25, 32, 78, 45, 13, 10, 77, 58, 61, 52);

        numeros.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
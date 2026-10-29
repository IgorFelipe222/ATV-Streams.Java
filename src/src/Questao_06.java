import java.util.Arrays;
import java.util.List;

public class Questao_06 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(10, 45, 2, 89, 34);

        int maior = numeros.stream()
                .max(Integer::compareTo)
                .orElseThrow();

        System.out.println(maior);
    }
}
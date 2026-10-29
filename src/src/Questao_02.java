import java.util.Arrays;
import java.util.List;

public class Questao_02 {
    public static void main(String[] args) {

        List<String> nomes = Arrays.asList("igor", "ana", "carlos", "beatriz");

        nomes.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
import java.util.Arrays;
import java.util.List;

public class Questao_07 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("computador", "java", "stream", "código", "sol");

        long quantidade = palavras.stream()
                .filter(p -> p.length() > 5)
                .count();

        System.out.println(quantidade);
    }
}
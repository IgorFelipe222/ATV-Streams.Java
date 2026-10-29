import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Questao_11 {
    public static void main(String[] args) {
        List<String> palavras = Arrays.asList("sol", "lua", "java", "stream", "código", "casa");

        Map<Integer, List<String>> agrupadoPorTamanho = palavras.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(agrupadoPorTamanho);
    }
}

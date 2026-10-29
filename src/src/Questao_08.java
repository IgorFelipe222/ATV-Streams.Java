import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
}

public class Questao_08 {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa("Ana", 20),
                new Pessoa("Carlos", 15),
                new Pessoa("Maria", 25)
        );

        List<String> nomes = pessoas.stream()
                .filter(p -> p.getIdade() > 18)
                .map(Pessoa::getNome)
                .collect(Collectors.toList());

        System.out.println(nomes);
    }
}
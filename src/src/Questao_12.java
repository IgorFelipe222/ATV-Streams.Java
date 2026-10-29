import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

enum TipoServico {
    ELETRICO, HIDRAULICO, ALVENARIA
}

class Servico {
    private TipoServico tipoServico;
    private double valor;

    public Servico(TipoServico tipoServico, double valor) {
        this.tipoServico = tipoServico;
        this.valor = valor;
    }

    public TipoServico getTipoServico() { return tipoServico; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return "Tipo: " + tipoServico + ", Valor: R$ " + valor;
    }
}

class Autonomo {
    private String nome;
    private String cpf;
    private List<Servico> servicos;

    public Autonomo(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.servicos = new ArrayList<>();
    }

    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public List<Servico> getServicos() { return servicos; }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
    }
}

public class Questao_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Autonomo> autonomos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Autônomo");
            System.out.println("2 - Cadastrar Serviço para Autônomo");
            System.out.println("3 - Consultar Serviços de Autônomo por CPF");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    autonomos.add(new Autonomo(nome, cpf));
                    System.out.println("Autônomo cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Digite o CPF do autônomo: ");
                    String cpfBusca = scanner.nextLine();

                    Autonomo autonomoEncontrado = autonomos.stream()
                            .filter(a -> a.getCpf().equals(cpfBusca))
                            .findFirst()
                            .orElse(null);

                    if (autonomoEncontrado != null) {
                        System.out.println("Selecione o Tipo de Serviço:");
                        System.out.println("1 - ELETRICO | 2 - HIDRAULICO | 3 - ALVENARIA");
                        int tipoOpcao = scanner.nextInt();
                        TipoServico tipo = switch (tipoOpcao) {
                            case 1 -> TipoServico.ELETRICO;
                            case 2 -> TipoServico.HIDRAULICO;
                            case 3 -> TipoServico.ALVENARIA;
                            default -> null;
                        };

                        if (tipo != null) {
                            System.out.print("Valor do serviço: ");
                            double valor = scanner.nextDouble();
                            autonomoEncontrado.adicionarServico(new Servico(tipo, valor));
                            System.out.println("Serviço cadastrado com sucesso!");
                        } else {
                            System.out.println("Tipo inválido.");
                        }
                    } else {
                        System.out.println("Autônomo não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o CPF para consulta: ");
                    String cpfConsulta = scanner.nextLine();

                    List<Servico> servicosConsultados = autonomos.stream()
                            .filter(a -> a.getCpf().equals(cpfConsulta))
                            .flatMap(a -> a.getServicos().stream())
                            .collect(Collectors.toList());

                    if (servicosConsultados.isEmpty()) {
                        System.out.println("Nenhum serviço encontrado ou autônomo inexistente.");
                    } else {
                        System.out.println("Serviços prestados:");
                        servicosConsultados.forEach(System.out::println);

                        double totalValores = servicosConsultados.stream()
                                .mapToDouble(Servico::getValor)
                                .sum();
                        System.out.println("Valor total dos serviços: R$ " + totalValores);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
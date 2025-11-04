import com.google.gson.Gson;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);
        ConsultaApi consulta = new ConsultaApi();
        Gson gson = new Gson();
        String minhaChaveApi = "8af76e37cdc33d3e7090e38b";

        int opcao = 0;
        String menu = """
                *************************************************
                Seja bem-vindo(a) ao Conversor de Moedas!
                
                Escolha uma das opções para conversão:
                
                1) Dólar (USD) => Real Brasileiro (BRL)
                2) Real Brasileiro (BRL) => Dólar (USD)
                3) Dólar (USD) => Peso Argentino (ARS)
                4) Peso Argentino (ARS) => Dólar (USD)
                5) Dólar (USD) => Peso Colombiano (COP)
                6) Peso Colombiano (COP) => Dólar (USD)
                7) Sair
                
                Digite a opção desejada:
                *************************************************
                """;

        while (opcao != 7) {
            System.out.println(menu);

            try {
                opcao = leitura.nextInt();

                if (opcao == 7) {
                    System.out.println("Finalizando o programa. Obrigado!");
                    break;
                }

                String moedaOrigem = "";
                String moedaDestino = "";
                String simboloOrigem = "";
                String simboloDestino = "";

                switch (opcao) {
                    case 1:
                        moedaOrigem = "USD";
                        moedaDestino = "BRL";
                        simboloOrigem = "$";
                        simboloDestino = "R$";
                        break;
                    case 2:
                        moedaOrigem = "BRL";
                        moedaDestino = "USD";
                        simboloOrigem = "R$";
                        simboloDestino = "$";
                        break;
                    case 3:
                        moedaOrigem = "USD";
                        moedaDestino = "ARS";
                        simboloOrigem = "$";
                        simboloDestino = "$";
                        break;
                    case 4:
                        moedaOrigem = "ARS";
                        moedaDestino = "USD";
                        simboloOrigem = "$";
                        simboloDestino = "$";
                        break;
                    case 5:
                        moedaOrigem = "USD";
                        moedaDestino = "COP";
                        simboloOrigem = "$";
                        simboloDestino = "$";
                        break;
                    case 6:
                        moedaOrigem = "COP";
                        moedaDestino = "USD";
                        simboloOrigem = "$";
                        simboloDestino = "$";
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha um número de 1 a 7.");
                        continue;
                }

                System.out.println("Digite o valor que deseja converter (" + moedaOrigem + "):");
                double valorUsuario = leitura.nextDouble();

                String jsonResposta = consulta.buscaParDeMoedas(minhaChaveApi, moedaOrigem, moedaDestino);

                TaxaDeCambio taxa = gson.fromJson(jsonResposta, TaxaDeCambio.class);

                double taxaDeConversao = taxa.conversion_rate();

                double valorConvertido = valorUsuario * taxaDeConversao;

                System.out.println("-------------------------------------------------");
                System.out.printf("Valor de %s %.2f (%s) equivale a %s %.2f (%s)\n",
                        simboloOrigem, valorUsuario, moedaOrigem,
                        simboloDestino, valorConvertido, moedaDestino);
                System.out.println("-------------------------------------------------");
                System.out.println("Pressione Enter para continuar...");
                leitura.nextLine(); // Consome o '\n' do nextDouble
                leitura.nextLine(); // Espera o usuário pressionar Enter

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, digite apenas números.");
                leitura.next(); // Limpa o buffer do scanner
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
            }
        }
    }
}
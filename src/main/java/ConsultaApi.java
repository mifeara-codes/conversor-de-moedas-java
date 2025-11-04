import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {

    public String buscaParDeMoedas(String suaChaveApi, String moedaOrigem, String moedaDestino) {

        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/" + suaChaveApi + "/pair/" + moedaOrigem + "/" + moedaDestino);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro ao consultar a API: " + e.getMessage());
        }
    }
}

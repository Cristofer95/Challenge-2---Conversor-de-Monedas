import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Locale;

public class ConexionAPI {

    public static double convertirMoneda(String monedaBase, String monedaDestino, double cantidad) {
        String url = "https://v6.exchangerate-api.com/v6/e1846a26aa5a29cde41c6296/latest/" + monedaBase;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject rates = json.getAsJsonObject("conversion_rates");

            double tasaCambio = rates.get(monedaDestino.toUpperCase(Locale.ROOT)).getAsDouble();
            return cantidad * tasaCambio;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

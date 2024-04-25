package openexchange;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeService {
    // URL incorporando la clave API y la divisa base (USD)
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/a82df5dec1c0d1ef9130c716/latest/USD";

    public String fetchExchangeRates() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                return response.body();
            } else {
                System.err.println("Failed to fetch exchange rates: HTTP error code " + response.statusCode());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error during HTTP request:");
            e.printStackTrace();
            return null;
        }
    }
}


package openexchange;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonRateParser {
    public static double parseRate(String jsonResponse, String currencyCode) {
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            if (conversionRates == null) {
                System.err.println("Error: 'conversion_rates' object is null.");
                return 0.0;
            }

            return conversionRates.get(currencyCode).getAsDouble();
        } catch (Exception e) {
            System.err.println("Error parsing JSON response:");
            e.printStackTrace();
            return 0.0;
        }
    }
}

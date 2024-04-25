package test;

import openexchange.CurrencyConverter;
import openexchange.ExchangeService;
import openexchange.JsonRateParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CurrencyExchangeAppTest {

    @Test
    public void testFetchExchangeRates() {
        ExchangeService exchangeService = Mockito.mock(ExchangeService.class);
        Mockito.when(exchangeService.fetchExchangeRates()).thenReturn("{ \"rates\": { \"EUR\": 0.85, \"JPY\": 110.5 } }");

        String jsonResponse = exchangeService.fetchExchangeRates();
        Assertions.assertNotNull(jsonResponse, "The jsonResponse should not be null");

        double euroRate = JsonRateParser.parseRate(jsonResponse, "EUR");
        Assertions.assertEquals(0.85, euroRate, 0.001, "The EUR exchange rate should match the expected value");

        double jpyRate = JsonRateParser.parseRate(jsonResponse, "JPY");
        Assertions.assertEquals(110.5, jpyRate, 0.001, "The JPY exchange rate should match the expected value");
    }

    @Test
    public void testCurrencyConversion() {
        double amount = 100; // 100 USD
        double rate = 0.85; // Example rate for EUR

        double convertedAmount = CurrencyConverter.convert(amount, rate);
        Assertions.assertEquals(85, convertedAmount, 0.001, "100 USD should convert to 85 EUR given the rate of 0.85");
    }
}

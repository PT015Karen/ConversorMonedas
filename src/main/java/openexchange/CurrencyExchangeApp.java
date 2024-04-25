package openexchange;

import java.util.Scanner;

public class CurrencyExchangeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExchangeService service = new ExchangeService();
        String jsonResponse = service.fetchExchangeRates();

        boolean continuar = true;

        do {
            try {
                System.out.println("Introduzca el importe en USD:");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del escáner

                System.out.println("Introduzca el código de la divisa de destino (por ejemplo, EUR, JPY, GBP):");
                String currencyCode = scanner.nextLine().toUpperCase();

                double rate = JsonRateParser.parseRate(jsonResponse, currencyCode);
                if (rate == 0) {
                    System.out.println("Código de divisa no válido o no disponible.");
                } else {
                    double convertedAmount = CurrencyConverter.convert(amount, rate);
                    System.out.printf("%.2f USD en %s es aproximadamente %.2f\n", amount, currencyCode, convertedAmount);
                }
            } catch (Exception e) {
                System.out.println("Error en la entrada. Por favor, intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer del escáner en caso de una entrada incorrecta
            }

            System.out.println("¿Desea realizar otra conversión? (s/n)");
            String respuesta = scanner.nextLine();
            continuar = respuesta.equalsIgnoreCase("s");
        } while (continuar);

        System.out.println("Gracias por usar nuestro servicio de cambio de divisas.");
        scanner.close();
    }
}


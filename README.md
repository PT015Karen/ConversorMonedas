# ConversorMonedas

## Descripción
Este proyecto es una aplicación de consola para convertir montos en dólares estadounidenses (USD) a otras monedas utilizando la API de ExchangeRate-API. La aplicación permite a los usuarios introducir una cantidad en USD y la moneda a la que desean convertir, proporcionando una interfaz de consola para obtener conversiones de divisas al día.

## Funcionalidades
- **Consulta de Tasas de Cambio**: Obtiene las tasas de cambio actuales desde la API de ExchangeRate-API.
- **Conversión de Divisas**: Permite al usuario convertir una cantidad específica de USD a la moneda de su elección basándose en las tasas de cambio más recientes.
- **Soporte para Múltiples Monedas**: Capacidad para convertir USD a diversas monedas extranjeras como EUR, GBP, JPY, etc.

## Requisitos Previos
Para ejecutar este proyecto necesitas tener instalado:
- Java JDK 11 o superior
- Maven para gestionar las dependencias y ejecutar la aplicación

## Cómo Instalar y Ejecutar
Clona el repositorio a tu máquina local:
```bash
git clone https://tu-repositorio/currency-exchange-app.git
cd currency-exchange-app
```
Para construir el proyecto y ejecutar las pruebas, usa Maven:
```bash
mvn clean install
```

## Uso
Al ejecutar la aplicación, se te pedirá que introduzcas el monto en USD y luego el código de la moneda a la que deseas convertir. Por ejemplo:
```bash
Enter the amount in USD:
100
Enter the target currency code (e.g., EUR, JPY, GBP):
EUR
```
Después de ingresar estos detalles, la aplicación mostrará la cantidad convertida en la moneda deseada utilizando la tasa de cambio más reciente.

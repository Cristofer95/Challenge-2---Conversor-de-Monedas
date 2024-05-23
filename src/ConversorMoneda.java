import java.util.Scanner;
public class ConversorMoneda {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("// Bienvenido al conversor de monedas Alura //" +
                "\n IMPORTANTE = Para el buen funcionamiento debe de procurar escribir correctamente lo solicitado <3");
        System.out.println("*****************************************************************\n" +
                "*****************************************************************");

        try {
            System.out.println("Ingrese la moneda base =\n" +
                    "Escribe 'ARS' si deseas Peso argentino\n" +
                    "Escribe 'BOB' si deseas Peso boliviano\n" +
                    "Escribe 'BRL' si deseas Real brasileño\n" +
                    "Escribe 'CLP' si deseas Peso chileno\n" +
                    "Escribe 'COP' si deseas Peso colombiano\n" +
                    "Escribe 'USD' si deseas - Dólar estadounidense):");
            String monedaBase = scanner.next().toUpperCase();
            System.out.println("*****************************************************************\n" +
                    "*****************************************************************");
            System.out.println("Muy bien, ahora ingrese la moneda destino =\n" +
                    "Escribe 'ARS' si deseas Peso argentino\n" +
                    "Escribe 'BOB' si deseas Peso boliviano\n" +
                    "Escribe 'BRL' si deseas Real brasileño\n" +
                    "Escribe 'CLP' si deseas Peso chileno\n" +
                    "Escribe 'COP' si deseas Peso colombiano\n" +
                    "Escribe 'USD' si deseas - Dólar estadounidense):");
            String monedaDestino = scanner.next().toUpperCase();
            System.out.println("*****************************************************************\n" +
                    "*****************************************************************");
            System.out.println("Por ultimo,ingrese la cantidad a la que desea convertir:");
            double cantidad = scanner.nextDouble();

            double resultado = ConexionAPI.convertirMoneda(monedaBase, monedaDestino, cantidad);
            if (resultado != -1) {
                System.out.println("El resultado de la conversión es: " + resultado + " " + monedaDestino);
            } else {
                System.out.println("Error al realizar la conversión.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingrese un número válido para la cantidad.");
        }
    }
}

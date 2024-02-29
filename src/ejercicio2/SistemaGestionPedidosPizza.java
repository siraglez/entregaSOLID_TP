package ejercicio2;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SistemaGestionPedidosPizza {
    public static void main(String[] args) {
        //Crear instancia centralizada de DataBaseManager
        DataBaseManager dataBaseManager = new DataBaseManager();

        //Inyectar instancias de las clases que las necesitan
        Authenticator authenticator = new Authenticator(dataBaseManager);
        OrderManager orderManager = new OrderManager(dataBaseManager);
        PaymentProcessor paymentProcessor = new PaymentProcessor(dataBaseManager);

        //Pedir al usuario que introduzca las credenciales
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        //Autenticar al usuario
        boolean isAuthenticated = authenticator.authenticateUser(username, password);

        if (isAuthenticated) {
            System.out.println("Autenticación exitosa. \n");

            //Menú de pizzas y precios
            Map<String, Double> menu = new HashMap<>();
            menu.put("pizza pepperoni", 10.99);
            menu.put("pizza 4 quesos", 11.99);
            menu.put("pizza jamón y queso", 9.99);

            //Mostrar el menú
            System.out.println("Menú de Pizzas:");
            for (Map.Entry<String, Double> entry : menu.entrySet()) {
                System.out.println(entry.getKey() + ": $" + entry.getValue());
            }

            //Permitir al usuario seleccionar una pizza y la cantidad deseada
            System.out.println("\nSeleccione la pizza que desea: ");
            String selectedPizza = scanner.nextLine();
            System.out.println("Ingrese la cantidad que desea pedir: ");
            int quantity = scanner.nextInt();

            //Calcular el total a pagar
            double totalAmount = menu.getOrDefault(selectedPizza, 0.0) * quantity;

            //Realizar el pedido
            orderManager.createOrder(selectedPizza, quantity);

            //Ejemplo de procesamiento de pago
            System.out.println("\nIngrese el número de su tarjeta de crédito (ejemplo: tarjeta123): ");
            scanner.nextLine(); //Consumir la nueva línea pendiente
            String creditCardNumber = scanner.nextLine();

            boolean isPaymentSuccessful = paymentProcessor.processPayment(creditCardNumber, totalAmount);
            System.out.println("Procesamiento de pago: " + (isPaymentSuccessful ? "Exitoso" : "Fallido"));
        } else {
            System.out.println("Autenticación fallida. Cierre del programa.");
        }
        //Cerrar el scanner al final del programa
        scanner.close();
    }
}

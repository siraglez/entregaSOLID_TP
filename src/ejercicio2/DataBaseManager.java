package ejercicio2;

import java.util.HashMap;
import java.util.Map;

public class DataBaseManager {
    private Map<String, String> userCredentials = new HashMap<>(); //Simulando almacenamiento de credenciales en memoria
    private Map<String, Integer> orders = new HashMap<>(); //Simulando almacenamiento de pedidos en memoria
    private Map<String, Double> creditCardBalances = new HashMap<>(); //Simulando saldos de tarjetas de crédito en memoria

    public DataBaseManager() {
        //Datos de ejemplo
        userCredentials.put("usuario", "contraseña"); //Usuario de ejemplo con contraseña
        creditCardBalances.put("tarjeta123", 1000.0); //Saldo inicial de la tarjeta de crédito de ejemplo
    }

    public boolean checkUserCredentials(String username, String password) {
        //Verificar las credenciales del usuario
        return userCredentials.containsKey(username) && userCredentials.get(username).equals(password);
    }

    public void saveOrder(String pizzaType, int quantity) {
        //Guardar el pedido en la base de datos
        int existingQuantity = orders.getOrDefault(pizzaType, 0);
        orders.put(pizzaType, existingQuantity + quantity);
    }

    public boolean chargeCreditCard(String creditCardNumber, double amount) {
        //Simular el proceso de carga en la tarjeta de crédito
        if (creditCardBalances.containsKey(creditCardNumber) && creditCardBalances.get(creditCardNumber) >= amount) {
            double newBalance = creditCardBalances.get(creditCardNumber) - amount;
            creditCardBalances.put(creditCardNumber, newBalance);
            return true;
        }
        return false;
    }

    //TODO: Otros métodos relacionados con operaciones CRUD en la base de datos
}

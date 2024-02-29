package ejercicio2;

public class OrderManager {
    private DataBaseManager dataBaseManager;

    public OrderManager(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    public void createOrder(String pizzaType, int quantity) {
        //Lógica para crear un pedido
        dataBaseManager.saveOrder(pizzaType, quantity);
        System.out.println("Pedido creado: " + quantity + " x " + pizzaType);
    }

    //TODO: Otros métodos relacionados con la gestión de pedidos
}

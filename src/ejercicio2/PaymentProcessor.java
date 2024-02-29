package ejercicio2;

public class PaymentProcessor {
    private DataBaseManager dataBaseManager;

    public PaymentProcessor(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    public boolean processPayment(String creditCardNumber, double amount) {
        //Lógica para procesar el pago
        if (dataBaseManager.chargeCreditCard(creditCardNumber, amount)) {
            System.out.println("Pago exitoso: $" + amount);
            return true;
        } else {
            System.out.println("Fallo en el procesamiento del pago.");
            return false;
        }
    }

    //TODO: Otros métodos relacionados con el procesamiento de pagos
}

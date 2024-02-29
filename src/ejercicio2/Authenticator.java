package ejercicio2;

public class Authenticator {
    private DataBaseManager dataBaseManager;

    public Authenticator(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    public boolean authenticateUser(String username, String password) {
        //Lógica de autenticación
        //Retorna true si la autenticación es exitosa, de l contrario, devuelve false
        return dataBaseManager.checkUserCredentials(username, password);
    }
}

package ejercicio1;

public class Matriz {
    protected int[][] m;

    //Constructor para la creación de la matriz
    public Matriz (int[][] m) {
        this.m = m;
    }

    //Método para imprimir la matriz
    public void imprimir() {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.println(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Método para calcular la transpuesta de la matriz
    public Matriz transpuesta() {
        int filas = m.length;
        int columnas = m[0].length;

        int[][] mt = new int[columnas][filas];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                mt[j][i] = m[i][j];
            }
        }
        return new Matriz(mt);
    }

    public static void main(String[] args) {
        Matriz m = new Matriz(new int[][]{{1, 2}, {3, 4}});
        Matriz mt = m.transpuesta();

        System.out.println("ejercicio1.Matriz original: ");
        m.imprimir();

        System.out.println("\nejercicio1.Matriz transpuesta: ");
        mt.imprimir();

    }
}
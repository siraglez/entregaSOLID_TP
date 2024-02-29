Link al repositorio: https://github.com/siraglez/entregaSOLID_TP.git

# Ejercicio Práctico 1: Creación de una Clase Matriz en Java

- `protected int[][] m;`: Declara una matriz de enteros llamada `m`. La palabra clave `protected` indica que esta variable es accesible dentro de la clase y sus subclases.
- `public Matriz(int[][] m)`: Constructor de la clase. Recibe una matriz de enteros como parámetro y asigna esa matriz a la variable de instancia `m`.
- `public void imprimir()`: Método para imprimir la matriz en la consola. Utiliza bucles anidados para recorrer cada elemento de la matriz e imprime cada elemento seguido por un espacio. Al final de cada fila, imprime una nueva línea.
- `public Matriz transpuesta()`: Método que calcula y devuelve la matriz transpuesta. La matriz transpuesta se obtiene intercambiando filas por columnas. Crea una nueva matriz `mt` con las dimensiones intercambiadas y copia los elementos correspondientes de la matriz original.

## Método Main

- `public static void main(String[] args)`: Método principal que sirve como punto de entrada del programa.

  - `Matriz m = new Matriz(new int[][]{{1, 2}, {3, 4}});`: Crea una instancia de la clase `Matriz` con una matriz de 2x2.
  - `Matriz mt = m.transpuesta();`: Calcula la matriz transpuesta de la matriz `m` y la guarda en una nueva instancia `mt`.
  - `System.out.println("ejercicio1.Matriz original: ");`: Imprime un mensaje indicando que se mostrará la matriz original.
  - `m.imprimir();`: Llama al método `imprimir` para mostrar la matriz original.
  - `System.out.println("\nejercicio1.Matriz transpuesta: ");`: Imprime un mensaje indicando que se mostrará la matriz transpuesta.
  - `mt.imprimir();`: Llama al método `imprimir` para mostrar la matriz transpuesta.

En resumen, este código define una clase `Matriz` con métodos para imprimir la matriz y calcular su transpuesta. En el método principal, crea una instancia de la matriz, calcula su transpuesta y luego imprime ambas matrices. La salida esperada sería la matriz original y su versión transpuesta.


# Ejercicio 2: Sistema de Gestión de Pedidos de Pizza en Línea

Este código Java representa un sistema simple de gestión de pedidos de pizza con autenticación de usuarios y procesamiento de pagos. A continuación, se presenta una explicación detallada de las clases y su funcionalidad:

## 1. DataBaseManager

Esta clase simula la gestión de una base de datos en memoria con tres mapas:

- `userCredentials` para almacenar nombres de usuario y contraseñas.
- `orders` para almacenar pedidos y cantidades.
- `creditCardBalances` para simular saldos de tarjetas de crédito.

Contiene métodos para:

- Verificar credenciales de usuario (`checkUserCredentials`).
- Guardar pedidos (`saveOrder`).
- Cargar tarjetas de crédito (`chargeCreditCard`).

Al instanciarse, se inicializan datos de ejemplo.

## 2. OrderManager

Esta clase gestiona la creación de pedidos y tiene una referencia a `DataBaseManager`. El método `createOrder` utiliza `dataBaseManager` para guardar el pedido y luego imprime un mensaje de confirmación.

## 3. PaymentProcessor

Esta clase se encarga del procesamiento de pagos y también tiene una referencia a `DataBaseManager`. El método `processPayment` utiliza `dataBaseManager` para cargar la tarjeta de crédito y devuelve un resultado booleano indicando si la transacción fue exitosa.

## 4. Authenticator

Esta clase maneja la autenticación de usuarios y, al igual que las anteriores, tiene una referencia a `DataBaseManager`. El método `authenticateUser` utiliza `dataBaseManager` para verificar las credenciales del usuario y devuelve un resultado booleano.

## 5. SistemaGestionPedidosPizza

* La clase principal que contiene el método `main` para ejecutar el programa. Crea una instancia de `DataBaseManager` y luego inyecta instancias de `Authenticator`, `OrderManager`, y `PaymentProcessor`.
* Pide al usuario que ingrese sus credenciales y autentica al usuario utilizando `Authenticator`. Si la autenticación es exitosa, muestra un menú de pizzas con precios, permite al usuario hacer un pedido, calcula el total y procesa el pago con `OrderManager` y `PaymentProcessor`.

En resumen, el código simula un sistema de pedidos de pizza con funciones básicas como autenticación de usuario, gestión de pedidos y procesamiento de pagos, utilizando una estructura modular y una base de datos en memoria.

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

# Pseudocódigo

```java
Algoritmo Matriz
    Matriz m

    Procedimiento Matriz(m: matriz)
        m <- m

    Procedimiento imprimir()
        Para cada fila en m
            Para cada elemento en fila
                Imprimir (elemento + " ")
            Fin Para
            Imprimir (nueva línea)
        Fin Para

    Función transpuesta() retorna Matriz
        filas <- longitud de m
        columnas <- longitud de m[0]

        #Crear una nueva matriz para la transpuesta
        mt <- nueva Matriz de dimensiones [columnas][filas]

        #Calcular la transpuesta
        Para i desde 0 hasta filas exclusivo
            Para j desde 0 hasta longitud de m[i] exclusivo
                mt[j][i] <- m[i][j]
            Fin Para
        Fin Para

        Devolver mt

    Procedimiento principal()
        #Crear una matriz
        m <- nueva Matriz con los elementos {{1, 2}, {3, 4}}

        #Calcular la transpuesta
        mt <- m.transpuesta()

        Imprimir ("Matriz original: ")
        m.imprimir()

        Imprimir (nueva línea)
        Imprimir ("Matriz transpuesta: ")
        mt.imprimir()
Fin Algoritmo

```


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

# Pseudocódigo

```java
Algoritmo Authenticator
    Privado
        dataBaseManager: DataBaseManager

    Procedimiento Authenticator(dataBaseManager: DataBaseManager)
        dataBaseManager <- dataBaseManager

    Función autenticarUsuario(usuario: Cadena, contraseña: Cadena) retorna Booleano
        #Lógica de autenticación
        #Retorna verdadero si la autenticación es exitosa, de lo contrario, devuelve falso
        Retornar dataBaseManager.verificarCredencialesUsuario(usuario, contraseña)
    Fin Función
Fin Algoritmo

Algoritmo DataBaseManager
    Privado
        userCredentials: Mapa(Cadena, Cadena)
        orders: Mapa(Cadena, Entero)
        creditCardBalances: Mapa(Cadena, Real)

    Procedimiento DataBaseManager()
        #Datos de ejemplo
        userCredentials <- nuevo Mapa(Cadena, Cadena)
        orders <- nuevo Mapa(Cadena, Entero)
        creditCardBalances <- nuevo Mapa(Cadena, Real)

        #Usuario de ejemplo con contraseña
        userCredentials.agregar("usuario", "contraseña")

        #Saldo inicial de la tarjeta de crédito de ejemplo
        creditCardBalances.agregar("tarjeta123", 1000.0)
    Fin Procedimiento

    Función verificarCredencialesUsuario(usuario: Cadena, contraseña: Cadena) retorna Booleano
        #Verificar las credenciales del usuario
        Retornar userCredentials.contieneClave(usuario) Y userCredentials.obtener(usuario) = contraseña
    Fin Función

    Procedimiento guardarPedido(tipoPizza: Cadena, cantidad: Entero)
        #Guardar el pedido en la base de datos
        cantidadExistente <- orders.obtenerODefecto(tipoPizza, 0)
        orders.agregar(tipoPizza, cantidadExistente + cantidad)
    Fin Procedimiento

    Función cargarTarjetaCredito(numeroTarjeta: Cadena, monto: Real) retorna Booleano
        #Simular el proceso de carga en la tarjeta de crédito
        Si creditCardBalances.contieneClave(numeroTarjeta) Y creditCardBalances.obtener(numeroTarjeta) >= monto Entonces
            nuevoSaldo <- creditCardBalances.obtener(numeroTarjeta) - monto
            creditCardBalances.agregar(numeroTarjeta, nuevoSaldo)
            Retornar Verdadero
        Sino
            Retornar Falso
        Fin Si
    Fin Función
Fin Algoritmo

Algoritmo OrderManager
    Privado
        dataBaseManager: DataBaseManager

    Procedimiento OrderManager(dataBaseManager: DataBaseManager)
        dataBaseManager <- dataBaseManager

    Procedimiento crearPedido(tipoPizza: Cadena, cantidad: Entero)
        #Lógica para crear un pedido
        dataBaseManager.guardarPedido(tipoPizza, cantidad)
        Imprimir "Pedido creado: " + cantidad + " x " + tipoPizza
    Fin Procedimiento
Fin Algoritmo

Algoritmo PaymentProcessor
    Privado
        dataBaseManager: DataBaseManager

    Procedimiento PaymentProcessor(dataBaseManager: DataBaseManager)
        dataBaseManager <- dataBaseManager

    Función procesarPago(numeroTarjeta: Cadena, monto: Real) retorna Booleano
        #Lógica para procesar el pago
        Si dataBaseManager.cargarTarjetaCredito(numeroTarjeta, monto) Entonces
            Imprimir "Pago exitoso: $" + monto
            Retornar Verdadero
        Sino
            Imprimir "Fallo en el procesamiento del pago."
            Retornar Falso
        Fin Si
    Fin Función
Fin Algoritmo

Algoritmo SistemaGestionPedidosPizza
    #Crear instancia centralizada de DataBaseManager
    dataBaseManager <- nuevo DataBaseManager()

    #Inyectar instancias de las clases que las necesitan
    authenticator <- nuevo Authenticator(dataBaseManager)
    orderManager <- nuevo OrderManager(dataBaseManager)
    paymentProcessor <- nuevo PaymentProcessor(dataBaseManager)

    #Pedir al usuario que introduzca las credenciales
    Imprimir "Ingrese su nombre de usuario: "
    usuario <- Leer Cadena
    Imprimir "Ingrese su contraseña: "
    contraseña <- Leer Cadena

    #Autenticar al usuario
    autenticado <- authenticator.autenticarUsuario(usuario, contraseña)

    Si autenticado Entonces
        Imprimir "Autenticación exitosa. \n"

        #Menú de pizzas y precios
        menu <- nuevo Mapa(Cadena, Real)
        menu.agregar("pizza pepperoni", 10.99)
        menu.agregar("pizza 4 quesos", 11.99)
        menu.agregar("pizza jamón y queso", 9.99)

        #Mostrar el menú
        Imprimir "Menú de Pizzas:"
        Para cada entrada en menu
            Imprimir entrada.clave + ": $" + entrada.valor
        Fin Para

        #Permitir al usuario seleccionar una pizza y la cantidad deseada
        Imprimir "\nSeleccione la pizza que desea: "
        pizzaSeleccionada <- Leer Cadena
        Imprimir "Ingrese la cantidad que desea pedir: "
        cantidad <- Leer Entero

        #Calcular el total a pagar
        totalPagar <- menu.obtenerODefecto(pizzaSeleccionada, 0.0) * cantidad

        #Realizar el pedido
        orderManager.crearPedido(pizzaSeleccionada, cantidad)

        #Ejemplo de procesamiento de pago
        Imprimir "\nIngrese el número de su tarjeta de crédito (ejemplo: tarjeta123): "
        Leer Cadena #Consumir la nueva línea pendiente
        numeroTarjeta <- Leer Cadena

        pagoExitoso <- paymentProcessor.procesarPago(numeroTarjeta, totalPagar)
        Imprimir "Procesamiento de pago: " + (pagoExitoso ? "Exitoso" : "Fallido")
    Sino
        Imprimir "Autenticación fallida. Cierre del programa."
    Fin Si
Fin Algoritmo

```

//contiene el menu iteractivo para que el usuario pueda administrar el inventario
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // Crear el árbol binario de búsqueda
        ArbolBinarioBusqueda inventario = new ArbolBinarioBusqueda();

        int opcion;

        // Menú principal del sistema
        do {

            System.out.println("\n================================");
            System.out.println(" SISTEMA DE CONTROL DE INVENTARIO");
            System.out.println("================================");
            System.out.println("1. Registrar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Mostrar inventario completo");
            System.out.println("5. Salir");
            System.out.println("================================");
            System.out.print("Seleccione una opción: ");

            // Validar que la opción sea un número entero
            while (!entrada.hasNextInt()) {
                System.out.println("Error: ingrese un número válido.");
                entrada.nextLine();
                System.out.print("Seleccione una opción: ");
            }

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {
                // OPCIÓN 1: Registrar producto
                case 1:
                    System.out.println("\n--- REGISTRAR PRODUCTO ---");

                    System.out.print("Nombre del producto: ");
                    String nombre = entrada.nextLine().trim();

                    if (nombre.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                        break;
                    }

                    // Validar que el stock sea un entero no negativo
                    System.out.print("Cantidad en stock: ");

                    while (!entrada.hasNextInt()) {
                        System.out.println("Ingrese una cantidad válida.");
                        entrada.nextLine();
                        System.out.print("Cantidad en stock: ");
                    }

                    int stock = entrada.nextInt();
                    entrada.nextLine();

                    if (stock < 0) {
                        System.out.println("El stock no puede ser negativo.");
                        break;
                    }

                    // Validar que el precio sea un número válido
                    System.out.print("Precio unitario: ");

                    while (!entrada.hasNextDouble()) {
                        System.out.println("Ingrese un precio válido.");
                        entrada.nextLine();
                        System.out.print("Precio unitario: ");
                    }

                    double precio = entrada.nextDouble();
                    entrada.nextLine();

                    if (precio < 0) {
                        System.out.println("El precio no puede ser negativo.");
                        break;
                    }

                    // Insertar el producto en el árbol
                    inventario.insertar(nombre, stock, precio);

                    break;
                    // OPCIÓN 2: Buscar producto
                    case 2:
                        System.out.println("\n--- BUSCAR PRODUCTO ---");
                        System.out.print("Ingrese el nombre del producto: ");
                        nombre = entrada.nextLine().trim();

                        Producto encontrado = inventario.buscar(nombre);

                        if (encontrado != null) {

                            System.out.println("\nProducto encontrado:");
                            System.out.println("Nombre: " + encontrado.nombre);
                            System.out.println("Stock: " + encontrado.stock);
                            System.out.println("Precio: $" + encontrado.precio);

                        } else {
                            System.out.println("El producto no fue encontrado.");
                        }

                        break;

                    // OPCIÓN 3: Eliminar producto
                    case 3:

                        System.out.println("\n--- ELIMINAR PRODUCTO ---");

                        System.out.print("Ingrese el nombre del producto: ");
                        nombre = entrada.nextLine().trim();

                        inventario.eliminar(nombre);

                        break;

                    // OPCIÓN 4: Mostrar inventario
                    case 4:

                        inventario.mostrarInventario();

                        break;

                    // OPCIÓN 5: Salir
                    case 5:

                        System.out.println("\nSaliendo del sistema...");
                        System.out.println("Gracias por utilizar el inventario.");

                        break;

                    // Opción incorrecta
                    default:

                        System.out.println("Opción no válida. Intente nuevamente.");

                        break;
                }

        } while (opcion != 5);

        // Cerrar el objeto Scanner
        entrada.close();
    }
}



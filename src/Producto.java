//Es la clase nodo pero con otro nombre
//representa los ndos del arbol y almacena el nombre, stock, precio y referencias a sus hijoa
public class Producto {

    // Atributos que identifican al producto
    String nombre;
    int stock;
    double precio;

    // Referencias a los hijos del nodo
    Producto izq;
    Producto der;

    // Constructor de la clase Producto
    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;

        // Inicialmente el nodo no tiene hijos
        this.izq = null;
        this.der = null;
    }
}

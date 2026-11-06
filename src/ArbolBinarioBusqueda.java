//Esta clase contiene los metodos para insertar, buscar, eliminar y recorrer los productos

public class ArbolBinarioBusqueda {

    // Nodo principal del árbol
    private Producto raiz;

    // Constructor del árbol
    public ArbolBinarioBusqueda() {
        raiz = null;
    }
    // Metodo para insertar un producto
    public void insertar(String nombre, int stock, double precio) {
        Producto nuevo = new Producto(nombre, stock, precio);

            if (raiz == null) {
                raiz = nuevo;
                System.out.println("Producto registrado correctamente.");
            } else {
                insertarRecursivo(raiz, nuevo);
            }
        }
        // Inserción recursiva respetando el orden alfabético
        private void insertarRecursivo(Producto actual, Producto nuevo) {

            int comparacion = nuevo.nombre.compareTo(actual.nombre);

            if (comparacion < 0) {

                // Si el nombre es menor, se coloca a la izquierda
                if (actual.izq == null) {
                    actual.izq = nuevo;
                    System.out.println("Producto registrado correctamente.");
                } else {
                    insertarRecursivo(actual.izq, nuevo);
                }

            } else if (comparacion > 0) {

                // Si el nombre es mayor, se coloca a la derecha
                if (actual.der == null) {
                    actual.der = nuevo;
                    System.out.println("Producto registrado correctamente.");
                } else {
                    insertarRecursivo(actual.der, nuevo);
                }

            } else {
                // No se permiten productos con nombres duplicados
                System.out.println("El producto ya existe en el inventario.");
            }
        }

        // Metodo para buscar un producto por su nombre
        public Producto buscar(String nombre) {
            return buscarRecursivo(raiz, nombre);
        }

        // Búsqueda recursiva utilizando compareTo()
        private Producto buscarRecursivo(Producto actual, String nombre) {

            // Si el nodo es nulo, el producto no existe
            if (actual == null) {
                return null;
            }

            int comparacion = nombre.compareTo(actual.nombre);

            if (comparacion == 0) {
                return actual;
            } else if (comparacion < 0) {

                // Buscar en el subárbol izquierdo
                return buscarRecursivo(actual.izq, nombre);

            } else {

                // Buscar en el subárbol derecho
                return buscarRecursivo(actual.der, nombre);
            }
        }

        // Metodo público para eliminar un producto
        public void eliminar(String nombre) {

            // Primero verificamos si el producto existe
            if (buscar(nombre) == null) {
                System.out.println("El producto no existe en el inventario.");
                return;
            }

            raiz = eliminarRecursivo(raiz, nombre);

            System.out.println("Producto eliminado correctamente.");
        }

        // Metodo recursivo para eliminar un nodo
        private Producto eliminarRecursivo(Producto actual, String nombre) {

            if (actual == null) {
                return null;
            }

            int comparacion = nombre.compareTo(actual.nombre);

            if (comparacion < 0) {

                // Buscar en el subárbol izquierdo
                actual.izq = eliminarRecursivo(actual.izq, nombre);

            } else if (comparacion > 0) {

                // Buscar en el subárbol derecho
                actual.der = eliminarRecursivo(actual.der, nombre);

            } else {

                // CASO 1: El nodo es una hoja
                if (actual.izq == null && actual.der == null) {
                    return null;
                }

                // CASO 2: El nodo tiene solamente un hijo
                if (actual.izq == null) {
                    return actual.der;
                }

                if (actual.der == null) {
                    return actual.izq;
                }

                // CASO 3: El nodo tiene dos hijos
                // Se busca el sucesor inorden en la rama derecha
                Producto sucesor = obtenerMinimo(actual.der);

                // Se sustituyen los datos del nodo por los del sucesor
                actual.nombre = sucesor.nombre;
                actual.stock = sucesor.stock;
                actual.precio = sucesor.precio;

                // Se elimina el nodo sucesor de la rama derecha
                actual.der = eliminarRecursivo(actual.der, sucesor.nombre);
            }

            return actual;
        }

        // Metodo para encontrar el menor nodo de un subárbol
        private Producto obtenerMinimo(Producto actual) {

            // El menor elemento se encuentra en el extremo izquierdo
            while (actual.izq != null) {
                actual = actual.izq;
            }

            return actual;
        }

        // Metodo público para mostrar el inventario completo
        public void mostrarInventario() {

            if (raiz == null) {
                System.out.println("El inventario está vacío.");
            } else {
                System.out.println("\n===== INVENTARIO DE PRODUCTOS =====");
                inOrden(raiz);
            }
        }

        // Recorrido InOrder: izquierda, raíz, derecha
        private void inOrden(Producto actual) {

            if (actual != null) {

                // Primero se visita el hijo izquierdo
                inOrden(actual.izq);

                // Después se muestra el producto actual
                System.out.println("--------------------------------");
                System.out.println("Nombre: " + actual.nombre);
                System.out.println("Stock: " + actual.stock);
                System.out.println("Precio: $" + actual.precio);

                // Finalmente se visita el hijo derecho
                inOrden(actual.der);
            }
        }
}


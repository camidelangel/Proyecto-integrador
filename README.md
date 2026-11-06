# Sistema de Control de Inventario con Árbol Binario de Búsqueda (ABB)

## Descripción del proyecto

Este proyecto consiste en desarrollar un sistema de control de inventario utilizando un Árbol Binario de Búsqueda (ABB) en Java. El programa permite registrar, buscar, eliminar y mostrar productos de un almacén mediante un menú interactivo en consola.

Cada producto contiene un nombre, una cantidad disponible en stock y un precio unitario. El nombre se utiliza como llave principal para organizar los elementos alfabéticamente dentro del árbol.

## Objetivo

Aplicar los conocimientos sobre estructuras de datos no lineales mediante la implementación de un Árbol Binario de Búsqueda, utilizando nodos y operaciones de inserción, búsqueda, eliminación y recorridos.

## Estructura del proyecto

El proyecto está dividido en tres clases:

- **Producto.java:** contiene los atributos del producto y las referencias a sus hijos izquierdo y derecho.
- **ArbolBinarioBusqueda.java:** implementa las operaciones del árbol binario de búsqueda.
- **Main.java:** contiene el menú interactivo y permite al usuario utilizar las diferentes funciones del sistema.

## Funciones que tiene el programa 

El sistema cuenta con las siguientes opciones:

1. Registrar productos.
2. Buscar productos por nombre.
3. Eliminar productos del inventario.
4. Mostrar todos los productos ordenados alfabéticamente.
5. Salir del programa.

## Implementación del ABB

Para organizar los productos se utiliza el método `compareTo()` de Java, que permite comparar cadenas de texto.

- Si el resultado es menor que cero, el producto se coloca en el subárbol izquierdo.
- Si el resultado es mayor que cero, se coloca en el subárbol derecho.
- Si el resultado es igual a cero, significa que el producto ya existe y no se permite duplicarlo.

Para la eliminación se implementaron los tres casos posibles: eliminación de nodos hoja, nodos con un hijo y nodos con dos hijos mediante el sucesor inorden.

También se implementó el recorrido InOrder para mostrar los productos en orden alfabético.

## Requisitos

- Tener instalado Java JDK.
- Contar con un editor de código o IDE, como NetBeans, IntelliJ IDEA o Visual Studio Code.

## Ejecución

1. Descargar o clonar el repositorio.
2. Abrir la carpeta del proyecto.
3. Abrir una terminal en la ubicación de los archivos Java.
4. Ubicarte en la carpeta src. Obvio con la ruta que tiene en su ordenador por ejemplo:
```bash
  cd "C:\Users\camia\OneDrive\Documentos\uni\ProyectoInventario\src"
```
6. Una vez dentro de src, compilar los archivos con el siguiente comando:

```bash
javac Producto.java ArbolBinarioBusqueda.java Main.java
```

5. Ejecutar el programa:

```bash
java Main
```

6. Utilizar el menú para administrar los productos.

## Lo que utilizamos fue 

- Lenguaje de programación: Java.
- Estructura de datos: Árbol Binario de Búsqueda.
- Entrada de datos: Scanner.
- Comparación de cadenas: compareTo().


## Conclusión

Con este proyecto se aplicaron los conocimientos sobre árboles binarios de búsqueda y manejo de nodos. 
Se logró implementar un sistema que permite administrar productos de manera dinámica, utilizando los nombres como llaves para mantener un orden alfabético. 
Además, se comprendió cómo funcionan las operaciones de inserción, búsqueda, eliminación y recorrido dentro de un ABB.

## Datos: 

Camila amor del angel cervantes 

Sistemas computacionales 3ro "B"

Estructura de datos 

Víctor Hugo Vásquez Herrera.

Instituto Tecnológico Superior de Xalapa.

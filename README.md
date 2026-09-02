# Sistema de Préstamos de Biblioteca (POO Java) 📚

Aplicación de consola desarrollada en Java SE que simula el sistema de gestión y cálculo de préstamos de libros para socios de una biblioteca, emitiendo una boleta detallada con cálculo de importes y totales.

Este proyecto fue desarrollado paso a paso aplicando arquitectura de software limpia y los pilares esenciales de la **Programación Orientada a Objetos (POO)** sin dependencias externas (Java Puro)[cite: 1, 4].

---

## 🚀 Conceptos Técnicos Aplicados

* **Encapsulamiento:** Ocultamiento de datos mediante modificadores de acceso (`private`) e interacción controlada a través de accesores `getters` y `setters`[cite: 1, 4].
* **Composición y Delegación de Responsabilidades:** La clase `ItemPrestamo` contiene a `Libro` y le delega a este la obtención de sus tarifas en lugar de duplicar variables[cite: 1, 4].
* **Atributos y Métodos Estáticos (`static`):** Manejo de contadores compartidos a nivel de clase para la asignación automática y correlativa de folios y códigos de libros[cite: 1, 4].
* **Optimización de Memoria e I/O:**
  * Formateo eficiente de texto utilizando `StringBuilder` para evitar la sobrecreación de objetos String en ciclos[cite: 1, 4].
  * Formateo de fechas con `SimpleDateFormat`[cite: 1, 4].
  * Control del buffer de consola consumiendo saltos de línea pendientes al usar la clase `Scanner`[cite: 1, 4].

---

## 📂 Estructura del Proyecto

El código está organizado bajo una estructura de paquetes limpia siguiendo las convenciones estándar de Java[cite: 1, 4]:

```text
src/
└── org/
    └── sweet/
        └── appbiblioteca/
            ├── EjemploPrestamo.java      # Clase ejecutable (Punto de entrada main)
            └── modelo/                  # Subpaquete con las entidades del dominio
                ├── ItemPrestamo.java     # Renglón del préstamo (Composición)
                ├── Libro.java            # Entidad libro con contador estático
                ├── Prestamo.java         # Boleta completa y control del arreglo
                └── Socio.java            # POJO puro con los datos del socio

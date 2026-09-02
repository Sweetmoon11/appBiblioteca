package org.sweet.appbiblioteca;

import java.util.Scanner;
import org.sweet.appbiblioteca.modelo.*; // Es totalmente válido usar el comodín *

public class EjemploPrestamo {

    public static void main(String[] args) { // Todo el código DEBE estar dentro del main[cite: 2, 3, 7]

        Socio socio = new Socio();
        socio.setNombre("AREQUIPE");
        socio.setNumeroSocio("2210-7");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la observación del préstamo: ");
        String observacion = scanner.nextLine();

        Prestamo prestamo = new Prestamo(observacion, socio);

        // Registro interactivo de 3 libros
        for (int i = 0; i < 3; i++) {
            System.out.println("\n--- Registro de Libro " + (i + 1) + " ---");

            Libro libro = new Libro();
            System.out.println("Código asignado automáticamente: " + libro.getCodigo());

            System.out.print("Ingrese título del libro: ");
            String titulo = scanner.nextLine();
            libro.setTitulo(titulo);

            System.out.print("Ingrese tarifa diaria: ");
            double tarifa = scanner.nextDouble();
            libro.setTarifaDia(tarifa);

            System.out.print("Ingrese cantidad de días en préstamo: ");
            int dias = scanner.nextInt();

            // Limpiamos el buffer del Scanner consumiendo el salto de línea sobrante
            scanner.nextLine();

            ItemPrestamo item = new ItemPrestamo(dias, libro);
            prestamo.addItemPrestamo(item);
        }

        // Imprimir el préstamo
        System.out.println("\n==============================================");
        System.out.println(prestamo);
        System.out.println("==============================================");

        scanner.close();
    }
}

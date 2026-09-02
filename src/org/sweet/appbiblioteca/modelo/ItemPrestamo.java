package org.sweet.appbiblioteca.modelo;

public class ItemPrestamo {
    private Libro libro;
    private int dias;

    public ItemPrestamo(int dias, Libro libro) {
        this.dias = dias;
        this.libro = libro;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double calcularSubtotal() {
        return this.dias * this.libro.getTarifaDia();
    }

    @Override
    public String toString() {
        return libro.toString() + dias + "\t" + calcularSubtotal();
    }
}
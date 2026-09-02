package org.sweet.appbiblioteca.modelo;

public class Libro {

    private int codigo;
    private String titulo;
    private static int ultimoCodigo = 0;
    private double tarifaDia;

    public Libro(){
        this.codigo = ++ultimoCodigo; // Asigna el correlativo único[cite: 1]
    }

    public Libro(String titulo, double tarifaDia) { // Removido 'codigo' del parámetro porque es automático[cite: 1]
        this();
        this.titulo = titulo;
        this.tarifaDia = tarifaDia;
    }

    public double getTarifaDia() {
        return tarifaDia;
    }

    public void setTarifaDia(double tarifaDia) {
        this.tarifaDia = tarifaDia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString(){
        return codigo + "\t" + titulo + "\t" + tarifaDia;
    }
}
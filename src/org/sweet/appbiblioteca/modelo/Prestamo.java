package org.sweet.appbiblioteca.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestamo {
    private String observacion;
    private Date fecha;
    private int folio;
    private Socio socio;
    private int indiceItems;
    private ItemPrestamo[] items; // Nombre del arreglo en PLURAL[cite: 1]
    private static int ultimoFolio = 0;
    public static final int MAX_ITEMS = 10;

    public Prestamo(String observacion, Socio socio){
        this.observacion = observacion;
        this.socio = socio;
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
        this.items = new ItemPrestamo[MAX_ITEMS];
        this.indiceItems = 0;
    }

    public void addItemPrestamo(ItemPrestamo item){
        if (indiceItems < MAX_ITEMS){ // Validar que NO sobrepase el límite[cite: 1]
            this.items[indiceItems++] = item;
        } else {
            System.out.println("No se puede agregar mas item, limite alcanzado");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (int i = 0; i < indiceItems; i++){
            total += this.items[i].calcularSubtotal();
        }
        return total;
    }

    public String generarDetalle(){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");

        sb.append("Prestamo N°: ").append(folio).append("\n");
        sb.append("Socio: ").append(socio.getNombre())
                .append("\tN°Socio: ").append(socio.getNumeroSocio()).append("\n");
        sb.append("Observacion: ").append(observacion).append("\n");
        sb.append("Fecha: ").append(df.format(fecha)).append("\n\n");
        sb.append("#\tTitulo\t$/día\tDias\tSubtotal\n");

        for (int i = 0; i < indiceItems; i++){
            sb.append(this.items[i].toString()).append("\n"); // Se usó items[i] en plural[cite: 1]
        }
        sb.append("\nTotal a pagar: ").append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString(){
        return generarDetalle();
    }

    public int getFolio() {
        return folio;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public ItemPrestamo[] getItems() {
        return items;
    }
}
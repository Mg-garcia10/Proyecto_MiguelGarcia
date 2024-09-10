/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserva.de.habitacion.de.hotel;

/**
 *
 * @author Miguel
 */
public class Habitacion {
    //atributos
    private String tipo;
    private double precio;
    private boolean disponible; 
    private int capacidad;
    //constructores
    public Habitacion(String tipo, double precio, boolean disponible, int capacidad) {
        this.tipo = tipo;
        this.precio = precio;
        this.disponible = disponible;
        this.capacidad = capacidad;
    }
    //getters 
    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }
    
    public boolean getDisponible() {
        return disponible;
    }

    public int getCapacidad() {
        return capacidad;
    }
    //setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public void mostrarInfo() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Precio: $" + precio);
        System.out.println("Disponible: " + (disponible ? "Si" : "No"));
        System.out.println("Capacidad: " + capacidad + " personas");
    }
    //metodo para reservar 
    public void reservar() {
        if (disponible) {
            disponible = false;
        } else {
            System.out.println("La habitacion ya esta reservada.");
        }
    }
    // Metodo para cancelar una reserva en el unico caso que este reservada
    public void cancelar() {
        if (!disponible) {
            disponible = true;
        } else {
            System.out.println("La habitacion no esta reservada.");
        }
    }
    @Override
    public String toString() {
        String disponibilidad = disponible ? "Sí" : "No"; 
        return "Tipo: " + tipo + 
            ", Precio: $" + precio + 
            ", Capacidad: " + capacidad + 
            " personas, Disponible: " + disponibilidad;
    }
}

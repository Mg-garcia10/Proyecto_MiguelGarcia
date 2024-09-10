/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserva.de.habitacion.de.hotel;

import java.util.ArrayList;

/**
 *
 * @author Miguel
 */
public class Gestion {
    //con este arraylist hago una lista de habitaciones disponibles en el hotel
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    
    
    public Gestion() {
        //constructores
        habitaciones.add(new Habitacion("Simple", 50.0, true, 2));
        habitaciones.add(new Habitacion("Doble", 80.0, true, 4));
        habitaciones.add(new Habitacion("Familiar", 100.0, true, 6));
        habitaciones.add(new Habitacion("Suite", 120.0, true, 4));
        
    }
    public void mostrarHabitaciones() {
        System.out.println("------------Lista de habitaciones--------------");
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println((i + 1) + ". " + habitaciones.get(i).toString());
        }
    }

    // Metodo para reservar una habitacion
    public boolean reservarHabitacion(int indice, int numPersonas, String fechaInicio, String fechaFin) {
        // Verifica que el índice esté dentro del rango de la lista de habitaciones
        if (indice >= 0 && indice < habitaciones.size()) {
            Habitacion habitacion = habitaciones.get(indice);
            //verifica si la habitacion fue reservada
            if (!habitacion.getDisponible()) {
                System.out.println("Lo sentimos, \n La habitacion no esta disponible.");
                return false;
            }
            // Verifica si la capacidad de la habitacion es suficiente para el numero de personas
            if (numPersonas > habitacion.getCapacidad()) {
                System.out.println("La habitacion no tiene suficiente capacidad para " + numPersonas + " personas.");
                return false;
            }
            habitacion.setDisponible(false);
            System.out.println("-> Habitacion reservada exitosamente del " + fechaInicio + " al " + fechaFin);
            return true;
        } else {
            System.out.println("-> Lo sentimos \n Habitacion no disponible");
            return false;
        }
    }

    // Metodo para cancelar una reserva
    public void cancelarReserva(int i) {
        if (i >= 0 && i < habitaciones.size()) {
            Habitacion habitacion = habitaciones.get(i);
            //verifica si la habitacion esta reservada 
            if (habitacion.getDisponible()) {
                System.out.println("-> La habitacion no esta reservada.");
            } else {
                habitacion.setDisponible(true);
                System.out.println("-> La reserva fue cancelada con exito.");
            }
        }
    }

    //Metodo para obtener la lista de habitaciones
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserva.de.habitacion.de.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class Gestion {
    //con este arraylist hago una lista de habitaciones disponibles en el hotel
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    private ArrayList<Reservar> reservas = new ArrayList<>();
    
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
    public boolean reservarHabitacion(int indice, int numPersonas, String fechaInicioStr, String fechaFinStr, Usuario usuario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);
            LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatter);

            if (fechaFin.isBefore(fechaInicio)) {
                System.out.println("La fecha de salida no puede ser anterior a la de entrada.");
                return false;
            }

            if (indice >= 0 && indice < habitaciones.size()) {
                Habitacion habitacion = habitaciones.get(indice);

                if (!habitacion.getDisponible()) {
                    System.out.println("Lo sentimos, la habitación no está disponible.");
                    return false;
                }

                if (numPersonas > habitacion.getCapacidad()) {
                    System.out.println("La habitación no tiene suficiente capacidad para " + numPersonas + " personas.");
                    return false;
                }

                habitacion.setDisponible(false);
                Reservar nuevaReserva = new Reservar(usuario, habitacion, fechaInicio, fechaFin);
                reservas.add(nuevaReserva);
                System.out.println("-> Habitación reservada exitosamente del " + fechaInicio + " al " + fechaFin);
                return true;
            }
        } catch (DateTimeParseException e) {
            System.out.println("Formato de fecha incorrecto. Use el formato dd/MM/yyyy.");
        }
        return false;
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
//    public ArrayList<Habitacion> getHabitaciones() {
//        return habitaciones;
//    }
    public ArrayList<Reservar> getReservas() {
        return reservas;
    }
}
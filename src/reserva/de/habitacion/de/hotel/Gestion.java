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
    private ArrayList<Habitacion> habitaciones = new ArrayList<>();
    
    
    public Gestion() {
        
        habitaciones.add(new Habitacion("Individual", 50.0, true));
        habitaciones.add(new Habitacion("Doble", 80.0, true));
        habitaciones.add(new Habitacion("Suite", 120.0, true));
    }

    
    public void mostrarHabitaciones() {
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.printf("Habitación %d: ", i + 1);
            habitaciones.get(i).mostrarInfo();
        }
    }

    
    public void reservarHabitacion(int indice) {
        if (indice >= 0 && indice < habitaciones.size()) {
            Habitacion habitacion = habitaciones.get(indice);
            if (habitacion.isDisponible()) {
                habitacion.setDisponible(false);
                System.out.println("Reserva confirmada para la habitación " + (indice + 1));
            } else {
                System.out.println("La habitación ya está reservada.");
            }
        }
    }

  
    public void cancelarReserva(int indice) {
        if (indice >= 0 && indice < habitaciones.size()) {
            Habitacion habitacion = habitaciones.get(indice);
            if (!habitacion.isDisponible()) {
                habitacion.setDisponible(true);
                System.out.println("Reserva cancelada para la habitación " + (indice + 1));
            } else {
                System.out.println("La habitación no está reservada.");
            }
        
        }
    }
}


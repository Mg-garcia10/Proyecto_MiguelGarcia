/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserva.de.habitacion.de.hotel;

import java.time.LocalDate;

/**
 *
 * @author Miguel
 */
public class Reservar {
    private Usuario usuario;
    private Habitacion habitacion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reservar(Usuario usuario, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.usuario = usuario;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    

    @Override
    public String toString() {
        return "Detalles de la reserva\n" +
               "Huesped: " + usuario.getNombre() + "\n" +
               "ID: " + usuario.getId() + "\n" +
               "Email: " + usuario.getEmail() + "\n" +
               "Telefono: " + usuario.getTelefono() + "\n" +
               "Tipo de habitacion: " + habitacion.getTipo() + "\n" +
               "Costo: Lps." + habitacion.getPrecio() + "\n" +
               "Capacidad: " + habitacion.getCapacidad() + " personas\n" +
               "Fechas de reserva: " + fechaInicio + " - " + fechaFin;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reserva.de.habitacion.de.hotel;

import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class ReservaDeHabitacionDeHotel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea = new Scanner(System.in);
        Gestion gestion = new Gestion();
        Usuario usuario = Usuario.ingresarDatos();

        while (true) {
            // Mostrar el menú
            System.out.println("Menu:");
            System.out.println("1. Mostrar habitaciones");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = lea.nextInt();

            switch (opcion) {
                case 1:
                    gestion.mostrarHabitaciones();
                    break;
                case 2:
                    gestion.mostrarHabitaciones();
                    System.out.print("Ingrese el número de habitación para reservar: ");
                    int reserva = lea.nextInt() - 1;
                    gestion.reservarHabitacion(reserva);
                    break;
                case 3:
                    gestion.mostrarHabitaciones();
                    System.out.print("Ingrese el número de habitación para cancelar la reserva: ");
                    int cancelar = lea.nextInt() - 1;
                    gestion.cancelarReserva(cancelar);
                    break;
                case 4:
                    System.out.println("Gracias por preferirnos");
                    System.out.println("TE ESPERAMOS PRONTO");
                    break;
                default:
                    break;
            }
        }
    }
}

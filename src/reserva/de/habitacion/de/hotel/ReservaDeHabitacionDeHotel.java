/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reserva.de.habitacion.de.hotel;

import java.util.ArrayList;
import java.util.List;
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
        
        int habitacionSeleccionada = -1;
        
        int opc;
        do {
            System.out.println();
            System.out.println("--------BIENVENIDO A THE BLUE DIAMOND RESORT---------");
            System.out.println("");
            System.out.println("---------------------MENU----------------------");
            System.out.println("1) Reservar habitacion");
            System.out.println("2) Ver informacion del usuario");
            System.out.println("3) Mostrar informacion de la reserva");
            System.out.println("4) Salir");
            System.out.print("-> Ingrese el numero de lo que desee hacer: ");
            opc = lea.nextInt();
            
            switch (opc) {
                case 1:
                    gestion.mostrarHabitaciones();
                    System.out.print("Ingrese el número de habitación para reservar: ");
                    int reserva = lea.nextInt() - 1;
                    System.out.print("Ingrese el número de personas: ");
                    int numPersonas = lea.nextInt();
                    lea.nextLine(); 
                    System.out.print("Ingrese la fecha de llegada (dd/MM/yyyy): ");
                    String fechaInicio = lea.nextLine();
                    System.out.print("Ingrese la fecha de salida (dd/MM/yyyy): ");
                    String fechaFin = lea.nextLine();
                    gestion.reservarHabitacion(reserva, numPersonas, fechaInicio, fechaFin, usuario);
                    break;
                case 2:
                    System.out.println("Informacion del Usuario:");
                    System.out.println("Nombre: " + usuario.getNombre());
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Telefono: " + usuario.getTelefono());
                    break;
                case 3:
                    mostrarInformacionReserva(gestion, usuario);
                    break;
                case 4:
                    System.out.println("---------VUELVA PRONTO---------");
                    lea.close(); 
                    break;
                default:
                    System.out.println("Ingrese un numero valido del menu");
                    break;
            }
        } while (opc != 4);
    }//fin del main
    
    private static void mostrarInformacionReserva(Gestion gestion, Usuario usuario) {
    boolean encontrado = false;
    ArrayList<Reservar> reservas = gestion.getReservas(); 
    
    for (int i = 0; i < reservas.size(); i++) {
        Reservar reserva = reservas.get(i);
        if (reserva.getUsuario().equals(usuario)) {
            System.out.println("--------------------------");
            System.out.println(reserva);  
            encontrado = true;
        }
    }
    
    if (!encontrado) {
        System.out.println("No tienes reservas.");
        }
    }
    
}
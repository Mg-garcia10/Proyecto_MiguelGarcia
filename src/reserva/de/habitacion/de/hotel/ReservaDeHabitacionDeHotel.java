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
        //Estas variables sirven para almacenar la habitacion seleccionada y las fechas reservadas
        int habitacionSeleccionada = -1;
        String fechaInicio = "";
        String fechaFin = "";

        while (true) {
            System.out.println();
            System.out.println("--------BIENVENIDO A THE DIAMOND RESORT---------");
            System.out.println("");
            System.out.println("---------------------MENU----------------------");
            System.out.println("1) Mostrar habitaciones");
            System.out.println("2) Reservar habitacion");
            System.out.println("3) Cancelar reserva");
            System.out.println("4) Ver informacion del usuario");
            System.out.println("5) Actualizar informacion del usuario");
            System.out.println("6) Realizar encuesta de satisfaccion");
            System.out.println("7) Mostrar ofertas especiales");
            System.out.println("8) Salir");
            System.out.print("-> Ingrese el numero de lo que desee hacer: ");
            int opc = lea.nextInt();
            do {
                
            switch (opc) {
                case 1:
                    gestion.mostrarHabitaciones();
                    break;
                case 2:
                    gestion.mostrarHabitaciones();
                    System.out.print("Ingrese el numero de habitación para reservar: ");
                    int reserva = lea.nextInt() - 1;
                    System.out.print("Ingrese el numero de personas: ");
                    int numPersonas = lea.nextInt();
                    lea.nextLine();
                    System.out.print("Ingrese la fecha de llegada: ");
                    fechaInicio = lea.nextLine();
                    System.out.print("Ingrese la fecha de ida: ");
                    fechaFin = lea.nextLine();
                    //Guardamos la informacion de la reserva y actualizamos informacion
                    if (gestion.reservarHabitacion(reserva, numPersonas, fechaInicio, fechaFin)) {
                        usuario.agregarReserva("Habitacion " + reserva + " desde " + fechaInicio + " hasta " + fechaFin);
                        habitacionSeleccionada = reserva;
                    }
                    break;
                case 3:
                    gestion.mostrarHabitaciones();
                    System.out.print("Ingrese el numero de habitacion para cancelar la reserva: ");
                    int cancelar = lea.nextInt() - 1;//restamos 1 para que el indice coincida y que sea exitosa la cancelacion 
                    gestion.cancelarReserva(cancelar);
                    break;
                case 4:
                    System.out.println("Informacion del Usuario:");
                    System.out.println("Nombre: " + usuario.getNombre());
                    System.out.println("ID: " + usuario.getId());
                    System.out.println("Email: " + usuario.getEmail());
                    System.out.println("Telefono: " + usuario.getTelefono());
                    break;
                case 5:
                    System.out.print("Ingrese nuevo nombre: ");
                    usuario.setNombre(lea.nextLine());
                    System.out.print("Ingrese nuevo email: ");
                    usuario.setEmail(lea.nextLine());
                    System.out.print("Ingrese nuevo telefono: ");
                    usuario.setTelefono(lea.nextLine());
                    System.out.println("->Informacion actualizada.");
                    break;
                case 6:
                    EncuestaSatisfaccion();
                    break;
                case 7:
                    mostrarOfertasEspeciales();
                    break;
                case 8:
                    System.out.println("---------VUELVA PRONTO---------");
                    System.out.println();
                    //Condicion para ver si el usuario hizo la reserva 
                    if (habitacionSeleccionada >= 0) {
                        Habitacion habitacion = gestion.getHabitaciones().get(habitacionSeleccionada);
                        System.out.println("--------------------------");
                        System.out.println("\nDetalles de la reserva");
                        System.out.println("Huesped: " + usuario.getNombre());
                        System.out.println("ID: " + usuario.getId());
                        System.out.println("Email: " + usuario.getEmail());
                        System.out.println("Telefono: " + usuario.getTelefono());
                        System.out.println("Tipo de habitacion: " + habitacion.getTipo());
                        System.out.println("Costo: Lps." + habitacion.getPrecio());
                        System.out.println("Capacidad: " + habitacion.getCapacidad() + " personas");
                        System.out.println("Fechas de reserva: " + fechaInicio + " - " + fechaFin);
                    }
                    break;
                default:
                    break;
            }
            }while (opc !=8);
    }
    }//fin del main
    
    //metodos para el case 6 y 7 
    private static void EncuestaSatisfaccion() {
        Scanner lea = new Scanner(System.in);

        System.out.println("Gracias por su reserva!");
        System.out.println("-------------------------");
        System.out.println("ENCUESTA DE SATISFACCION ");
        System.out.print("Como calificaria la facilidad de uso del sistema? (1-5): ");
        int facilidadUso = lea.nextInt();

        System.out.print("Como calificaria la rapidez en el proceso de reserva? (1-5): ");
        int rapidezReserva = lea.nextInt();


        System.out.print("Recomendaria nuestro servicio a otros? (Si/No): ");
        String recomendar = lea.nextLine();

        System.out.println("\nGracias por su feedback. Sus respuestas han sido registradas:");
        System.out.println("Facilidad de uso del sistema: " + facilidadUso);
        System.out.println("Rapidez en el proceso de reserva: " + rapidezReserva);
        System.out.println("Recomendaria el servicio: " + recomendar);
    }

    private static void mostrarOfertasEspeciales() {
        System.out.println("Ofertas Especiales del Dia:");
        System.out.println("1. 20% de descuento en habitaciones dobles durante el fin de semana.");
        System.out.println("2. Reserva 3 noches y obtén la cuarta noche gratis.");
        System.out.println("3. Descuento del 15% en reservas realizadas con al menos 30 días de anticipación.");

        System.out.println("\nAproveche nuestras ofertas y ahorre en su próxima reserva!");
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reserva.de.habitacion.de.hotel;

import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class Usuario {
    //atributos
    private String nombre;
    private int id;
    private String email;
    private String telefono;
    //constructor
    public Usuario(String nombre, int id, String email, String telefono) {
        this.nombre = nombre;
        this.id = id;
        this.email = email;
        this.telefono = telefono;
    }
    //getters 
    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }
    //setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    //metodo para que el usuario ingrese los datos desde consola 
    public static Usuario ingresarDatos() {
        Scanner lea = new Scanner(System.in);
        System.out.print("Ingrese su nombre: ");
        String nombre = lea.nextLine();
        System.out.print("Ingrese ID: ");
        int id = lea.nextInt();
        lea.nextLine();
        System.out.print("Ingrese email personal: ");
        String email = lea.nextLine();
        System.out.print("Ingrese numero de telefono: ");
        String telefono = lea.nextLine();
        return new Usuario(nombre, id, email, telefono);
    }
    public void agregarReserva(String detalles) {
        System.out.println("Reserva agregada para " + nombre + ": " + detalles);
    }
}

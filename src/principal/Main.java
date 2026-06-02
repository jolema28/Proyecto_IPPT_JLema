package principal;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static Usuario administrador = null;

    public static void main(String[] args) {

        int opcion = 0;

        while (opcion != 3) {

            System.out.println("===== MENU =====");
            System.out.println("1 - Registro de administrador");
            System.out.println("2 - Login");
            System.out.println("3 - Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scan.nextInt();
            scan.nextLine();

            if (opcion == 1) {
                registrarAdministrador();
            } else if (opcion == 2) {
                login();
            } else if (opcion == 3) {
                System.out.println("Saliendo del sistema...");
            } else {
                System.out.println("Opcion invalida.");
            }

            System.out.println();
        }
    }

    public static void registrarAdministrador() {

        if (administrador != null) {
            System.out.println("Ya existe un administrador registrado.");
        } else {
            System.out.println("===== REGISTRO DE ADMINISTRADOR =====");

            System.out.print("Ingrese nombre: ");
            String nombre = scan.nextLine();

            System.out.print("Ingrese email: ");
            String email = scan.nextLine();

            System.out.print("Ingrese contrasena: ");
            String contrasena = scan.nextLine();

            System.out.print("Ingrese edad: ");
            int edad = scan.nextInt();
            scan.nextLine();

            if (nombre.isEmpty() || email.isEmpty() || contrasena.isEmpty()) {
                System.out.println("Error: los campos no pueden estar vacios.");
            } else if (edad < 18) {
                System.out.println("Error: el administrador debe ser mayor de edad.");
            } else {
                administrador = new Usuario(nombre, email, contrasena, edad);
                System.out.println("Administrador registrado correctamente.");
            }
        }
    }

    public static void login() {

        if (administrador == null) {
            System.out.println("Primero debe registrar un administrador.");
        } else {
            System.out.println("===== LOGIN =====");

            System.out.print("Ingrese email: ");
            String email = scan.nextLine();

            System.out.print("Ingrese contrasena: ");
            String contrasena = scan.nextLine();

            if (validarCredenciales(email, contrasena)) {
                System.out.println("Login exitoso.");
                System.out.println("Bienvenido/a " + administrador.nombre);
            } else {
                System.out.println("Email o contrasena incorrectos.");
            }
        }
    }

    public static boolean validarCredenciales(String email, String contrasena) {

        if (administrador.email.equals(email)
                && administrador.contrasena.equals(contrasena)
                && administrador.activo) {
            return true;
        } else {
            return false;
        }
    }
}
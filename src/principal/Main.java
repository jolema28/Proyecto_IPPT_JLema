package principal;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        SistemaUsuarios sistema = new SistemaUsuarios();

        int opcion = 0;

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrar administrador");
            System.out.println("3. Reiniciar contrasena");
            System.out.println("4. Listar usuarios");
            System.out.println("5. Buscar usuario");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1) {
                System.out.print("Email: ");
                String email = teclado.nextLine();

                System.out.print("Contrasena: ");
                String contrasena = teclado.nextLine();

                Usuario usuarioLogueado = sistema.login(email, contrasena);

                if (usuarioLogueado != null) {
                    System.out.println("Inicio de sesion correcto.");
                    System.out.println("Bienvenido/a " + usuarioLogueado.getNombre());
                    usuarioLogueado.mostrarMensajeBienvenida();
                    menuUsuario(teclado, sistema, usuarioLogueado);
                } else {
                    System.out.println("Credenciales incorrectas.");
                }

            } else if (opcion == 2) {
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();

                System.out.print("Apellido: ");
                String apellido = teclado.nextLine();

                System.out.print("Email: ");
                String email = teclado.nextLine();

                System.out.print("Contrasena: ");
                String contrasena = teclado.nextLine();

                System.out.print("Pais: ");
                String pais = teclado.nextLine();

                Admin admin = new Admin(nombre, apellido, email, contrasena, pais);
                sistema.registrarUsuario(admin);

            } else if (opcion == 3) {
                System.out.print("Email: ");
                String email = teclado.nextLine();

                System.out.print("Nueva contrasena: ");
                String nuevaContrasena = teclado.nextLine();

                boolean resultado = sistema.reiniciarContrasena(email, nuevaContrasena);

                if (resultado) {
                    System.out.println("Contrasena actualizada correctamente.");
                } else {
                    System.out.println("No se encontro un usuario con ese email.");
                }

            } else if (opcion == 4) {
                sistema.listarUsuarios();

            } else if (opcion == 5) {
                buscarUsuarioPorEmail(teclado, sistema);

            } else if (opcion == 6) {
                System.out.println("Saliendo del sistema...");

            } else {
                System.out.println("Opcion invalida.");
            }

            System.out.println();

        } while (opcion != 6);

        teclado.close();
    }

    public static void menuUsuario(Scanner teclado, SistemaUsuarios sistema, Usuario usuarioLogueado) {

        int opcion = 0;

        do {
            System.out.println("===== MENU DE USUARIO =====");
            System.out.println("1. Crear tester");
            System.out.println("2. Listar usuarios");
            System.out.println("3. Buscar usuario");
            System.out.println("4. Ver mi perfil");
            System.out.println("5. Cerrar sesion");
            System.out.print("Ingrese una opcion: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            if (opcion == 1) {
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();

                System.out.print("Apellido: ");
                String apellido = teclado.nextLine();

                System.out.print("Email: ");
                String email = teclado.nextLine();

                System.out.print("Pais: ");
                String pais = teclado.nextLine();

                System.out.println("Seleccione nivel:");
                System.out.println("1. Junior");
                System.out.println("2. Senior");
                System.out.println("3. Lider");
                System.out.print("Opcion: ");

                int opcionNivel = teclado.nextInt();
                teclado.nextLine();

                String nivel = "Junior";

                if (opcionNivel == 2) {
                    nivel = "Senior";
                } else if (opcionNivel == 3) {
                    nivel = "Lider";
                }

                Tester tester = new Tester(nombre, apellido, email, "1234", pais, nivel);
                sistema.registrarUsuario(tester);

            } else if (opcion == 2) {
                sistema.listarUsuarios();

            } else if (opcion == 3) {
                buscarUsuarioPorEmail(teclado, sistema);

            } else if (opcion == 4) {
                usuarioLogueado.mostrarDatos();

            } else if (opcion == 5) {
                System.out.println("Sesion cerrada.");

            } else {
                System.out.println("Opcion invalida.");
            }

            System.out.println();

        } while (opcion != 5);
    }

    public static void buscarUsuarioPorEmail(Scanner teclado, SistemaUsuarios sistema) {
        System.out.print("Ingrese email a buscar: ");
        String email = teclado.nextLine();

        Usuario usuarioEncontrado = sistema.buscarUsuario(email);

        if (usuarioEncontrado != null) {
            System.out.println("Usuario encontrado:");
            usuarioEncontrado.mostrarDatos();
        } else {
            System.out.println("No se encontro un usuario con ese email.");
        }
    }
}

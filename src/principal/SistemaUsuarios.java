package principal;

import java.util.ArrayList;

public class SistemaUsuarios {

    private ArrayList<Usuario> usuarios;

    public SistemaUsuarios() {
        usuarios = new ArrayList<Usuario>();
        cargarUsuariosPrueba();
    }

    public void cargarUsuariosPrueba() {
        usuarios.add(new Admin("Juan", "Lema", "admin@mail.com", "1234", "Uruguay"));
        usuarios.add(new Tester("Ana", "Perez", "tester@mail.com", "1234", "Uruguay", "Junior"));
    }

    public boolean existeUsuario(String email) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public boolean registrarUsuario(Usuario usuario) {
        if (existeUsuario(usuario.getEmail())) {
            System.out.println("Ya existe un usuario con ese email.");
            return false;
        }

        usuarios.add(usuario);
        System.out.println("Usuario registrado correctamente.");
        return true;
    }

    public Usuario validarCredenciales(String email, String contrasena) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getEmail().equals(email)
                    && usuario.validarContrasena(contrasena)
                    && usuario.getActivo()) {
                return usuario;
            }
        }

        return null;
    }

    public Usuario login(String email, String contrasena) {
        return validarCredenciales(email, contrasena);
    }

    public boolean reiniciarContrasena(String email, String nuevaContrasena) {
        Usuario usuario = buscarUsuario(email);

        if (usuario != null) {
            usuario.setContrasena(nuevaContrasena);
            return true;
        }

        return false;
    }

    public Usuario buscarUsuario(String email) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(email)) {
                return usuarios.get(i);
            }
        }

        return null;
    }

    public void listarUsuarios() {
        if (usuarios.size() == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            for (int i = 0; i < usuarios.size(); i++) {
                System.out.println("-------------------------");
                usuarios.get(i).mostrarDatos();
            }
        }
    }
}

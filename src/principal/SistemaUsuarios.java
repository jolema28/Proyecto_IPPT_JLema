package principal;

import java.util.ArrayList;
import principal.excepciones.DatosInvalidosException;
import principal.excepciones.EmailDuplicadoException;
import principal.excepciones.UsuarioNoEncontradoException;

public class SistemaUsuarios {

    private static SistemaUsuarios instancia;
    private final ArrayList<Usuario> usuarios;

    private SistemaUsuarios() {
        usuarios = new ArrayList<Usuario>();
        cargarUsuariosPrueba();
    }

    public static SistemaUsuarios getInstancia() {
        if (instancia == null) {
            instancia = new SistemaUsuarios();
        }

        return instancia;
    }

    public void cargarUsuariosPrueba() {
        usuarios.add(new Admin("Juan", "Lema", "admin@mail.com", "admin123", "Uruguay"));
        usuarios.add(new Tester("Ana", "Perez", "tester@mail.com", "tester123", "Uruguay", "Junior"));
    }

    public boolean existeUsuario(String email) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        return false;
    }

    public void registrarUsuario(Usuario usuario)
            throws EmailDuplicadoException, DatosInvalidosException {
        ValidadorDatos.validarUsuario(usuario);

        if (existeUsuario(usuario.getEmail())) {
            throw new EmailDuplicadoException("Ya existe un usuario con el email ingresado.");
        }

        usuarios.add(usuario);
    }

    public Usuario validarCredenciales(String email, String contrasena) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);

            if (usuario.getEmail().equalsIgnoreCase(email)
                    && usuario.validarContrasena(contrasena)
                    && usuario.getActivo()) {
                return usuario;
            }
        }

        return null;
    }

    public Usuario login(String email, String contrasena)
            throws DatosInvalidosException, UsuarioNoEncontradoException {
        ValidadorDatos.validarEmail(email);
        ValidadorDatos.validarCampoObligatorio(contrasena, "contrasena");

        Usuario usuario = buscarUsuario(email);

        if (!usuario.validarContrasena(contrasena) || !usuario.getActivo()) {
            throw new DatosInvalidosException("Las credenciales ingresadas son incorrectas.");
        }

        return usuario;
    }

    public void reiniciarContrasena(String email, String nuevaContrasena)
            throws DatosInvalidosException, UsuarioNoEncontradoException {
        ValidadorDatos.validarEmail(email);
        ValidadorDatos.validarContrasena(nuevaContrasena);
        Usuario usuario = buscarUsuario(email);
        usuario.setContrasena(nuevaContrasena);
    }

    public Usuario buscarUsuario(String email)
            throws DatosInvalidosException, UsuarioNoEncontradoException {
        ValidadorDatos.validarEmail(email);

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equalsIgnoreCase(email)) {
                return usuarios.get(i);
            }
        }

        throw new UsuarioNoEncontradoException("No se encontro un usuario con ese email.");
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

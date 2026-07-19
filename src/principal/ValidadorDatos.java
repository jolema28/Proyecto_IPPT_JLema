package principal;

import principal.excepciones.DatosInvalidosException;

public class ValidadorDatos {

    public static final int LONGITUD_MINIMA_CONTRASENA = 6;

    private ValidadorDatos() {
    }

    public static void validarUsuario(Usuario usuario) throws DatosInvalidosException {
        validarCampoObligatorio(usuario.getNombre(), "nombre");
        validarCampoObligatorio(usuario.getApellido(), "apellido");
        validarEmail(usuario.getEmail());
        validarContrasena(usuario.getContrasena());
        validarCampoObligatorio(usuario.getPais(), "pais");

        if (usuario instanceof Tester) {
            Tester tester = (Tester) usuario;
            validarCampoObligatorio(tester.getNivel(), "nivel");
        }
    }

    public static void validarCampoObligatorio(String valor, String nombreCampo)
            throws DatosInvalidosException {
        if (valor == null || valor.trim().isEmpty()) {
            throw new DatosInvalidosException("El campo " + nombreCampo + " es obligatorio.");
        }
    }

    public static void validarEmail(String email) throws DatosInvalidosException {
        validarCampoObligatorio(email, "email");

        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new DatosInvalidosException("El email ingresado no tiene un formato valido.");
        }
    }

    public static void validarContrasena(String contrasena) throws DatosInvalidosException {
        validarCampoObligatorio(contrasena, "contrasena");

        if (contrasena.length() < LONGITUD_MINIMA_CONTRASENA) {
            throw new DatosInvalidosException(
                    "La contrasena debe tener al menos " + LONGITUD_MINIMA_CONTRASENA + " caracteres.");
        }
    }
}

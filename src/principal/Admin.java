package principal;

public class Admin extends Usuario {

    public Admin(String nombre, String apellido, String email, String contrasena, String pais) {
        super(nombre, apellido, email, contrasena, pais);
    }

    @Override
    public String getPerfil() {
        return "Administrador";
    }

    @Override
    public void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido administrador. Tiene permisos para gestionar usuarios.");
    }
}

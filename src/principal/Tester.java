package principal;

public class Tester extends Usuario {

    private String nivel;

    public Tester(String nombre, String apellido, String email, String contrasena, String pais, String nivel) {
        super(nombre, apellido, email, contrasena, pais);
        this.nivel = nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String getPerfil() {
        return "Tester " + nivel;
    }

    @Override
    public void mostrarMensajeBienvenida() {
        System.out.println("Bienvenido tester. Puede consultar y probar funcionalidades del sistema.");
    }
}

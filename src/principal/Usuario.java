package principal;

public abstract class Usuario {

    private String nombre;
    private String apellido;
    private String email;
    private String contrasena;
    private String pais;
    private boolean activo;

    public Usuario(String nombre, String apellido, String email, String contrasena, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contrasena = contrasena;
        this.pais = pais;
        this.activo = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean validarContrasena(String contrasenaIngresada) {
        return contrasena.equals(contrasenaIngresada);
    }

    public abstract String getPerfil();

    public abstract void mostrarMensajeBienvenida();

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Email: " + email);
        System.out.println("Pais: " + pais);
        System.out.println("Perfil: " + getPerfil());
        System.out.println("Activo: " + activo);
    }
}

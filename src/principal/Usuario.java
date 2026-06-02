package principal;

public class Usuario {

        public String nombre;
        public String email;
        public String contrasena;
        public int edad;
        public boolean activo;

        public Usuario(String nombre, String email, String contrasena, int edad) {
                this.nombre = nombre;
                this.email = email;
                this.contrasena = contrasena;
                this.edad = edad;
                this.activo = true;
        }
}
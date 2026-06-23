## Funcionalidades

### Autenticación de administrador

- Inicio de sesión de administrador.
    - Campos: correo electrónico y contraseña.

- Recuperación de contraseña desde el inicio de sesión.
    - Redirección a la pantalla **“Reiniciar contraseña”**.

- Creación de cuenta de administrador desde el inicio de sesión.
    - Redirección a la pantalla **“Registrarse”**.

- Cierre de sesión de administrador.
    - Redirección al home de administrador.

### Registro de administrador

- Registro de nueva cuenta de administrador.
    - Campos: nombre, apellido, correo electrónico, contraseña, repetir contraseña y país de nacimiento.

- Acceso a recuperación de contraseña desde el registro.
    - Redirección a la pantalla **“Reiniciar contraseña”**.

- Finalización de registro.
    - Redirección al home.

- Acceso a inicio de sesión desde el registro.
    - Opción **“Ya tengo cuenta”**.

### Recuperación de contraseña

- Reinicio de contraseña para cuenta de administrador.
    - Campos: correo electrónico, nueva contraseña y repetir contraseña.

- Confirmación de reinicio de contraseña.
    - Redirección al home.

- Acceso a registro desde la recuperación de contraseña.
    - Opción **“Crear cuenta”**.

- Acceso a inicio de sesión desde la recuperación de contraseña.
    - Opción **“Ya tengo cuenta”**.

### Navegación y menú

- Menú hamburguesa lateral con acceso a:
    - Iniciar sesión.
    - Registrarse.
    - Reiniciar contraseña.

- Despliegue y colapso del menú hamburguesa lateral.

- Menú acordeón en el home de administrador para mostrar opciones de autenticación cuando el usuario no está logueado.

## Funcionalidades posteriores al login

### Menú lateral

- Menú hamburguesa lateral con acceso a:
    - Crear usuario.
    - Reiniciar contraseña de usuario.
    - Ver usuarios.

- Despliegue y contracción del menú lateral.

### Crear usuario

- Alta de cuenta para testers.
    - Campos: nombre, apellido, email, país de nacimiento y contraseña por defecto.
    - Selección de perfil mediante opción única:
        - Tester junior.
        - Tester senior.
        - Tester líder.

### Reiniciar contraseña de usuario

- Reinicio de contraseña de usuario.
    - Campos: email, nueva contraseña y repetir contraseña.

### Ver usuarios

- Visualización de usuarios en una tabla con las siguientes columnas:
    - Apellido.
    - Email.
    - País.
    - Perfil.
    - Acción.

- Eliminación de usuarios no administradores desde la columna **“Acción”**.

### Perfil de administrador

- Acceso al perfil desde el menú ubicado en la parte superior derecha.

- Despliegue de un acordeón con las opciones:
    - Ir al perfil.
    - Cerrar sesión.

- Visualización y edición de datos del perfil.
    - Campos editables: nombre, apellido, email y país.
    - Campo no editable: perfil.

- Confirmación de cambios mediante botón **“Confirmar cambios”**.

## VC4 - Mejora del diseño y colecciones

En esta etapa se mejora la solución anterior aplicando colecciones, abstracción y polimorfismo.

Cambios realizados:

- Se reemplazó el arreglo de usuarios por una colección ArrayList.
- La clase Usuario ahora es abstracta.
- Admin y Tester heredan de Usuario.
- Se agregaron métodos abstractos para representar comportamientos comunes.
- Cada tipo de usuario implementa su propio mensaje de bienvenida.
- Se agregó búsqueda de usuario por email.
- Se agregó listado de todos los usuarios.
- Se amplió el menú principal.

## Diagrama de clases UML

```mermaid
classDiagram
    class Usuario {
        <<abstract>>
        -String nombre
        -String apellido
        -String email
        -String contrasena
        -String pais
        -boolean activo
        +Usuario(String nombre, String apellido, String email, String contrasena, String pais)
        +getNombre() String
        +setNombre(String nombre) void
        +getApellido() String
        +setApellido(String apellido) void
        +getEmail() String
        +setEmail(String email) void
        +getContrasena() String
        +setContrasena(String contrasena) void
        +getPais() String
        +setPais(String pais) void
        +getActivo() boolean
        +setActivo(boolean activo) void
        +validarContrasena(String contrasenaIngresada) boolean
        +getPerfil() String
        +mostrarMensajeBienvenida() void
        +mostrarDatos() void
    }

    class Admin {
        +Admin(String nombre, String apellido, String email, String contrasena, String pais)
        +getPerfil() String
        +mostrarMensajeBienvenida() void
    }

    class Tester {
        -String nivel
        +Tester(String nombre, String apellido, String email, String contrasena, String pais, String nivel)
        +getNivel() String
        +setNivel(String nivel) void
        +getPerfil() String
        +mostrarMensajeBienvenida() void
    }

    class SistemaUsuarios {
        -ArrayList~Usuario~ usuarios
        +SistemaUsuarios()
        +cargarUsuariosPrueba() void
        +existeUsuario(String email) boolean
        +registrarUsuario(Usuario usuario) boolean
        +validarCredenciales(String email, String contrasena) Usuario
        +login(String email, String contrasena) Usuario
        +reiniciarContrasena(String email, String nuevaContrasena) boolean
        +buscarUsuario(String email) Usuario
        +listarUsuarios() void
    }

    Usuario <|-- Admin
    Usuario <|-- Tester
    SistemaUsuarios --> Usuario
```

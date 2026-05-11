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

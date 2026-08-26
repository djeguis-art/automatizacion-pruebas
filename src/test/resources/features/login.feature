# language: es

Característica: Inicio de sesión
  Como usuario del sistema
  Quiero validar mis credenciales
  Para acceder solamente cuando sean correctas

  Escenario: Inicio de sesión con credenciales válidas
    Dado que el servicio de autenticación está disponible
    Cuando ingreso el usuario "admin" y la contraseña "1234"
    Entonces el acceso debe ser permitido

  Esquema del escenario: Rechazar credenciales inválidas
    Dado que el servicio de autenticación está disponible
    Cuando ingreso el usuario "<usuario>" y la contraseña "<contrasena>"
    Entonces el acceso debe ser rechazado

    Ejemplos:
      | usuario | contrasena |
      | admin   | incorrecta |
      | usuario | 1234       |
      | prueba  | prueba123  |
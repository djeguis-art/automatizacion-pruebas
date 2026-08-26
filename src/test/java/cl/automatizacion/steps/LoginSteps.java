package cl.automatizacion.steps;

import cl.automatizacion.service.LoginService;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {

    private LoginService loginService;
    private boolean accesoPermitido;

    @Dado("que el servicio de autenticación está disponible")
    public void servicioAutenticacionDisponible() {
        loginService = new LoginService();
    }

    @Cuando("ingreso el usuario {string} y la contraseña {string}")
    public void ingresoCredenciales(String usuario, String contrasena) {
        accesoPermitido = loginService.autenticar(usuario, contrasena);
    }

    @Entonces("el acceso debe ser permitido")
    public void accesoPermitido() {
        assertTrue(accesoPermitido);
    }

    @Entonces("el acceso debe ser rechazado")
    public void accesoRechazado() {
        assertFalse(accesoPermitido);
    }
}
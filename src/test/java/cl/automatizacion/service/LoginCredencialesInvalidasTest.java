package cl.automatizacion.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LoginCredencialesInvalidasTest {

    @Test
    void deberiaRechazarAccesoConCredencialesInvalidas() {

        LoginService loginService = new LoginService();

        boolean resultado = loginService.autenticar("admin", "incorrecta");

        assertFalse(resultado);
    }
}
package cl.automatizacion.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LoginExitosoTest {

    @Test
    void deberiaPermitirAccesoConCredencialesValidas() {

        LoginService loginService = new LoginService();

        boolean resultado = loginService.autenticar("admin", "1234");

        assertTrue(resultado);
    }
}
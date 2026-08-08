package cl.automatizacion.service;

public class LoginService {

    private static final String USUARIO_VALIDO = "admin";
    private static final String PASSWORD_VALIDA = "1234";

    public boolean autenticar(String usuario, String password) {

        if (usuario == null || password == null) {
            return false;
        }

        return USUARIO_VALIDO.equals(usuario)
                && PASSWORD_VALIDA.equals(password);
    }
}
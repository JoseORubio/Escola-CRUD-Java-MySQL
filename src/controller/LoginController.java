package controller;

/**
 *
 * @author José Orlando
 */

import model.LoginModel;
import DAO.LoginDAO;
import java.util.List;

public class LoginController {
    
    LoginDAO loginDAO = new LoginDAO();
    
    public LoginModel validarUsuarioController(LoginModel usuario){
        return loginDAO.validarUsuario(usuario);
    }
    
    public List<String> listaLoginsController(){
        return loginDAO.listaLogins();
    }
    
    public boolean testaConexao() {
        return loginDAO.testaConexao();
    }
}

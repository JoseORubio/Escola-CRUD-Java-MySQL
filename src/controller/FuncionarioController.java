package controller;

import model.FuncionarioModel;
import DAO.FuncionarioDAO;
import java.util.List;

/**
 *
 * @author José Orlando
 */
public class FuncionarioController {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    
    public List<FuncionarioModel> getListaFuncionariosController(){
        return funcionarioDAO.getListaFuncionariosDAO();
    }
    
    public boolean excluirFuncionarioController(int id){
        return funcionarioDAO.excluirFuncionarioDAO(id);
    }
    
    public String salvarFuncionarioController(FuncionarioModel funcionarioModel) {
        return funcionarioDAO.salvarFuncionarioDAO(funcionarioModel);
    }
    
    public String atualizarFuncionarioController(FuncionarioModel funcionarioModel) {
        return funcionarioDAO.atualizarFuncionarioDAO(funcionarioModel);
    }
}

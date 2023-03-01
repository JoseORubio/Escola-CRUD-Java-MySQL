package controller;

import model.AlunoModel;
import DAO.AlunoDAO;
import java.util.List;
/**
 *
 * @author José Orlando
 */
public class AlunoController {
    AlunoDAO alunoDAO = new AlunoDAO();

    public List<AlunoModel> getListaAlunosController(){
        return alunoDAO.getListaAlunosDAO();
    }
    
    public boolean excluirAlunoController(int id){
        return alunoDAO.excluirAlunoDAO(id);
    }
    
    public String salvarAlunoController(AlunoModel alunoModel){
        return alunoDAO.salvarAlunoDAO(alunoModel);
    }
    
    public String atualizarAlunoController(AlunoModel alunoModel) {
        return alunoDAO.atualizarAlunoDAO(alunoModel);
    }
    
}

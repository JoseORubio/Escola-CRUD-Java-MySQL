package controller;

import model.DisciplinaModel;
import DAO.Disciplina_AreaConhecimentoDAO;
import java.util.List;
import model.AreaConhecimentoModel;


/**
 *
 * @author José Orlando
 */
public class Disciplina_AreaConhecimentoController {
    
    Disciplina_AreaConhecimentoDAO disciplinaDAO = new Disciplina_AreaConhecimentoDAO();
    
    public List<DisciplinaModel> getListaDisciplinasController(String where){
        return disciplinaDAO.getListaDisciplinasDAO(where);
    }
    
    
    public List<AreaConhecimentoModel> getListaAreaConhecimentosController(){
        
        return disciplinaDAO.getListaAreaConhecimentosDAO();
        
    }
    
    public boolean excluirDisciplinaController(int id){
        
        return disciplinaDAO.excluirDisciplinaDAO(id);
    }
    
    public boolean salvarDisciplinaController(DisciplinaModel disciplinaModel) {
        return disciplinaDAO.salvarDisciplinaDAO(disciplinaModel);
    }
    
    public boolean atualizarDisciplinaController(DisciplinaModel disciplinaModel) {
        return disciplinaDAO.atualizarDisciplinaDAO(disciplinaModel);
    }
    
}

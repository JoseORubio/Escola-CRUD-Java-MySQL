package controller;

import model.AvaliacaoModel;
import DAO.AvaliacaoDAO;
import java.util.List;

/**
 *
 * @author José Orlando
 */
public class AvaliacaoController {
    
    AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();

    public List<AvaliacaoModel> getListaAvaliacoesController(String where){
        return avaliacaoDAO.getListaAvaliacoesDAO(where);
    }
    
    public boolean excluirAvaliacaoController(int id_professor, int id_aluno){
        return avaliacaoDAO.excluirAvaliacaoDAO( id_professor,  id_aluno);
    }
    
    public String salvarAvaliacaoController(AvaliacaoModel avaliacaoModel){
        return avaliacaoDAO.salvarAvaliacaoDAO(avaliacaoModel);
    }
    
    public boolean atualizarAvaliacaoController(AvaliacaoModel avaliacaoModel) {
        return avaliacaoDAO.atualizarAvaliacaoDAO(avaliacaoModel);
    }
    
    
}

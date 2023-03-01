package controller;

import model.ClasseModel;
import DAO.ClasseDAO;
import java.util.List;

/**
 *
 * @author José Orlando
 */
public class ClasseController {

    ClasseDAO classeDAO = new ClasseDAO();

    public boolean salvarClasseController(ClasseModel classeModel) {
        return classeDAO.salvarClasseDAO(classeModel);
    }
      
    public List<ClasseModel> getListaClassesController(){
        return classeDAO.getListaClassesDAO();
    }
    
    public boolean excluirClasseController(int id){
        return classeDAO.excluirClasseDAO(id);
    }

}

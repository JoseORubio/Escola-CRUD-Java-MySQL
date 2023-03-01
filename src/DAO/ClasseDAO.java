package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConexaoBD;
import model.ClasseModel;

/**
 *
 * @author José Orlando
 */
public class ClasseDAO extends ConexaoBD {

    public boolean salvarClasseDAO(ClasseModel classeModel) {

        conectar();
        String sql = "insert into classe (ano, turma) values (?,?)";
        PreparedStatement pstm = criarPreparedStatement(sql);

        try {
            pstm.setInt(1, classeModel.getAno());
            pstm.setString(2, String.valueOf(classeModel.getTurma()));
            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            desconectar();
            
        }
    }

    public boolean excluirClasseDAO(int id) {
        conectar();
        String sql = "delete from classe where id = '" + id + "'";
        PreparedStatement pstm = criarPreparedStatement(sql);
        
        try {
            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            desconectar();
            
        }
    }

    public void atualizarClasse() {

    }

    public List<ClasseModel> getListaClassesDAO() {
        List<ClasseModel> listaClasse = new ArrayList<>();
        ClasseModel classeModel = new ClasseModel();

        conectar();
        PreparedStatement pstm;
        ResultSet rset;
        String sql = "select * from classe order by ano, turma";
        String turma;

        try {
            pstm = criarPreparedStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                classeModel = new ClasseModel();

                classeModel.setId(rset.getInt("id"));
                classeModel.setAno(rset.getInt("ano"));
                turma = rset.getString("turma");
                classeModel.setTurma(turma.charAt(0));

                listaClasse.add(classeModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        desconectar();
        return listaClasse;
    }
}

package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AreaConhecimentoModel;
import util.ConexaoBD;
import model.DisciplinaModel;

/**
 *
 * @author José Orlando
 */
public class Disciplina_AreaConhecimentoDAO extends ConexaoBD {

    public List<DisciplinaModel> getListaDisciplinasDAO(String where ) {
        List<DisciplinaModel> listaDisciplina = new ArrayList<>();
        DisciplinaModel disciplinaModel = new DisciplinaModel();

        conectar();
        PreparedStatement pstm;
        ResultSet rset;
        String sql = "select d.id , d.nome, a.nome  from disciplina d "
                + "join area_conhecimento a on d.id_area_conhecimento = a.id  "
                + where
                +" order by a.nome, d.nome";

        try {
            pstm = criarPreparedStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                disciplinaModel = new DisciplinaModel();

                disciplinaModel.setId(rset.getInt("d.id"));
                disciplinaModel.setNome(rset.getString("d.nome"));
                disciplinaModel.setNomeAreaConhecimento(rset.getString("a.nome"));

                listaDisciplina.add(disciplinaModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        desconectar();
        return listaDisciplina;
    }

    public List<AreaConhecimentoModel> getListaAreaConhecimentosDAO() {
        List<AreaConhecimentoModel> listaAreaConhecimento = new ArrayList<>();
        AreaConhecimentoModel areaConhecimentoModel = new AreaConhecimentoModel();

        conectar();
        PreparedStatement pstm;
        ResultSet rset;
        String sql = "select * from area_conhecimento";

        try {
            pstm = criarPreparedStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                areaConhecimentoModel = new AreaConhecimentoModel();

                areaConhecimentoModel.setId(rset.getInt("id"));
                areaConhecimentoModel.setNome(rset.getString("nome"));

                listaAreaConhecimento.add(areaConhecimentoModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        desconectar();
        return listaAreaConhecimento;
    }

    public boolean excluirDisciplinaDAO(int id) {
        conectar();
        String sql = "delete from disciplina where id = '" + id + "'";
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

    public boolean salvarDisciplinaDAO(DisciplinaModel disciplinaModel) {

        conectar();
        String sql = "insert into disciplina (nome, id_area_conhecimento) values (?,?)";
        PreparedStatement pstm = criarPreparedStatement(sql);

        try {
            pstm.setString(1, disciplinaModel.getNome());
            pstm.setInt(2, (disciplinaModel.getIdAreaConhecimento()));
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

    public boolean atualizarDisciplinaDAO(DisciplinaModel disciplinaModel) {
        conectar();
        String sql = "update disciplina set"
                + " nome = ?, id_area_conhecimento = ? where id = '" + disciplinaModel.getId() + "'";
        PreparedStatement pstm = criarPreparedStatement(sql);
        try {
            pstm.setString(1, disciplinaModel.getNome());
            pstm.setInt(2, disciplinaModel.getIdAreaConhecimento());
            pstm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Disciplina_AreaConhecimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
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

}

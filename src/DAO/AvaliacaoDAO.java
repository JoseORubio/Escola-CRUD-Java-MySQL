package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import util.ConexaoBD;
import model.AvaliacaoModel;

/**
 *
 * @author José Orlando
 */
public class AvaliacaoDAO extends ConexaoBD {

    public List<AvaliacaoModel> getListaAvaliacoesDAO(String where) {

        List<AvaliacaoModel> listaAvaliacao = new ArrayList<>();
        AvaliacaoModel AvaliacaoModel = new AvaliacaoModel();

        conectar();
        PreparedStatement pstm;
        ResultSet rset;
        String sql = "select f.nome, f.id, d.nome, a.nome, a.id, c.ano, c.turma,"
                + " l.nota_1bi , l.nota_2bi, l.nota_3bi, l.nota_4bi from leciona l "
                + "join funcionario f on l.id_professor = f.id "
                + "join disciplina d on f.leciona = d.id "
                + "join aluno a on l.id_aluno = a.id "
                + "join classe c on a.id_classe = c.id "
                + where 
                + " order by f.nome, a.nome";
        try {
            pstm = criarPreparedStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                AvaliacaoModel = new AvaliacaoModel();

                AvaliacaoModel.setNomeProfessor(rset.getString("f.nome"));
                AvaliacaoModel.setIdProfessor(rset.getInt("f.id"));
                AvaliacaoModel.setDisciplina(rset.getString("d.nome"));
                AvaliacaoModel.setNomeAluno(rset.getString("a.nome"));
                AvaliacaoModel.setIdAluno(rset.getInt("a.id"));
                AvaliacaoModel.setAno(rset.getInt("c.ano"));
                AvaliacaoModel.setTurma(rset.getString("c.turma"));
                AvaliacaoModel.setBim1(rset.getDouble("l.nota_1bi"));
                AvaliacaoModel.setBim2(rset.getDouble("l.nota_2bi"));
                AvaliacaoModel.setBim3(rset.getDouble("l.nota_3bi"));
                AvaliacaoModel.setBim4(rset.getDouble("l.nota_4bi"));

                listaAvaliacao.add(AvaliacaoModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        desconectar();
        return listaAvaliacao;
    }

    public boolean excluirAvaliacaoDAO(int id_professor, int id_aluno) {
        conectar();
        String sql = "delete from leciona where id_professor = '" + id_professor + "' and id_aluno = '" + id_aluno + "'   ";
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

    public String salvarAvaliacaoDAO(AvaliacaoModel avaliacaoModel) {

        conectar();
        String sql = "insert into leciona (id_professor, id_aluno, nota_1bi, nota_2bi, nota_3bi, nota_4bi) values (?,?,?,?,?,?)";
        PreparedStatement pstm = criarPreparedStatement(sql);

        try {
            pstm.setInt(1, avaliacaoModel.getIdProfessor());
            pstm.setInt(2, avaliacaoModel.getIdAluno());
            pstm.setDouble(3, (avaliacaoModel.getBim1()));
            pstm.setDouble(4, (avaliacaoModel.getBim2()));
            pstm.setDouble(5, (avaliacaoModel.getBim3()));
            pstm.setDouble(6, (avaliacaoModel.getBim4()));
            pstm.executeUpdate();
            return "";
            
            } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return "Aluno com avaliação já cadastrada";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Erro";
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

    public boolean atualizarAvaliacaoDAO(AvaliacaoModel avaliacaoModel) {
        conectar();
        String sql = "update leciona set"
                + " nota_1bi = ?, nota_2bi = ?, nota_3bi = ?, nota_4bi = ?"
                + " where id_professor = '" + avaliacaoModel.getIdProfessor() + "' and id_aluno = '" + avaliacaoModel.getIdAluno() + "'";
        PreparedStatement pstm = criarPreparedStatement(sql);
        try {
            pstm.setDouble(1, avaliacaoModel.getBim1());
            pstm.setDouble(2, avaliacaoModel.getBim2());
            pstm.setDouble(3, avaliacaoModel.getBim3());
            pstm.setDouble(4, avaliacaoModel.getBim4());
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

}

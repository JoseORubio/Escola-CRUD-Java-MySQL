package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import util.ConexaoBD;
import model.AlunoModel;

/**
 *
 * @author José Orlando
 */
public class AlunoDAO extends ConexaoBD {

    public List<AlunoModel> getListaAlunosDAO() {

        List<AlunoModel> listaAluno = new ArrayList<>();
        AlunoModel AlunoModel = new AlunoModel();

        conectar();
        PreparedStatement pstm;
        ResultSet rset;
        String sql = "select a.id, a.nome, c.ano, c.turma, a.login, a.senha "
                + "from aluno a join classe c on a.id_classe = c.id "
                + "order by a.nome;";
        String turma;
        try {
            pstm = criarPreparedStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                AlunoModel = new AlunoModel();

                AlunoModel.setId(rset.getInt("id"));
                AlunoModel.setNome(rset.getString("nome"));
                AlunoModel.setLogin(rset.getString("login"));
                AlunoModel.setSenha(rset.getString("senha"));
                AlunoModel.setAno(rset.getInt("ano"));
                turma = rset.getString("turma");
                AlunoModel.setTurma(turma.charAt(0));

                listaAluno.add(AlunoModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        desconectar();
        return listaAluno;
    }

    public boolean excluirAlunoDAO(int id) {
        conectar();
        String sql = "delete from aluno where id = '" + id + "'";
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

    public String salvarAlunoDAO(AlunoModel alunoModel) {

        conectar();
        String sql = "insert into aluno (nome, login, senha, id_classe) values (?,?,?,?)";
        PreparedStatement pstm = criarPreparedStatement(sql);

        try {
            pstm.setString(1, alunoModel.getNome());
            pstm.setString(2, alunoModel.getLogin());
            pstm.setString(3, (alunoModel.getSenha()));
            pstm.setInt(4, (alunoModel.getClasseId()));
            pstm.executeUpdate();
            return "";
        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return "Nome já utilizado.";

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

    public String atualizarAlunoDAO(AlunoModel alunoModel) {
        conectar();
        String sql = "update aluno set"
                + " nome = ?, login = ?, senha = ?, id_classe = ? where id = '" + alunoModel.getId() + "'";
        PreparedStatement pstm = criarPreparedStatement(sql);
        try {
            pstm.setString(1, alunoModel.getNome());
            pstm.setString(2, alunoModel.getLogin());
            pstm.setString(3, alunoModel.getSenha());
            pstm.setInt(4, alunoModel.getClasseId());
            pstm.executeUpdate();
            return "";

        } catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            return "Nome já utilizado.";
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

}

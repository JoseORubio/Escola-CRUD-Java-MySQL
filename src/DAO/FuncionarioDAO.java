package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import util.ConexaoBD;
import model.FuncionarioModel;

/**
 *
 * @author José Orlando
 */
public class FuncionarioDAO extends ConexaoBD {

    public List<FuncionarioModel> getListaFuncionariosDAO() {
        List<FuncionarioModel> listaFuncionario = new ArrayList<>();
        FuncionarioModel FuncionarioModel;

        conectar();
        PreparedStatement pstm;
        ResultSet rset;
        String sql = "SELECT f.id, f.nome, f.cargo, f.login, f.senha, d.nome as leciona , a.nome as coordena  FROM funcionario f "
                + "left outer join disciplina d  on f.leciona = d.id "
                + "left outer join area_conhecimento a on f.coordena = a.id "
                + "order by f.nome";

        try {
            pstm = criarPreparedStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                FuncionarioModel = new FuncionarioModel();

                FuncionarioModel.setId(rset.getInt("id"));
                FuncionarioModel.setNome(rset.getString("nome"));
                FuncionarioModel.setLogin(rset.getString("login"));
                FuncionarioModel.setSenha(rset.getString("senha"));
                FuncionarioModel.setCargo(rset.getString("cargo"));
                FuncionarioModel.setLeciona(rset.getObject("leciona"));
                FuncionarioModel.setCoordena(rset.getObject("coordena"));

                listaFuncionario.add(FuncionarioModel);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        desconectar();
        return listaFuncionario;
    }

    public boolean excluirFuncionarioDAO(int id) {
        conectar();
        String sql = "delete from funcionario where id = '" + id + "'";
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

    public String salvarFuncionarioDAO(FuncionarioModel funcionarioModel) {

        conectar();
        String sql = "insert into funcionario (nome, cargo, login, senha, leciona, coordena) values (?,?,?,?,?,?)";
        PreparedStatement pstm = criarPreparedStatement(sql);

        try {
            pstm.setString(1, funcionarioModel.getNome());
            pstm.setString(2, funcionarioModel.getCargo());
            pstm.setString(3, funcionarioModel.getLogin());
            pstm.setString(4, (funcionarioModel.getSenha()));
            pstm.setObject(5, (funcionarioModel.getLeciona()));
            pstm.setObject(6, (funcionarioModel.getCoordena()));
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
    
    public String atualizarFuncionarioDAO(FuncionarioModel funcionarioModel) {

        conectar();
        String sql = "update funcionario set"
                + " nome = ?, cargo = ?, login = ?, senha = ?, leciona = ?, coordena = ? where id = '" + funcionarioModel.getId() + "'";
        PreparedStatement pstm = criarPreparedStatement(sql);

        try {
            pstm.setString(1, funcionarioModel.getNome());
            pstm.setString(2, funcionarioModel.getCargo());
            pstm.setString(3, funcionarioModel.getLogin());
            pstm.setString(4, (funcionarioModel.getSenha()));
            pstm.setObject(5, (funcionarioModel.getLeciona()));
            pstm.setObject(6, (funcionarioModel.getCoordena()));
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

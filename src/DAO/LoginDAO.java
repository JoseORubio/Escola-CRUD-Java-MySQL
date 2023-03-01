package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ConexaoBD;
import model.LoginModel;

/**
 *
 * @author José Orlando
 */
public class LoginDAO extends ConexaoBD {

    public LoginModel validarUsuario(LoginModel usuario) {
        conectar();
        String sql = "select f.id, f.nome, f.login, f.senha, f.cargo, "
                + "d.nome as leciona, ac.nome as coordena, null as id_classe from funcionario f "
                + "left outer join disciplina d on f.leciona = d.id "
                + "left outer join area_conhecimento ac on f.coordena = ac.id where "
                + "login = '" + usuario.getLogin() + "' and"
                + " senha = '" + usuario.getSenha() + "' "
                + "union select  a.id, a.nome, a.login, a.senha, null, null, null, a.id_classe from aluno a where "
                + "login = '" + usuario.getLogin() + "' and"
                + " senha = '" + usuario.getSenha() + "' ";
        ResultSet rset = null;
        PreparedStatement pstm = null;
        pstm = criarPreparedStatement(sql);

        try {
            rset = pstm.executeQuery();

            if (rset.next()) {
                usuario.setLogin(null);
                usuario.setSenha(null);
                usuario.setNome(rset.getString("nome"));
                usuario.setId(rset.getInt("id"));
                usuario.setCargo(rset.getString("cargo"));
                if (usuario.getCargo() == null) {
                    usuario.setCargo("Aluno");
                }
                if (usuario.getCargo().equals("Coordenador")) {
                    usuario.setCoordena(rset.getString("coordena"));
                }
                if (usuario.getCargo().equals("Professor")) {
                    usuario.setLeciona(rset.getString("leciona"));
                }
                if (usuario.getCargo().equals("Aluno")) {
                    usuario.setIdClasse(rset.getInt("id_classe"));
                }
                return usuario;
            } else {
                return usuario;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
            return usuario;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (rset != null) {
                    rset.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            desconectar();
        }
    }

    public List<String> listaLogins() {
        conectar();
        List<String> listaLogins = new ArrayList<>();
        String sql = "select f.login from funcionario f "
                + "union select a.login from aluno a";
        ResultSet rset = null;
        PreparedStatement pstm = null;
        pstm = criarPreparedStatement(sql);

        try {
            rset = pstm.executeQuery();

            while (rset.next()) {
                listaLogins.add(rset.getString("login"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaLogins;

    }

    public boolean testaConexao() {
        if (conectar()) {
            desconectar();
            return true;
        } else {
            return false;
        }
    }
}

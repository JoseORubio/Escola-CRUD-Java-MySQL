package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author José Orlando
 */
public class ConexaoBD {

    private Connection connection;

    public boolean conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/escola?"
                    + "user=root&password=123456");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void desconectar() {
        try {
            if (connection.isClosed() == false) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public PreparedStatement criarPreparedStatement(String sql){
        try {
            return connection.prepareStatement(sql);
        } catch (Exception e) {
            return null;
        }
    }
}

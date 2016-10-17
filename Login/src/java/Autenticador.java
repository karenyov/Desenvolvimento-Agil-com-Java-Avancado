
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karen
 */
public class Autenticador {

    static {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Autenticador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String autenticar(String login, String senha) throws Exception {

        try (Connection c = DriverManager.getConnection("jdbc:postgresql://localhost/usuarios", "postgres", "admin")) {

            PreparedStatement ps = c.prepareStatement("select nome from usuario where login = ? and senha = ?;");
            ps.setString(1, login);
            ps.setString(2, senha);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("nome");
            } else {
                throw new Exception("Não foi possível autenticar o usuário!");
            }
        }
    }

}

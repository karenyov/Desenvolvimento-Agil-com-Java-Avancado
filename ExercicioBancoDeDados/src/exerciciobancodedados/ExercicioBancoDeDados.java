/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciobancodedados;

/**
 *
 * @author Karen
 */
public class ExercicioBancoDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuario u = new Usuario();
        u.setLogin("maria");
        u.setEmail("mt@email.com.br");
        u.setNome("Maria Tereza");
        u.setSenha("123");
        u.setPontos(2);

        UsuarioDAO usuarioDAO = new UsuarioImplDAO();
        usuarioDAO.inserir(u);
     
    }
    
}

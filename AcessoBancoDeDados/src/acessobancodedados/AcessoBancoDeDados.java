/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acessobancodedados;

import java.util.List;

/**
 *
 * @author Karen
 */
public class AcessoBancoDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Usuario u = new Usuario();
        u.setLogin("duda");
        u.setNome("Maria Eduarda");
        u.setEmail("duda@gmail.com");
        
        UsuarioDAO.inserirUsuario(u); ;
        List<Usuario> lista = UsuarioDAO.todosUsuarios();
        lista.forEach(System.out::println);
        
    }
    
}

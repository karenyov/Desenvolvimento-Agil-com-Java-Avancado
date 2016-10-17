/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import acessobancodedados.Usuario;
import acessobancodedados.UsuarioDAO;
import java.util.List;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.dbunit.Assertion;

/**
 *
 * @author Karen
 */
public class TesteUsuarioDAO {

    JdbcDatabaseTester jdt;

    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/postgres", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/inicio.xml"));
        jdt.onSetup();
    }

    @Test
    public void recuperaTodos() {
        List<Usuario> lista = UsuarioDAO.todosUsuarios();
        assertEquals(2, lista.size());
        assertEquals("joao", lista.get(0).getLogin());
    }

    @Test
    public void insereNovo() throws Exception {
        Usuario u = new Usuario();
        u.setLogin("duda");
        u.setNome("Maria Eduarda");
        u.setEmail("duda@gmail.com");

        UsuarioDAO.inserirUsuario(u);

        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentITable = currentDataset.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataset = loader.load("/verifica.xml");

        ITable expectedTable = expectedDataset.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentITable);
    }

}

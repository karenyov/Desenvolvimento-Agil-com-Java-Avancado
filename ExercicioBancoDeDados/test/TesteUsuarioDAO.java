/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import exerciciobancodedados.Usuario;
import exerciciobancodedados.UsuarioDAO;
import exerciciobancodedados.UsuarioImplDAO;
import java.util.ArrayList;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Karen
 */
public class TesteUsuarioDAO {

    JdbcDatabaseTester jdt;

    @Before
    public void setUp() throws Exception {
        jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost/coursera", "postgres", "admin");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        jdt.setDataSet(loader.load("/inicio.xml"));
        jdt.onSetup();
    }

    @Test
    public void insereNovo() throws Exception {
        Usuario u = new Usuario();
        u.setLogin("maria");
        u.setEmail("mt@email.com.br");
        u.setNome("Maria Tereza");
        u.setSenha("123");
        u.setPontos(2);

        UsuarioDAO usuarioDAO = new UsuarioImplDAO();
        usuarioDAO.inserir(u);

        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentITable = currentDataset.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataset = loader.load("/verifica.xml");

        ITable expectedTable = expectedDataset.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentITable);
    }

    @Test
    public void recupera() throws Exception {

        Usuario u = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioImplDAO();
        u = usuarioDAO.recuperar("karen");
        assertEquals("Karen Vicente", u.getNome());
    }

    @Test
    public void adicionarPontos() throws Exception {

        Usuario u = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioImplDAO();
        usuarioDAO.adicionarPontos("karen", 20);

        IDataSet currentDataset = jdt.getConnection().createDataSet();
        ITable currentITable = currentDataset.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataset = loader.load("/pontos.xml");

        ITable expectedTable = expectedDataset.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentITable);
    }

    @Test
    public void ranking() throws Exception {

        Usuario u = new Usuario();
        UsuarioDAO usuarioDAO = new UsuarioImplDAO();
        usuarioDAO.adicionarPontos("karen", 20);

        List<Usuario> lista = usuarioDAO.ranking();
        usuarioDAO.adicionarPontos("karen", 20);

        assertEquals("karen", lista.get(0).getLogin()); //primeiro
        assertEquals("joao", lista.get(1).getLogin()); //ultimo

    }

}

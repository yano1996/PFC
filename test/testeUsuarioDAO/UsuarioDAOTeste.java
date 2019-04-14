/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeUsuarioDAO;

import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import model.Endereco;
import model.PerfilDeAcesso;
import model.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author nelson_amaral
 */
public class UsuarioDAOTeste {

    
    
    public UsuarioDAOTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    //MOCKITO
    @Test
    public void testeCasdastroUsuario() throws SQLException {
        UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);
        Usuario usuarioCadastrado = criarUserTeste();
         
        usuarioDAO.cadastaNovoUsuario(usuarioCadastrado);
        Mockito.verify(usuarioDAO).cadastaNovoUsuario(usuarioCadastrado);
    
    }
    //MOCKITO
    @Test
    public void testeListaDeUsuarios() {               
        UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);
        ArrayList<Usuario> listaUsuario = new ArrayList<>();
        Mockito.when(usuarioDAO.exibirUsuarios()).thenReturn(listaUsuario);
        
    }
    //MOCKITO
    @Test
    public void testeAutenticaUsuario() throws SQLException {
       UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);
        Usuario usuarioCadAutentica = criarUserTeste();
        
        usuarioDAO.autenticaUsuario(usuarioCadAutentica);
       
       Mockito.verify(usuarioDAO).autenticaUsuario(usuarioCadAutentica);

      
    }
    //MOCKITO
    @Test
    public void testeExcluirUsuario() throws SQLException{
        UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);        
        Usuario usuarioCadAExcluir = criarUserTeste();
        usuarioDAO.cadastaNovoUsuario(usuarioCadAExcluir);
        
        usuarioDAO.excluirUsuario(usuarioCadAExcluir.getId());
        
       Mockito.verify(usuarioDAO).excluirUsuario(usuarioCadAExcluir.getId());
     
    
    }
    //MOCKITO
    @Test
    public void testeAtualizar_usuario() throws SQLException    {
       UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);
        Usuario usuarioAtualizarOld = criarUserTeste();
        
        usuarioDAO.cadastaNovoUsuario(usuarioAtualizarOld);

        Usuario usuarioAtualizarNovo = criarUserTeste();

        
        usuarioDAO.atualizar_usuario(usuarioAtualizarNovo);
        Mockito.verify(usuarioDAO).atualizar_usuario(usuarioAtualizarNovo);

    }
    @Test
    public void testebuscaUsuarioUnico() throws SQLException {
        UsuarioDAO usuarioDAO = Mockito.mock(UsuarioDAO.class);
        Usuario usuarioUniBusca = criarUserTeste();
        usuarioDAO.buscaUsuarioUnico(usuarioUniBusca.getId());
        Mockito.verify(usuarioDAO).buscaUsuarioUnico(usuarioUniBusca.getId());
    }
    
    private Usuario criarUserTeste(){
        //Endereco endereco = new Endereco("Cadastro", 106, "Mogi", "bairro", "complemento", 1111, "sp", true);
        Usuario usuario = new Usuario();
        usuario.setNome(randon());
        usuario.setIdade(12);
        usuario.setCpf(randon());
        usuario.setRg(randon());
        usuario.setSenha(randon());
        usuario.setTelefone(1111);
        usuario.setCelular(2222);
        usuario.setTiposague("A");
        usuario.setPeso(1);
        usuario.setAltura(1);
        usuario.setNascimento(java.sql.Date.valueOf("2015-11-23"));
        usuario.setAcesso(PerfilDeAcesso.USUARIO);      
        usuario.setStatus(true);
        return usuario;
    }
    
    private String randon(){
        // Determia as letras que poderão estar presente nas chaves
        String letras = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";

        Random random = new Random();

        String armazenaChaves = "";
        int index = -1;
        for (int i = 0; i < 9; i++) {
            index = random.nextInt(letras.length());
            armazenaChaves += letras.substring(index, index + 1);
        }
        return armazenaChaves;
    }
    
}

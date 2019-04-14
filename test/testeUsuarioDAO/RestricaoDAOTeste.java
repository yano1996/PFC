/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeUsuarioDAO;

import dao.RestricaoDAO;
import java.util.ArrayList;
import java.util.Random;
import model.Restricao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Nelson_Amaral
 */
public class RestricaoDAOTeste {
    
    public RestricaoDAOTeste() {
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
    public void testeCadastaNovoRestricao (){
        RestricaoDAO retricaoDAO = Mockito.mock(RestricaoDAO.class);
        Restricao restricao = criarRestricaoTeste();       
       retricaoDAO.cadastaNovoRestricao(restricao);
        Mockito.verify(retricaoDAO).cadastaNovoRestricao(restricao);

    }
    
    //MOCKITO
    @Test
    public void testeConsultarRestricao (){
        RestricaoDAO retricaoDAO = Mockito.mock(RestricaoDAO.class);
        ArrayList<Restricao> listaRestricao = new ArrayList<>();
        Mockito.when(retricaoDAO.consultarRestricao()).thenReturn(listaRestricao);
        //assertTrue(retricaoDAO.consultarRestricao().containsAll(listaRestricao));
    }
    
    //MOCKITO
    @Test
    public void testeDeletarRestricao (){
        RestricaoDAO retricaoDAO = Mockito.mock(RestricaoDAO.class);
        Restricao restricao = criarRestricaoTeste();
   
        
        restricao.setRestricao_id(retricaoDAO.cadastaNovoRestricao(restricao));
       restricao.setRestricao_status(retricaoDAO.deletarRestricao(restricao.getRestricao_id()));
    Mockito.verify(retricaoDAO).deletarRestricao(restricao.getRestricao_id());
  
    }
    @Test
    public void testesAtualizaRestricao (){
        Restricao restricao = criarRestricaoTeste();       
        RestricaoDAO restricaoDAO = Mockito.mock(RestricaoDAO.class);        
        restricao.setRestricao_id(restricaoDAO.cadastaNovoRestricao(restricao));
        
        Restricao restricaoAtualizado = criarRestricaoTeste();
        restricaoAtualizado.setRestricao_id(restricao.getRestricao_id());
        
        restricaoDAO.atualizaRestricao(restricaoAtualizado);
        
        Mockito.verify(restricaoDAO).atualizaRestricao(restricaoAtualizado);
        
   
    }
 
    
    private Restricao criarRestricaoTeste(){
        Restricao restricao = Mockito.mock(Restricao.class);
        restricao.setRestricao_nome(randon());
        restricao.setRestricao_status(true);
        restricao.setRestricao_tipo(randon());
        return restricao;
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

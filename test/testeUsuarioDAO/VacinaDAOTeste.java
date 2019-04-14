/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeUsuarioDAO;

import dao.VacinaDAO;
import java.util.ArrayList;
import java.util.Random;
import model.Restricao;
import model.TipoVacina;
import model.Vacina;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

/**
 *
 * @author Nelson.Amaral
 */
public class VacinaDAOTeste {

    public VacinaDAOTeste() {
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

    @Test
    //MOCKITO
    public void testeCadastaNovoVacina() {

        VacinaDAO vacinaDAO = Mockito.mock(VacinaDAO.class);
        Vacina vacina = Mockito.mock(Vacina.class);
        vacina.setId_vacina(vacinaDAO.cadastaNovoVacina(vacina));
        Vacina vacinacadastrado = new Vacina("Vacina1", 1, 1, TipoVacina.Vacinas_mortas_inactivadas);

        vacinaDAO.cadastaNovoVacina(vacinacadastrado);

        Mockito.verify(vacinaDAO).cadastaNovoVacina(vacinacadastrado);

    }

    //MOCKITO
    @Test
    public void testeConsultarVacinas() {
        VacinaDAO vacinaDAO = Mockito.mock(VacinaDAO.class);

        ArrayList<Vacina> listaVacinas = new ArrayList<>();
        Mockito.when(vacinaDAO.ConsultarVacinas()).thenReturn(listaVacinas);

    }

    //CADASTRANDO E EXCLINDO LOGICO
    //MOCKITO
    @Test
    public void testeExcluirVacina() {
        VacinaDAO vacinaDAO = Mockito.mock(VacinaDAO.class);
        Vacina vacina = criaVacinaTeste();
        vacina.setId_vacina(vacinaDAO.cadastaNovoVacina(vacina));
        vacina.setStatus(vacinaDAO.excluirVacina(vacina.getId_vacina()));
        Mockito.verify(vacinaDAO).excluirVacina(vacina.getId_vacina());

    }

    //MOCKITO
    @Test
    public void testeBuscarVacinaUnica() {
        VacinaDAO vacinaDAO = Mockito.mock(VacinaDAO.class);
        Vacina vacina = criaVacinaTeste();

        vacina.setId_vacina(vacinaDAO.cadastaNovoVacina(vacina));

        vacinaDAO.buscarVacinaUnica(vacina.getId_vacina());
        Mockito.verify(vacinaDAO).buscarVacinaUnica(vacina.getId_vacina());

    }

    //MOCKITO
    @Test
    public void testesAtualizar_vacina() {
        VacinaDAO vacinaDAO = Mockito.mock(VacinaDAO.class);
        Vacina vacina = criaVacinaTeste();

        vacina.setId_vacina(vacinaDAO.cadastaNovoVacina(vacina));

        Vacina vacinaAtualizada = criaVacinaTeste();
        vacinaAtualizada.setId_vacina(vacina.getId_vacina());

        vacinaDAO.atualizar_vacina(vacinaAtualizada);
        Mockito.verify(vacinaDAO).atualizar_vacina(vacinaAtualizada);
    }

    private Vacina criaVacinaTeste() {

        ArrayList<Restricao> restricoes = new ArrayList<Restricao>();
        Vacina vacina = new Vacina();
        vacina.setNome(randon());
        vacina.setDose(0);
        vacina.setIntervalo(0);
        vacina.setTipo(TipoVacina.Vacinas_mortas_inactivadas);
        vacina.setStatus(true);
        vacina.setRestricoes(restricoes);
        return vacina;
    }

    private String randon() {
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

package br.com.odontologia.test;


import br.com.odontologia.dao.impl.DentistaDaoH2;
import br.com.odontologia.model.Dentista;
import br.com.odontologia.service.DentistaService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class DentistaServiceTest {

    private static DentistaService dentistaService =
            new DentistaService(
                    new DentistaDaoH2());


    @BeforeClass
    public static void carregarDentistasSet() {
        Dentista d1 = dentistaService.salvar(new Dentista("555555", "Lucas", "Neiva"));

        Dentista d2 = dentistaService.salvar(new Dentista("444444", "Will", "Smith"));

        Dentista d3 = dentistaService.salvar(new Dentista("333333", "Ana", "Paula"));
    }

    @Test
    public static void cadastroAndBusca() {
        Dentista d4 = dentistaService.salvar(new Dentista("4444", "Stephanny", "Moura"));
        Assert.assertNotNull(dentistaService.buscar(d4.getId()));
    }

    @Test
    public static void excluirDentista() {
        dentistaService.excluir(3);
        Assert.assertTrue(dentistaService.buscar(3).isEmpty());
    }

    @Test
    public void trazerTodos() {
        List<Dentista> dentistas = dentistaService.buscarTodos();
        Assert.assertTrue(!dentistas.isEmpty());
        Assert.assertTrue(dentistas.size() == 3);
        System.out.println(dentistas);
    }




}

package br.com.odontologia.test;

import br.com.odontologia.dao.impl.EnderecoDaoH2;
import br.com.odontologia.dao.impl.PacienteDaoH2;
import br.com.odontologia.model.Endereco;
import br.com.odontologia.model.Paciente;
import br.com.odontologia.service.EnderecoService;
import br.com.odontologia.service.PacienteService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class PacienteServiceTest {

    private static PacienteService pacienteService =
            new PacienteService(
                    new PacienteDaoH2(
                            new EnderecoDaoH2()));
    private EnderecoService enderecoService =
            new EnderecoService(
                    new EnderecoDaoH2());

    @BeforeClass
    public static void carregarDataSet() {
        Endereco end1 =
                new Endereco("Ladeira do Acupe", "313", "Brotas", "Salvador");
        Paciente p1 = pacienteService.salvar(
                new Paciente(
                        "Amanda", "Neiva", "2165784523", new Date(), end1));

        Endereco end2 =
                new Endereco("Rua Gato Preto", "255", "Lapa", "Lauro de Freitas");
        Paciente p2 = pacienteService.salvar(
                new Paciente(
                        "Ricardo", "Maia", "6521447788", new Date(), end2));

        Endereco end3 =
                new Endereco("Av. do Forte", "66", "Jardim das Hortências", "Feira de Santana");
        Paciente p3 = pacienteService.salvar(
                new Paciente(
                        "José", "Silva", "6485002236", new Date(), end3));
    }


        @Test
        public void cadastrarEBuscarPacienteTest() {
            Endereco end4 =
                    new Endereco("Av. Bento Martins", "866", "Centro", "Porto Alegre");
            Paciente p4 = pacienteService.salvar(
                    new Paciente(
                            "Luiz", "Gustavo", "5411778541", new Date(), end4));
            Assert.assertNotNull(pacienteService.buscar(p4.getId()));
        }

        @Test
        public void excluirPacienteTest() {
            pacienteService.excluir(3);
            Assert.assertTrue(pacienteService.buscar(3).isEmpty());
        }

        @Test
        public void trazerTodos() {
            List<Paciente> pacientes = pacienteService.buscarTodos();
            Assert.assertTrue(!pacientes.isEmpty());
            Assert.assertTrue(pacientes.size() == 3);
            System.out.println(pacientes);
        }

}



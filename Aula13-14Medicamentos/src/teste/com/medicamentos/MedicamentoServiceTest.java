package teste.com.medicamentos;

import com.medicamentos.dao.ConfiguracaoJDBC;
import com.medicamentos.dao.ipml.MedicamentoDaoH2;
import com.medicamentos.model.Medicamento;
import com.medicamentos.service.MedicamentoService;
import org.junit.Assert;
import org.junit.Test;

public class MedicamentoServiceTest {

    private MedicamentoService medicamentoService = new MedicamentoService(new MedicamentoDaoH2(new ConfiguracaoJDBC()));


    @Test
    public void guardarMedicamento() {
        Medicamento medicamento = new Medicamento(
                "Ibuprofeno",
                "Genérico",
                1000,
                50.5);

        medicamentoService.salvar(medicamento);
        Assert.assertTrue(medicamento.getId() != null);
    }
}

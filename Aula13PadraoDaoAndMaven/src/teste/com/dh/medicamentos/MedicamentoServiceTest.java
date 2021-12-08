package teste.com.dh.medicamentos;

import com.dh.medicamentos.Dao.ConfiguracaoJDBC;
import com.dh.medicamentos.Dao.impl.MedicamentoDaoH2;
import com.dh.medicamentos.Model.Medicamento;
import com.dh.medicamentos.Service.MedicamentoService;
import org.junit.Assert;
import org.junit.Test;

public class MedicamentoServiceTest {

    private MedicamentoService medicamentoService =
            new MedicamentoService(
                    new MedicamentoDaoH2(
                            new ConfiguracaoJDBC()));


    @Test
    public void guardarMedicamento() {
        Medicamento medicamento = new Medicamento("Ibuprofeno", "lab123", 1000, 200.0);

        medicamentoService.salvar(medicamento);
        Assert.assertTrue(medicamento.getId() != null);
    }

}

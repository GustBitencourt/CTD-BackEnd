package ExercicioGuiado;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    Pessoa pessoa0;
    Pessoa pessoa1;
    Pessoa pessoa2;

    @BeforeEach
    void doBefore() {
        pessoa0 = new Pessoa("Gaspar", "Souza");
        pessoa0.setIdade(LocalDate.of(1990, 6, 23));

        pessoa1 = new Pessoa("Natalia", "Viera");
        pessoa1.setIdade(LocalDate.of(1990, 10, 03));

        pessoa2 = new Pessoa("Caio", "Castro");
        pessoa2.setIdade(LocalDate.of(1978, 6, 13));
    }

    @Test
    void getNomeCompleto(){
        assertEquals("Gaspar Souza", pessoa0.calcularNomeInteiro());
        assertEquals("Natalia Viera", pessoa1.calcularNomeInteiro());
        assertEquals("Caio Castro", pessoa2.calcularNomeInteiro());
    }

    @Test
    void getEhMaiorIdade() {
        assertEquals(pessoa0.ehMaiorIdade(), true);
        assertEquals(pessoa1.ehMaiorIdade(), true);
        assertEquals(pessoa2.ehMaiorIdade(), true);
    }


}
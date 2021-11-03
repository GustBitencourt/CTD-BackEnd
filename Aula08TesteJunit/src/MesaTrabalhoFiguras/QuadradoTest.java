package MesaTrabalhoFiguras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadradoTest {

    Quadrado quadrado1;
    Quadrado quadrado2;

    @BeforeEach
    void doBefore() {
        quadrado1 = new Quadrado(5);
        quadrado2 = new Quadrado(6.5);
    }

    @Test
    void getCalcularPerimetro() {
        assertEquals(20, quadrado1.calcularPerimetro());
        assertEquals(26, quadrado2.calcularPerimetro());
    }



}
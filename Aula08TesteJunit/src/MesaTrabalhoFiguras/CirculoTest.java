package MesaTrabalhoFiguras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirculoTest {

    Circulo circulo1;
    Circulo circulo2;

    @BeforeEach
    void doBefore() {
        circulo1 = new Circulo(5);
        circulo2 = new Circulo(7);
    }

    @Test
    void getCalcularPerimetro() {
        assertEquals(31.40, circulo1.calcularPerimetro());
        assertEquals(43.96, circulo2.calcularPerimetro());
    }

}
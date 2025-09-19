package br.edu.unijui.vv.integracao;

import br.edu.unijui.vv.integracao.Potencia;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PotenciaTeste {
    @Test
    void deveCalcularPotenciasPequenas() {
        assertEquals(8, Potencia.calcular(2,3));
        assertEquals(64, Potencia.calcular(4,3));
        assertEquals(1, Potencia.calcular(5,0));
        assertEquals(0, Potencia.calcular(0,5));
        assertEquals(1, Potencia.calcular(0,0));
    }

    @Test
    void deveTratarBaseNegativa() {
        assertEquals(-8, Potencia.calcular(-2,3));
        assertEquals(16, Potencia.calcular(-4,2));
    }

    @Test
    void deveLancarExcecaoQuandoExpoenteNegativo() {
        assertThrows(IllegalArgumentException.class, () -> Potencia.calcular(3, -1));
    }
}

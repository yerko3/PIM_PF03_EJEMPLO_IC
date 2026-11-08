package com.pim.jrgs2526.pf03;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9, 10})
    public void testCalcularAprobado(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(1, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    public void testCalcularSuspenso(int nota) {
        App main = new App();
        int resultado = main.calcularNota(nota);
        Assertions.assertEquals(-1, resultado);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11, 63})
    public void testCalcularError(int nota) {
        App main = new App();

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> main.calcularNota(nota)
        );

        Assertions.assertEquals(
                "Error al calcular la nota",
                exception.getMessage()
        );
    }
}

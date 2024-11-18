package com.github.nogueiralegacy.distancia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test // CT 1
    void latitudeMenorInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(-100, 0); 
        });
    }

    @Test // CT 2
    void latitudeMaiorInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(100, 0); 
        });
    }

    @Test // CT 3
    void latitudeValidaTest() {
        Coordenada coordenada1 = new Coordenada(45, 0);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(5004.0, distancia);
    }

    @Test // CT 4
    void longitudeMenorInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(0, -200); 
        });
    }

    @Test // CT 5
    void longitudeMaiorInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(91, 200); 
        });
    }

    @Test // CT 6
    void longitudeValidaTest() {
        Coordenada coordenada1 = new Coordenada(0, 90);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(10008.0, distancia);
    }

    @Test // CT 7
    void latitudeLimiteInferiorMenosUmInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(-91, 0); 
        });
    }

    @Test // CT 8
    void latitudeLimiteInferiorValidaTest() {
        Coordenada coordenada1 = new Coordenada(-90, 0);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(10008.0, distancia);
    }

    @Test // CT 9
    void latitudeLimiteInferiorMaisUmValidaTest() {
        Coordenada coordenada1 = new Coordenada(-89, 0);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(9896.0, distancia);
    }

    @Test // CT 10
    void latitudeLimiteSuperiorMenosUmValidaTest() {
        Coordenada coordenada1 = new Coordenada(89, 0);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(9896.0, distancia);
    }

    @Test // CT 11
    void latitudeLimiteSuperiorValidaTest() {
        Coordenada coordenada1 = new Coordenada(90, 0);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(10008.0, distancia);
    }

    @Test // CT 12
    void latitudeLimiteSuperiorMaisUmInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(91, 0); 
        });
    }

    @Test // CT 13
    void longitudeLimiteInferiorMenosUmInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(-181, 0); 
        });
    }

    @Test // CT 14
    void longitudeLimiteInferiorValidaTest() {
        Coordenada coordenada1 = new Coordenada(0, -180);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(20015.0, distancia);
    }

    @Test // CT 15
    void longitudeLimiteInferiorMaisUmValidaTest() {
        Coordenada coordenada1 = new Coordenada(0, -179);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(19904.0, distancia);
    }

    @Test // CT 16
    void longitudeLimiteSuperiorMenosUmValidaTest() {
        Coordenada coordenada1 = new Coordenada(0, 179);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(19904.0, distancia);
    }

    @Test // CT 17
    void longitudeLimiteSuperiorValidaTest() {
        Coordenada coordenada1 = new Coordenada(0, 180);
        Coordenada coordenada2 = new Coordenada(0, 0);

        double distancia = Calculadora.Haversine(coordenada1, coordenada2, Calculadora.getRaioTerra());

        assertEquals(20015.0, distancia);
    }

    @Test // CT 18
    void longitudeLimiteSuperiorMaisUmInvalidaTest() {
        assertThrows(CoordenadaInvalidaException.class, () -> {
            Coordenada coordenada = new Coordenada(0, 181);
        });
    }
}

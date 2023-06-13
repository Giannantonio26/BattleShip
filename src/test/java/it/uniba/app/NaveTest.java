/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import it.uniba.app.entitaDiGioco.Nave;
import it.uniba.app.entitaDiGioco.StatoPosizione;
import it.uniba.app.entitaDiGioco.Coord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
/**
 *
 * @author gabri
 */

class NaveTest {
    private static final int DIM_NAVE_VALIDA = 3;
    private static final int DIM_NAVE_NON_VALIDA = 0;
    private static final int COORDINATE = 4;
    @Test
    @DisplayName("Test costruttore con dimensione corretta")
    void testNaveValida() {
        Nave naveTest = new Nave(DIM_NAVE_VALIDA);
        assertAll(() -> {
            assertEquals("Incrociatore", naveTest.getNome(), "Nome impostato correttamente");
            assertEquals(DIM_NAVE_VALIDA, naveTest.getDimensione(), "Dimensione impostata correttamente");
        });
    }

    @Test
    @DisplayName("Test costruttore con dimensione non valida")
    void testNaveNonValida() {
        assertThrows(IllegalArgumentException.class, () -> {
        Nave n = new Nave(DIM_NAVE_NON_VALIDA);
    });
    }

    @Test
    @DisplayName("Test metodo aggiungiPosizione")
    void testAggiungiPosizione() {
        Nave naveTest = new Nave(DIM_NAVE_VALIDA);
        Coord coordTest = new Coord(COORDINATE, COORDINATE);
        naveTest.aggiungiPosizione(coordTest);
        assertEquals(StatoPosizione.INTEGRA, naveTest.getCoordinate().get(coordTest), "Cella della nave"
                + "correttamente impostata");
    }
}


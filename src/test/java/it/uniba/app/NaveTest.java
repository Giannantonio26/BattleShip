/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import it.uniba.app.entitaDiGioco.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author gabri
 */

class NaveTest {
    @Test
    @DisplayName("Test costruttore con dimensione corretta")
    void testNaveValida(){
        Nave naveTest = new Nave(3);
        assertAll( () -> {
            assertTrue(naveTest.getNome().equals("Incrociatore"));
            assertEquals(3, naveTest.getDimensione());
            /*assertEquals(3, naveTest.getEsemplariInGioco());*/
        });
    }

    @Test
    @DisplayName("Test costruttore con dimensione non valida")
    void testNaveNonValida(){
        assertThrows(IllegalArgumentException.class, () -> {
        Nave n = new Nave(0);
    });
    
    }

    @Test
    @DisplayName("Test metodo aggiungiPosizione")
    void testAggiungiPosizione(){
        Nave naveTest = new Nave(2);
        Coord coordTest = new Coord(3,3);
        naveTest.aggiungiPosizione(coordTest);
        assertEquals(StatoPosizione.INTEGRA, naveTest.getCoordinate().get(coordTest));
    }
}


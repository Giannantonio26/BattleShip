/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import it.uniba.app.comandi.ComandoLivello;
import it.uniba.app.entitaDiGioco.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author gabri
 */
public class ComandoLivelloTest {
    @Test
    @DisplayName("Test corretta impostazione parametri della partita")
    void testComandoLivello(){
        Parser p = new Parser("/medio");
        p.elabora();
        ComandoLivello com = new ComandoLivello("/medio");
        LivelloDiGioco liv = new LivelloDiGioco(TipoLivello.MEDIO);
        com.esegui();
        assertAll( () -> {
            assertEquals(TipoLivello.MEDIO, Partita.getLivello());
            assertEquals(30, Partita.getTentativi());
            assertEquals(TipoLivello.MEDIO, liv.getTipoLivello());
            assertEquals(30, liv.getNumeroTentativi());
            
        });
    }
    
    @Test
    @DisplayName("Verifica che i parametri della partita rimangano invariati se viene passato un livello non valido")
    void testLivelloNonValido(){
        Parser p = new Parser("blabla");
        p.elabora();
        ComandoLivello com = new ComandoLivello("blabla");
        LivelloDiGioco liv = new LivelloDiGioco();
        assertAll( () -> {
            assertEquals(TipoLivello.FACILE, Partita.getLivello());
            assertEquals(50, Partita.getTentativi());
            assertNull(liv.getTipoLivello());
            assertEquals(0,liv.getNumeroTentativi());
            
        });        
    }
}


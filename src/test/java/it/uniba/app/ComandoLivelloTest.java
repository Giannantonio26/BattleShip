/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import it.uniba.app.comandi.ComandoLivello;
import it.uniba.app.entitaDiGioco.LivelloDiGioco;
import it.uniba.app.entitaDiGioco.TipoLivello;
import it.uniba.app.entitaDiGioco.Partita;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 *
 * @author gabri
 */
class ComandoLivelloTest {
    private static final int TENTATIVI_MEDIO = 30;
    private static final int TENTATIVI_FACILE = 50;
    private static final int TENTATIVI_NULLO = 0;
    @Test
    @DisplayName("Test corretta impostazione parametri della partita")
    void testComandoLivello() {
        Parser p = new Parser("/medio");
        p.elabora();
        ComandoLivello com = new ComandoLivello("/medio");
        LivelloDiGioco liv = new LivelloDiGioco(TipoLivello.MEDIO);
        com.esegui();
        assertAll(() -> {
            assertEquals(TipoLivello.MEDIO, Partita.getLivello(), "Difficoltà correttamente su Medio");
            assertEquals(TENTATIVI_MEDIO, Partita.getTentativi(), "Numero di tentativi corretto per la difficoltà");
            assertEquals(TipoLivello.MEDIO, liv.getTipoLivello(), "Parametro TipoLivello della partita"
                    + "correttamente impostato a Medio");
            assertEquals(TENTATIVI_MEDIO, liv.getNumeroTentativi(), "Numero tentativi del livello"
                    + "correttamente impostato");
        });
    }

    @Test
    @DisplayName("Verifica che i parametri della partita rimangano invariati se viene passato un livello non valido")
    void testLivelloNonValido() {
        Parser p = new Parser("blabla");
        p.elabora();
        LivelloDiGioco liv = new LivelloDiGioco();
        assertAll(() -> {
            assertEquals(TipoLivello.FACILE, Partita.getLivello(), "Difficoltà rimasta correttamente a"
                    + " valore default");
            assertEquals(TENTATIVI_FACILE, Partita.getTentativi(), "Numero tentativi rimasto"
                    + "correttamente a valore di default");
            assertNull(liv.getTipoLivello(), "Tipo livello correttamente non inizializzato");
            assertEquals(TENTATIVI_NULLO, liv.getNumeroTentativi(), "Numero tentativi"
                    + "del livello rimasto correttamente non inizializzato");
        });
    }
}


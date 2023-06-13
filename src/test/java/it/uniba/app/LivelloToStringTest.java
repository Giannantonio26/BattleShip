/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import it.uniba.app.entitaDiGioco.LivelloDiGioco;
import it.uniba.app.entitaDiGioco.TipoLivello;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gabri
 */
class LivelloToStringTest {
    private static final int NUM_TENTATIVI_DEFAULT  = 50;

    @Test
    @DisplayName("Test corretta implementazione toString del livello di gioco")
    void testToString() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out, true, "UTF-8"));
            LivelloDiGioco liv = new LivelloDiGioco(TipoLivello.FACILE);
            assertAll(() -> {
                assertNotNull(liv.toString(), "Il metodo toString restituisce un oggetto");
                assertEquals("Livello: "
                        + TipoLivello.FACILE
                        + "\nNumero tentativi: "
                        + NUM_TENTATIVI_DEFAULT, liv.toString(), "Il metodo toString restituisce"
                                + "correttamente gli attributi dell'oggetto");
            });
            System.setOut(System.out);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(LivelloToStringTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

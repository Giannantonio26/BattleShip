/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import it.uniba.app.entitaDiGioco.LivelloDiGioco;
import it.uniba.app.entitaDiGioco.TipoLivello;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


/**
 *
 * @author gabri
 */
public class LivelloToStringTest {
    @Test
    @DisplayName("Test corretta implementazione toString del livello di gioco")
    void testToString() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));        
        LivelloDiGioco liv = new LivelloDiGioco(TipoLivello.FACILE);
        assertAll(() -> {
            assertNotNull(liv.toString());
            assertEquals("Livello: "
                + TipoLivello.FACILE
                + "\nNumero tentativi: "
                + 50, liv.toString());
        });
        System.setOut(System.out);
    }
}

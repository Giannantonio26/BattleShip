/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
class InputScannerTest {
    @Test
    @DisplayName("Test corretto funzionamento scanner per input utente")
    void testInputScanner() {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream("/help".getBytes("UTF-8"));
            System.setIn(in);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out, true, "UTF-8"));
            InputScanner.userInputScanner();
            assertEquals((Helper.getHelp() + "\n\nDigita un nuovo comando:").replaceAll("\\s+", ""),
                    out.toString("UTF-8").replaceAll("\\s+", ""), "Input correttamente gestito"
                            + "e Help correttamente visualizzato se l'utente digita /help");
            System.setIn(System.in);
            System.setOut(System.out);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(InputScannerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

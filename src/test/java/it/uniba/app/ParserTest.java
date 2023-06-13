/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
class ParserTest {
    @Test
    @DisplayName("Test funzionamento parser con comando valido")
    void testParserComandoValido() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out, true, "UTF-8"));
            Parser p = new Parser("/help");
            p.elabora();
            assertEquals(Helper.getHelp().trim(), out.toString("UTF-8").trim(), "Comando digitato dall'utente"
                    + "correttamente elaborato");
            System.setOut(System.out);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    @DisplayName("Test funzionamento parser con comando non valid")
    void testParserComandoNonValido() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out, true, "UTF-8"));
            Parser p = new Parser("baklsjdflkh");
            p.elabora();
            assertEquals("Comando non valido", out.toString("UTF-8").trim(), "Comando non valido digitato"
                    + "dall'utente correttamente rifiutato");
            System.setOut(System.out);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ParserTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

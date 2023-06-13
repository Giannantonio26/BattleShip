/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author gabri
 */
public class ParserTest {
    @Test
    @DisplayName("Test funzionamento parser con comando valido")
    void testParserComandoValido(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Parser p = new Parser("/help");
        p.elabora();
        assertEquals(Helper.getHelp().trim(), out.toString().trim());
        System.setOut(System.out);
    }
    
    @Test
    @DisplayName("Test funzionamento parser con comando non valid")
    void testParserComandoNonValido(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Parser p = new Parser("baklsjdflkh");
        p.elabora();
        assertEquals("Comando non valido", out.toString().trim());
        System.setOut(System.out);
    }
}

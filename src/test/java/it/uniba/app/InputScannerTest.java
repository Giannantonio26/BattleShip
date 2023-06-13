/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

/**
 *
 * @author gabri
 */
public class InputScannerTest {
    @Test
    @DisplayName("Test corretto funzionamento scanner per input utente")
    void testInputScanner() {
        ByteArrayInputStream in = new ByteArrayInputStream("/help".getBytes());  
        System.setIn(in);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));        
        InputScanner.userInputScanner();
        assertEquals((Helper.getHelp() + "\n\nDigita un nuovo comando:").replaceAll("\\s+",""), out.toString().replaceAll("\\s+",""));  
        System.setIn(System.in);
        System.setOut(System.out);  
    }
}

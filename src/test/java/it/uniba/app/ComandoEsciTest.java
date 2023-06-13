/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.ByteArrayInputStream;
/**
 *
 * @author gabri
 */
class ComandoEsciTest {
    @Test
    @DisplayName("Corretto funzionamento comando di uscita")
    void testEsci() {
        assertThrows(RuntimeException.class, () -> {
            Parser p = new Parser("/esci");
            System.setIn(new ByteArrayInputStream("si".getBytes("UTF-8")));
            p.elabora();
            System.setIn(System.in);
        });
    }
}

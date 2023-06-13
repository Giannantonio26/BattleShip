/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import it.uniba.app.comandi.ComandoAttacco;
import it.uniba.app.entitaDiGioco.*;
import java.util.Map;

/**
 *
 * @author gabri
 */
public class AttaccoTest {
    @AfterEach
    void reset() {
        CampoDiBattaglia.reset();
        System.setOut(System.out);
    }
    
    @Test
    @DisplayName("Test attacco su cella vuota")
    void testAttaccoAcqua() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));        
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 50);
        campoTest.inizializzaCampo();
        Nave n = new Nave(2);
        Partita.setIniziata(true);
        ComandoAttacco com = new ComandoAttacco(1,1);
        com.esegui();
        String[] output = out.toString().trim().split("\n");
        assertEquals("Acqua!", output[0].trim());
    }
    
    @Test
    @DisplayName("Test attacco su cella occupata")
    void testAttaccoColpito() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));        
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 50);
        Nave n = new Nave(2);
        CampoDiBattaglia.aggiungiNave(n);
        campoTest.posizionaNaveInCoordinata(2,2,n);
        Partita.setIniziata(true);
        ComandoAttacco com = new ComandoAttacco(2,2);
        com.esegui();
        String[] output = out.toString().trim().split("\n");
        assertEquals("Colpita!", output[0].trim());
    }    
}

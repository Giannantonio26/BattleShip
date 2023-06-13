/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import it.uniba.app.comandi.ComandoAttacco;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;
import it.uniba.app.entitaDiGioco.Nave;
import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.TipoLivello;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
final class AttaccoTest {
    private static final int TENTATIVI = 50;
    private static final int COORDINATE_ACQUA = 1;
    private static final int COORDINATE_COLPITO = 2;
    private static final int DIM_NAVE = 2;
    @AfterEach
    void reset() {
        CampoDiBattaglia.reset();
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Test attacco su cella vuota")
    void testAttaccoAcqua() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                System.setOut(new PrintStream(out, true, "UTF-8"));
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(AttaccoTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, TENTATIVI);
            campoTest.inizializzaCampo();
            Partita.setIniziata(true);
            ComandoAttacco com = new ComandoAttacco(COORDINATE_ACQUA, COORDINATE_ACQUA);
            com.esegui();
            String[] output = out.toString("UTF-8").trim().split("\n");
            assertEquals("Acqua!", output[0].trim(), "Corretto messaggio 'Acqua' se colpita cella vuota");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AttaccoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    @DisplayName("Test attacco su cella occupata")
    void testAttaccoColpito() {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out, true, "UTF-8"));
            CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, TENTATIVI);
            Nave n = new Nave(DIM_NAVE);
            CampoDiBattaglia.aggiungiNave(n);
            campoTest.posizionaNaveInCoordinata(COORDINATE_COLPITO, COORDINATE_COLPITO, n);
            Partita.setIniziata(true);
            ComandoAttacco com = new ComandoAttacco(COORDINATE_COLPITO, COORDINATE_COLPITO);
            com.esegui();
            String[] output = out.toString("UTF-8").trim().split("\n");
            assertEquals("Colpita!", output[0].trim(), "Corretto messaggio 'Colpita' se colpita cella occupata");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AttaccoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

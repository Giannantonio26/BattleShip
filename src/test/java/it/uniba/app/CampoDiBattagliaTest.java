/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import it.uniba.app.entitaDiGioco.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Objects;
/**
 *
 * @author gabri
 */

class CampoDiBattagliaTest {

    @Test
    @DisplayName("Test costruttore eseguito correttamente")
    void testCostruttoreCampo (){
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 40);
        LivelloDiGioco liv = new LivelloDiGioco(TipoLivello.FACILE, 40);
        assertAll( () -> {
            assertEquals(TipoLivello.FACILE, liv.getTipoLivello());
            assertEquals(40, liv.getNumeroTentativi());
        });
    }

    @Test
    @DisplayName("Test di corretta inizializzazione campo di battaglia")
    void testInizializzaCampo(){
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 50);
        campoTest.inizializzaCampo();
        Map<Coord, Nave> campo = campoTest.getCampoBattaglia();
        boolean valoriTuttiNulli = campo.values()
                .stream()
                .allMatch(Objects::isNull);
        
        int dimensioneGriglia = Partita.getDimensioneGriglia() * Partita.getDimensioneGriglia();
        assertAll( () -> {
            assertEquals(dimensioneGriglia, campo.size());
            assertTrue(valoriTuttiNulli);
        });
    }

    @Test
    @DisplayName("Test di corretta inizializzazione lista di navi")
    void testInizializzaNavi(){ 
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 50);
        List<Nave> navi = campoTest.getNavi();
        assertEquals(10, navi.size());
    }

    @Test
    @DisplayName("Test corretto posizionamento navi nella HashMap campo di battaglia")
    void testPosizionamentoNavi(){
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 50);
        campoTest.nuovaPartita();
        Map<Coord, Nave> campo = campoTest.getCampoBattaglia();
        List<Nave> navi = campoTest.getNavi();      /*Implementare*/
        for(int i = 0; i < navi.size(); i++){
            assertTrue(campo.containsValue(navi.get(i)));
        }
    }

    @Test
    void testStampaRigaVuota(){
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 50);
        assertNotNull(campoTest.stampaRigaVuota());
    }
    
    @Test
    @DisplayName("Test reset campo di battaglia")
    void testReset() {
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, 50);
        campoTest.nuovaPartita();
        campoTest.reset();
        assertAll( () -> {
            assertTrue(campoTest.getCampoBattaglia().isEmpty());
            assertTrue(campoTest.getNavi().isEmpty());
            assertEquals(0, campoTest.getNaviAffondate());
            assertEquals(0, Partita.getMinutiTrascorsi());
        });
    }
}


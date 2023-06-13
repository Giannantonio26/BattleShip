/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import it.uniba.app.entitaDiGioco.CampoDiBattaglia;
import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.TipoLivello;
import it.uniba.app.entitaDiGioco.Nave;
import it.uniba.app.entitaDiGioco.Coord;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Objects;
/**
 *
 * @author gabri
 */

class CampoDiBattagliaTest {
    private static final int PARAM_TENTATIVI = 40;
    private static final int TENTATIVI_FACILE = 50;
    private static final int NUM_NAVI = 10;
    private static final int VAL_NULLO = 0;

    @Test
    @DisplayName("Test costruttore eseguito correttamente")
    void testCostruttoreCampo() {
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, PARAM_TENTATIVI);
        assertAll(() -> {
            assertEquals(TipoLivello.FACILE, campoTest.getLivelloPartita().getTipoLivello(),
                    "Giusto parametro di default");
            assertEquals(PARAM_TENTATIVI, campoTest.getLivelloPartita().getNumeroTentativi(),
                    "Giusto numero tentativi di default");
        });
    }

    @Test
    @DisplayName("Test di corretta inizializzazione campo di battaglia")
    void testInizializzaCampo() {
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, TENTATIVI_FACILE);
        campoTest.inizializzaCampo();
        Map<Coord, Nave> campo = campoTest.getCampoBattaglia();
        boolean valoriTuttiNulli = campo.values()
                .stream()
                .allMatch(Objects::isNull);

        int dimensioneGriglia = Partita.getDimensioneGriglia() * Partita.getDimensioneGriglia();
        assertAll(() -> {
            assertEquals(dimensioneGriglia, campo.size(), "Dimensione griglia correttamente impostata");
            assertTrue(valoriTuttiNulli, "Griglia tutta con celle nulle");
        });
    }

    @Test
    @DisplayName("Test di corretta inizializzazione lista di navi")
    void testInizializzaNavi() {
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, TENTATIVI_FACILE);
        List<Nave> navi = campoTest.getNavi();
        assertEquals(NUM_NAVI, navi.size(), "Lista di navi inizializzata correttamente, giusto numero di navi");
    }

    @Test
    @DisplayName("Test corretto posizionamento navi nella HashMap campo di battaglia")
    void testPosizionamentoNavi() {
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, TENTATIVI_FACILE);
        campoTest.nuovaPartita();
        Map<Coord, Nave> campo = campoTest.getCampoBattaglia();
        List<Nave> navi = campoTest.getNavi();
        for (int i = 0; i < navi.size(); i++) {
            assertTrue(campo.containsValue(navi.get(i)), "Navi posizionate nella griglia");
        }
    }

    @Test
    void testStampaRigaVuota() {
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, TENTATIVI_FACILE);
        assertNotNull(campoTest.stampaRigaVuota(), "Il metodo restituisce un oggetto");
    }

    @Test
    @DisplayName("Test reset campo di battaglia")
    void testReset() {
        CampoDiBattaglia campoTest = new CampoDiBattaglia(TipoLivello.FACILE, TENTATIVI_FACILE);
        campoTest.nuovaPartita();
        campoTest.reset();
        assertAll(() -> {
            assertTrue(campoTest.getCampoBattaglia().isEmpty(), "Campo di battaglia giustamente vuoto");
            assertTrue(campoTest.getNavi().isEmpty(), "Lista di navi giustamente vuota");
            assertEquals(VAL_NULLO, campoTest.getNaviAffondate(), "Zero navi affondate su un campo resettato");
            assertEquals(VAL_NULLO, Partita.getMinutiTrascorsi(), "Tempo azzerato dopo reset campo");
        });
    }
}

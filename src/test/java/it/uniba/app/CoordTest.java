/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import it.uniba.app.entitaDiGioco.Coord;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * @author gabri
 */
class CoordTest {
    @Test
    @DisplayName("Controllo corretto funzionamento implementazione metodo equals")
    void testEquals() {
        Coord coord1 = new Coord(2, 2);
        Coord coord2 = new Coord(2, 2);
        assertEquals(coord1, coord2, "Il metodo equals segnala correttamente"
                + "l'uguaglianza dei due oggetti ");
    }

    @Test
    @DisplayName("Controllo che il metodo toString ritorni qualcosa")
    void testToString() {
        Coord coord1 = new Coord(1, 1);
        assertNotNull(coord1.toString(), "Il metodo toString restituisce un oggetto");
    }
}

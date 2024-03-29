/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;
import it.uniba.app.entitaDiGioco.Partita;

/**
 * 'Control'.
 * Comando per mostrare la griglia di gioco aggiornata.
 * @author leonardo
 */
public final class ComandoMostraGriglia implements Comando {
    /**
     *
     */
    public void esegui() {
        if (!Partita.isIniziata()) {
            System.out.println("\nDevi prima iniziare una partita");
        } else {
            CampoDiBattaglia.mostraGrigliaAggiornata();
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.Partita;
/**
 * 'Control'.
 * Comando per impostare il tempo di gioco.
 * @author Giannantonio
 */
public final class ComandoTempo implements Comando {
    private int minuti;
    /**
     *
     * @param minutiIn
     */
    public ComandoTempo(final int minutiIn) {
        this.minuti = minutiIn;
    }
    @Override
    public void esegui() {
        if (Partita.isIniziata()) {
            System.out.println("Impossibile impostare il tempo di gioco a partita in corso");
        } else {
            System.out.println("OK");
            Partita.setMinutDiGioco(minuti);
            Partita.setTempoDiGioco(true);
        }
    }
}

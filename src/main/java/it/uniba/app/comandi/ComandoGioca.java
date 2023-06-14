/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.ThreadTempo;
import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;

/**
 * 'Control'.
 * @author leonardo
 * Comando per iniziare una nuova partita.
 */
public final class ComandoGioca implements Comando {
     /* il metodo esegui del comando ComandoGioca
     *  crea una nuova partita e un nuovo campo di battaglia;
     *  se la partita è già iniziata, e l'utente digita il comando "/gioca"
     *  viene stampato un messaggio di errore (scelta di comportamento
     *  provvisoria).
     */
    @Override
    public void esegui() {
        if (Partita.isIniziata()) {
            System.out.println("\nUna partita è già iniziata. "
                    + "Il comando /gioca non è disponibile");
        } else {
            CampoDiBattaglia campo =
                    new CampoDiBattaglia(Partita.getLivello(), Partita.getTentativi());
            Partita.setCampo(campo);
            campo.nuovaPartita();
            //se il tempo di gioco � attivo parte il timer
            if (Partita.isTempoDiGiocoAttivo()) {
                System.out.println("Hai a disposizione " + Partita.getMinutiDiGioco() + " minuti per giocare");
                Thread t = new Thread(new ThreadTempo());
                t.start();
            }
        }
    }
}

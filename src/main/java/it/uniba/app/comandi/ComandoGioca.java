/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;

/**
 * @author leonardo
 * Classe ComandoGioca.
 */
public final class ComandoGioca implements Comando {
     /* il metodo esegui del comando ComandoGioca
     *  crea una nuova partita e un nuovo campo di battaglia;
     *  se la partita è già iniziata, e l'uente digita il comando "/gioca"
     *  viene stampato un messaggio di errore (scelta di comportamento
     *  provvisoria).
     */
    @Override
    public void esegui() {
        if (Partita.isIniziata()) {
            System.out.println("\nUna partita e' gia' iniziata. "
                    + "Il comando /gioca non e' disponibile");
        } else {
            CampoDiBattaglia campo = new CampoDiBattaglia(Partita.getLivello());
            Partita.setCampo(campo);
            campo.nuovaPartita();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;

/**
 * 'Control'.
 * @author leonardo
 * Comando per svelare la griglia con le navi piazzate.
 */
public final class ComandoSvelaGriglia implements Comando {
    @Override
    public void esegui() {
        if (!Partita.isIniziata()) {
            System.out.println("\nDevi prima iniziare una partita");
        } else {
            CampoDiBattaglia.svelaGriglia(CampoDiBattaglia.getCampoBattaglia());
        }
    }
}

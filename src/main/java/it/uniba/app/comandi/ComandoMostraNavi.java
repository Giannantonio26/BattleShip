/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.Nave;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;

/**
 * 'Control'.
 * @author leonardo
 * Comando per mostrare le navi ancora in gioco.
 */
public final class ComandoMostraNavi implements Comando {

/**
 * Implementazione di esegui() che
 * stampa le navi del gioco chiamando
 * il metodo statico della classe Partita.
 */
    private static final int DIM_DUE = 2;
    private static final int DIM_TRE = 3;
    private static final int DIM_QUATTRO = 4;
    private static final int DIM_CINQUE = 5;
    @Override
    public void esegui() {
        if (!Partita.isIniziata()) {
            Partita.mostraNavi();
        } else {
            boolean nave2 = false;
            boolean nave3 = false;
            boolean nave4 = false;
            boolean nave5 = false;
            for (Nave nave : CampoDiBattaglia.getNAVI()) {
                if (nave.getDimensione() == DIM_DUE) {
                    if (!nave2) {
                        nave2 = true;
                        System.out.println("NAVE: " + nave.getNome()
                        + "; DIMENSIONE: "
                        + nave.stampaNaveInQuadrati()
                        + "; ESEMPLARI IN GIOCO: "
                        + CampoDiBattaglia.getEsemplari2() + "\n");
                    } else {
                        System.out.print("");
                    }
                } else if (nave.getDimensione() == DIM_TRE) {
                    if (!nave3) {
                        nave3 = true;
                        System.out.println("NAVE: " + nave.getNome()
                        + "; DIMENSIONE: "
                        + nave.stampaNaveInQuadrati()
                        + "; ESEMPLARI IN GIOCO: "
                        + CampoDiBattaglia.getEsemplari3() + "\n");
                    } else {
                        System.out.print("");
                    }
                } else if (nave.getDimensione() == DIM_QUATTRO) {
                    if (!nave4) {
                        nave4 = true;
                        System.out.println("NAVE: " + nave.getNome()
                                + "; DIMENSIONE: "
                                + nave.stampaNaveInQuadrati()
                                + "; ESEMPLARI IN GIOCO: "
                                + CampoDiBattaglia.getEsemplari4() + "\n");
                    } else {
                        System.out.print("");
                    }
                } else if (nave.getDimensione() == DIM_CINQUE) {
                    if (!nave5) {
                        nave5 = true;
                        System.out.println("NAVE: " + nave.getNome()
                                + "; DIMENSIONE: "
                                + nave.stampaNaveInQuadrati()
                                + "; ESEMPLARI IN GIOCO: "
                                + CampoDiBattaglia.getEsemplari5() + "\n");
                    } else {
                        System.out.print("");
                    }
                }
            }
        }
    }
}

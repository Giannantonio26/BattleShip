/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.LivelloDiGioco;
import it.uniba.app.entitaDiGioco.Partita;

/**
 * @author leonardo
 * Classe ComandoMostraLivello.
 */
public final class ComandoMostraLivello implements Comando {
    /**
     * Implementazione di esegui che mostra il livello.
     */
    @Override
    public void esegui() {
        LivelloDiGioco liv = new  LivelloDiGioco(Partita.getLivello(), Partita.getTentativi());
        System.out.println(liv);
    }
}

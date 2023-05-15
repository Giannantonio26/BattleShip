/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.Partita;
/**
 *
 * @author leonardo
 */

/**
 * Classe ComandoMostraNavi.
 */
public final class ComandoMostraNavi implements Comando {

/**
 * Implementazione di esegui() che
 * stampa le navi del gioco chiamando
 * il metodo statico della classe Partita.
 */
    @Override
    public void esegui() {
        Partita.mostraNavi();
        }
}

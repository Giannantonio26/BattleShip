/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import  it.uniba.app.entitaDiGioco.CampoDiBattaglia;
import  it.uniba.app.entitaDiGioco.Partita;

/**
 * 'Control'.
 * @author 39379
 * Comando per mostrare tentativi fatti, falliti e rimasti.
 */
public final class ComandoMostraTentativi implements Comando {
   @Override
    public void esegui() {
        if (!Partita.isIniziata()) {
            System.out.println("Devi prima iniziare una partita");
         } else {
            System.out.println("Numero tentativi già effettuati: " + Partita.getTentativiEffettuati());
            System.out.println("Numero tentativi falliti: "
            + "" + (Partita.getTentativi() - CampoDiBattaglia.getLivelloPartita().getNumeroTentativi()));
            System.out.println("Numero massimo di tentativi falliti: " + Partita.getTentativi());
         }
    }
}

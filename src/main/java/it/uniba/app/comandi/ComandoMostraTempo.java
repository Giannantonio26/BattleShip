/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.Partita;

/**
 *
 * @author Giannantonio
 */
public class ComandoMostraTempo implements Comando{

    @Override
    public void esegui() {  
        if(Partita.isTempoDiGiocoAttivo()){
            System.out.println("Minuti trascorsi: "+Partita.getMinutiTrascorsi());
            System.out.println("Minuti ancora disponibili: "+(Partita.getMinutiDiGioco()-Partita.getMinutiTrascorsi()));
        }else{
            System.out.println("Tempo di gioco non impostato!");
        }
    }
       
}

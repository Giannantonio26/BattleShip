/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.Partita;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giannantonio
 */
public class ComandoTempo implements Comando{

    private int minuti;
    
    public ComandoTempo(int minuti){
        this.minuti = minuti;
    }
    
    @Override
    public void esegui(){
        if(Partita.isIniziata()){
            System.out.println("Impossibile impostare il tempo di gioco a partita in corso");
        }else{
            System.out.println("OK");
            Partita.setMinutDiGioco(minuti);
            Partita.setTempoDiGiocoAttivo();
        }
    }
}
   

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
public class ComandoTempo implements Runnable{

    public ComandoTempo(int minuti){
        Partita.setMinutDiGioco(minuti);
        Partita.setTempoDiGiocoAttivo();
    }
    
    @Override
    public void run(){
        int minTempoDiGioco;
        minTempoDiGioco = Partita.getMinutiDiGioco();  //tempo di gioco in minuti
        int secondiTempoDiGioco = minTempoDiGioco*60; //tempo di gioco in secondi
        
        int min=0,sec=0;
        for(int i=0;i<secondiTempoDiGioco;i++){
            if (i % 60 == 0 && i!=0) {
                min++;
                Partita.setMinutiTrascorsi(min);
                sec = 0;
            }else {
                sec++;
            }
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e){
                return;
            }
        }
        System.out.println("TEMPO SCADUTO");
        System.exit(0);
    }
}
   

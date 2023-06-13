/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;

import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Giannantonio
 */
public class ThreadTempo implements Runnable{

    @Override
    public void run() {
        int minTempoDiGioco;
        minTempoDiGioco = Partita.getMinutiDiGioco();  //tempo di gioco in minuti
        int secondiTempoDiGioco = minTempoDiGioco*60; //tempo di gioco in secondi
        
        int min=0,sec=0;
        for(int i=0;i<secondiTempoDiGioco;i++){
            //se la partita è stata abbandonata interrompi il timer
            if(!Partita.isIniziata()){
                return;
            }
            
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
        Partita.setIniziata(false);
        CampoDiBattaglia.reset();
    }
    
}

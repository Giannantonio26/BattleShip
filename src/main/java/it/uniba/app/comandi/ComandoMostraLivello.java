/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.LivelloDiGioco;
import it.uniba.app.entitaDiGioco.Partita;
/**
 *
 * @author leonardo
 */
public class ComandoMostraLivello implements Comando{
        @Override
        public void esegui(){
        LivelloDiGioco liv = new LivelloDiGioco(Partita.getLivello());
        System.out.println(liv.toString());
    }
}

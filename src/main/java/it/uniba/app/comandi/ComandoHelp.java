/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.Helper;

/**
 * @author leonardo
 * Classe ComandoHelp.
 */
public final class ComandoHelp implements Comando {
    /**
     * Implementazione di esegui che stampa l'help.
     */
    @Override
    public void esegui() {
        String help = Helper.getHelp();
        System.out.println(help);
    }
}


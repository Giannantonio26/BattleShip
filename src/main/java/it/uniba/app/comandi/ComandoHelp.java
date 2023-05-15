/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.Helper;

/**
 *
 * @author leonardo
 */

/**
  * Classe ComandoHelp
 */
public class ComandoHelp implements Comando{
    @Override
    public void esegui(){
        Helper.stampaHelp();
    }
}

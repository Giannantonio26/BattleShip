/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;


/**
 *
 * @author leonardo
 */
public class ComandoLivello implements Comando{
    
    private String nome;

    public ComandoLivello(String nome){
        this.nome = nome;
    }

    public void esegui() {
        if (Partita.isIniziata()) {
            System.out.println(
                    "Non puoi cambiare il livello di difficoltà durante una partita!");
            return;
        }
        else{
            LivelloDiGioco liv = new LivelloDiGioco();
            switch (nome) {
                case "/facile":
                    Partita.setLivello(TipoLivello.FACILE);
                    liv.setNumero_tentativi(50);
                    break;
                case "/medio":
                    Partita.setLivello(TipoLivello.MEDIO);
                    liv.setNumero_tentativi(30);
                    break;
                case "/difficile":
                    Partita.setLivello(TipoLivello.DIFFICILE);
                    liv.setNumero_tentativi(10);
                    break;
            }
            System.out.println("OK \n Livello di difficoltà attuale: "+ Partita.getLivello() +
                    "\n Tentativi disponibili: " + liv.getNumeroTentativi());
        }
    }
}

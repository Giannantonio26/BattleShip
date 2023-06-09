/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.LivelloDiGioco;
import it.uniba.app.entitaDiGioco.TipoLivello;

/**
 *
 * @author leonardo
 */
public class ComandoLivelloTentativi implements Comando {
     public String nome;
    public int tentativi;
    public ComandoLivelloTentativi(String nome, int tentativi) {
        this.nome = nome;
        this.tentativi = tentativi;
    }

     @Override
    public void esegui(){
        if (Partita.isIniziata()) {
            System.out.println("\nNon puoi cambiare il "
                    + "livello durante una partita!");
        } else {
            LivelloDiGioco liv = new LivelloDiGioco();
            switch (nome) {
                case "/facile":
                    Partita.setLivello(TipoLivello.FACILE);
                    Partita.setTentativi(tentativi);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(tentativi);
                    break;
                case "/medio":
                    Partita.setLivello(TipoLivello.MEDIO);
                    Partita.setTentativi(tentativi);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(tentativi);
                    break;
                case "/difficile":
                    Partita.setLivello(TipoLivello.DIFFICILE);
                    Partita.setTentativi(tentativi);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(tentativi);
                    break;
                default:
                    System.out.println("Livello non riconosciuto");
            }
            System.out.println("OK \n" + liv);
        }
    }
}

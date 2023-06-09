/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;

import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.TipoLivello;
import it.uniba.app.entitaDiGioco.LivelloDiGioco;

/**
 * @author leonardo
 * Classe ComandoLivello.
 */
public final class ComandoLivello implements Comando {
    private final String nome;
    static final int TENTATIVI_FACILE = 50;
    static final int TENTATIVI_MEDIO = 30;
    static final int TENTATIVI_DIFFICILE = 10;

/**
 *
 * @param comando comando passato dall'utente.
 */
    public ComandoLivello(final String comando) {
        this.nome = comando;
    }

/**
 * Implementazione del metodo esegui
 * dell'interfaccia Comando.
 */
    @Override
    public void esegui() {
        if (Partita.isIniziata()) {
            System.out.println("\nNon puoi cambiare il "
                    + "livello durante una partita!");
        } else {
            LivelloDiGioco liv = new LivelloDiGioco();
            switch (nome) {
                 case "/facile":
                    Partita.setLivello(TipoLivello.FACILE);
                    Partita.setTentativi(TENTATIVI_FACILE);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(TENTATIVI_FACILE);
                    break;
                case "/medio":
                    Partita.setLivello(TipoLivello.MEDIO);
                    Partita.setTentativi(TENTATIVI_MEDIO);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(TENTATIVI_MEDIO);
                    break;
                case "/difficile":
                    Partita.setLivello(TipoLivello.DIFFICILE);
                    Partita.setTentativi(TENTATIVI_DIFFICILE);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(TENTATIVI_DIFFICILE);
                    break;
                default:
                    System.out.println("Livello non riconosciuto");
            }
            System.out.println("OK \n" + liv);
        }
    }
}

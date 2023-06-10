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
    private static int tentativiFacile = 50;
    private static int tentativiMedio = 30;
    private static int tentativiDifficile = 10;

/**
 *
 * @param comando comando passato dall'utente.
 */
    public ComandoLivello(final String comando) {
        this.nome = comando;
    }
    
    public ComandoLivello(final String comando, final int tentativi) {
        this.nome = comando;
        switch (nome) {
            case "/facile":
                tentativiFacile = tentativi;
                break;
            case "/medio":
                tentativiMedio = tentativi;
                break;
            case "/difficile":
                tentativiDifficile = tentativi;
                break;
            default :
                System.out.print("\n Livrllo non riconosciuto.\n");
        }
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
                    Partita.setTentativi(tentativiFacile);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(tentativiFacile);
                    break;
                case "/medio":
                    Partita.setLivello(TipoLivello.MEDIO);
                    Partita.setTentativi(tentativiMedio);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(tentativiMedio);
                    break;
                case "/difficile":
                    Partita.setLivello(TipoLivello.DIFFICILE);
                    Partita.setTentativi(tentativiDifficile);
                    liv.setTipoLivello(Partita.getLivello());
                    liv.setNumeroTentativi(tentativiDifficile);
                    break;
                default:
                    System.out.println("Livello non riconosciuto");
            }
            System.out.println("OK \n" + liv);
        }
    }
}

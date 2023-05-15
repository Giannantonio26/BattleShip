/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;

/**
 * @author leonardo
 * Classe LivelloDiGioco.
 */
public final class LivelloDiGioco {
    private TipoLivello tipoLivello;
    private int numeroTentativi;
    static final int TENTATIVI_FACILE = 50;
    static final int TENTATIVI_MEDIO = 30;
    static final int TENTATIVI_DIFFICILE = 10;

/**
 * Costruttore vuoto.
 */
    public LivelloDiGioco() {

    }

/*
 * Costruttore che inizializza il livello di gioco settando
 * il numero dei tentativi in base al tipo di livello
 */

/**
 *
 * @param livello
 */
    public LivelloDiGioco(final TipoLivello livello) {
        this.tipoLivello = livello;
        switch (livello) {
            case FACILE:
                this.numeroTentativi = TENTATIVI_FACILE;
                break;
            case MEDIO:
                this.numeroTentativi = TENTATIVI_MEDIO;
                break;
            case DIFFICILE:
                this.numeroTentativi = TENTATIVI_DIFFICILE;
                break;
            default:
                break;
        }
    }

/**
 *
 * @return
 */
    public TipoLivello getTipoLivello() {
        return tipoLivello;
    }

    public void setTipoLivello(final TipoLivello tipoLivello) {
        this.tipoLivello = tipoLivello;
    }

    public int getNumeroTentativi() {
        return numeroTentativi;
    }

    public void setNumeroTentativi(int numeroTentativi) {
        this.numeroTentativi = numeroTentativi;
    }

    @Override
    public String toString() {
        return "Livello: "
                + tipoLivello
                + "\nNumero tentativi: "
                + numeroTentativi;
    }
}

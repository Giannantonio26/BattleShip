/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;

/**
 * Classe LivelloDiGioco.
 * @javadoc
 * @author leonardo
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

    /**
     * Costruttore del LivelloDiGioco passandogliene un altro.
     * @param liv
     */
    public LivelloDiGioco(final LivelloDiGioco liv) {
        this.tipoLivello = liv.tipoLivello;
        this.numeroTentativi = liv.numeroTentativi;
    }

/*
 * Costruttore che inizializza il livello di gioco settando
 * il numero dei tentativi in base al tipo di livello
 */

/**
 * Costruttore che imposta soltanto la difficoltà.
 * @param livello Livello di difficoltà
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
     * Costruttore usato per impostare anche il numero di tentativi specificato.
     * @param livello Livello di difficoltà
     * @param tentativi Numero tentativi massimi
     */
    public LivelloDiGioco(final TipoLivello livello, final int tentativi) {
        this.tipoLivello = livello;
        this.numeroTentativi = tentativi;
    }

/**
 *
 * @return
 */
    public TipoLivello getTipoLivello() {
        return tipoLivello;
    }

    public void setTipoLivello(final TipoLivello livello) {
        this.tipoLivello = livello;
    }

    public int getNumeroTentativi() {
        return numeroTentativi;
    }

    public void setNumeroTentativi(final int numeroTentativiMax) {
        this.numeroTentativi = numeroTentativiMax;
    }

    @Override
    public String toString() {
        return "Livello: "
                + tipoLivello
                + "\nNumero tentativi: "
                + numeroTentativi;
    }
}

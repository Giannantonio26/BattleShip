/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;

/**
 *
 * @author leonardo
 */

/**
  * Classe LivelloDiGioco
 */
public class LivelloDiGioco {
     private TipoLivello tipoLivello;
    private int numero_tentativi;

    public LivelloDiGioco() {

    }

    /*
        * Costruttore che inizializza il livello di gioco settando
        * il numero dei tentativi in base al tipo di livello
     */
    public LivelloDiGioco(TipoLivello tipoLivello) {
        this.tipoLivello = tipoLivello;
        switch (tipoLivello) {
            case FACILE:
                this.numero_tentativi = 50;
                break;
            case MEDIO:
                this.numero_tentativi = 30;
                break;
            case DIFFICILE:
                this.numero_tentativi = 10;
                break;
        }
    }

    public TipoLivello getTipoLivello() {
        return tipoLivello;
    }

    public void setTipoLivello(TipoLivello tipoLivello) {
        this.tipoLivello = tipoLivello;
    }

    public int getNumeroTentativi() {
        return numero_tentativi;
    }

    public void setNumero_tentativi(int numero_tentativi) {
        this.numero_tentativi = numero_tentativi;
    }

    @Override
    public String toString() {
        return "Livello: " + tipoLivello + "\nNumero tentativi: " + numero_tentativi;
    }
}

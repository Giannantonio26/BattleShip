/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import it.uniba.app.entitaDiGioco.Partita;

/**
 * 'Control'.
 * @author leonardo
 * Comando per impostare la dimensione della griglia in base a quella digitata dall'utente.
 */
public final class ComandoDimensioneGriglia implements Comando {
     private int dimensioneCampo;
     /**
      *
      * @param dimensione
      */
    public ComandoDimensioneGriglia(final String dimensione) {
        final int dimensioneStandard = 10;
        final int dimensioneLarge = 18;
        final int dimensioneExtraLarge = 26;
        switch (dimensione) {
            case "/standard":
                this.dimensioneCampo = dimensioneStandard;
                break;
            case "/large":
                this.dimensioneCampo = dimensioneLarge;
                break;
            case "/extralarge":
                this.dimensioneCampo = dimensioneExtraLarge;
                break;
            default:
                System.out.println("Dimensione non riconosciuta");
        }
    }
    /**
     *
     */
    public void esegui() {
        if (Partita.isIniziata()) {
            System.out.println("\nNon puoi cambiare la dimensione del campo durante una partita");
        } else {
            Partita.setDimensioneGriglia(dimensioneCampo);
            System.out.println("OK\nDimensione campo impostata a " + dimensioneCampo);
        }
    }
}

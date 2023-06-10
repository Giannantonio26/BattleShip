/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import it.uniba.app.entitaDiGioco.Partita;

/**
 *
 * @author leonardo
 */
public class ComandoDimensioneGriglia implements Comando {
     private int dimensioneCampo;

    public ComandoDimensioneGriglia(String dimensione) {
        switch (dimensione) {
            case "/standard":
                this.dimensioneCampo = 10;
                break;
            case "/large":
                this.dimensioneCampo = 18;
                break;
            case "/extralarge":
                this.dimensioneCampo = 26;
                break;
            default:
                System.out.println("Dimensione non riconosciuta");
        }
    }

    public void esegui() {
        if (Partita.isIniziata()) {
            System.out.println("\nNon puoi cambiare la dimensione del campo durante una partita");
        } else {
            Partita.setDimensioneGriglia(dimensioneCampo);
            System.out.println("OK\nDimensione campo impostata a " + dimensioneCampo);
        }
    }
}

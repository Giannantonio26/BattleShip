/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;
import it.uniba.app.entitaDiGioco.Partita;
import java.util.Scanner;

/**
 *
 * @author leonardo
 */
public class ComandoAbbandona implements Comando {
    @Override
    public void esegui() {
        if (!Partita.isIniziata()) {
            System.out.println("\nDevi prima iniziare una partita");
        } else {
            Scanner input = new Scanner(System.in, "UTF-8");
            System.out.println("\nSei davvero sicuro di voler abbandonare la partita in corso?\n"
                + "In caso affermativo digita 'si' altrimenti digita 'no'");
            while (input.hasNext()) {
                String risposta = input.next();
                if (risposta.equalsIgnoreCase("si")) {
                    System.out.println("\nPartita abbandonata.\nEcco la griglia di gioco iniziale:");
                    CampoDiBattaglia.svelaGriglia(CampoDiBattaglia.getCampoBattaglia());
                    Partita.setIniziata(false);
                    CampoDiBattaglia.reset();
                    return;
                } else if (risposta.equalsIgnoreCase("no")) {
                    return;
                } else {
                    System.out.println("A quanto pare hai digitato qualcosa di non valido, riprova");
                }
            }
        }
    }
}

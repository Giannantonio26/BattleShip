/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import java.util.Scanner;
import it.uniba.app.entitaDiGioco.Partita;

/**
 *
 * @author santo
 *
 */
public class ExitCommand implements Comando{
    /**
    * Questa metodo statico si occupa di gestire l'interazione con l'utente
    * nel momento in cui abbia inserito il comando /esci,
    * prima di chiudere l'applicativo viene chiesta conferma!!
    */
    @Override
    public void esegui() {
       Scanner input = new Scanner(System.in, "UTF-8");
        System.out.println("\nSei davvero sicuro di voler uscire ?\n"
                + "In caso affermativo digita 'si' altrimenti digita 'no'");
        while (input.hasNext()) {
            String risposta = input.next();
            if (risposta.equalsIgnoreCase("si")) {
                Partita.iniziata = false;
                System.exit(0);                 // termina l'esecuzione del programma
            } else if (risposta.equalsIgnoreCase("no")) {
                System.out.print("\n");
                break;                              // l'istruzione break termina l'esecuzione del ciclo pi  interno
            } else {
                System.out.println("A quanto pare hai digitato qualcosa di non valido, riprova");
            }
        }
    }
}

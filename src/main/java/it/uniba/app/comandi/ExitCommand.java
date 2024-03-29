/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import java.util.Scanner;
import it.uniba.app.entitaDiGioco.Partita;
/**
 * 'Control'.
 * @author leonardo
 * Comando per uscire dal programma.
 */
public class ExitCommand implements Comando {
/**
* Questo metodo statico si occupa di gestire l'interazione con l'utente
* nel momento in cui abbia inserito il comando /esci,
* prima di chiudere l'applicativo viene chiesta conferma.
* //@throws java.lang.RuntimeException
*/
    @Override
    public void esegui() {
        Scanner input = new Scanner(System.in, "UTF-8");
        System.out.println("\nSei davvero sicuro di voler uscire ?\n"
                + "In caso affermativo digita 'si' altrimenti digita 'no'");
        while (input.hasNext()) {
            String risposta = input.next();
            if (risposta.equalsIgnoreCase("si")) {
                Partita.setIniziata(false);
                throw new RuntimeException();
            } else if (risposta.equalsIgnoreCase("no")) {
                //System.out.print("\n");
                break;                    // L'istruzione break termina
                                          // l'esecuzione del ciclo piu interno
            } else {
                System.out.println("A quanto pare hai digitato qualcosa di non valido, riprova");
            }
        }
    }
}

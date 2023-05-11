/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import java.util.Scanner;

/**
 *
 * @author santo
 */
public final class ExitCommand {
    private ExitCommand() {
    }
    public static void confermaUscita() {
        Scanner input = new Scanner(System.in, "UTF-8");
        System.out.println("\nSei davvero sicuro di voler uscire ?\n"
                + "In caso affermativo digita 'si' altrimenti digita 'no'");
        while (input.hasNext()) {
            String risposta = input.next();
            if (risposta.equalsIgnoreCase("si")) {
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
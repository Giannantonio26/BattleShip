/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app;
import java.util.Scanner;
/**
 *
 * @author gabri
 */
public final class InputScanner {
    private InputScanner() {
    }
    public static void userInputScanner() {
        try (Scanner s = new Scanner(System.in, "UTF-8")) {
            while (s.hasNextLine()) {
                Parser parser = new Parser(s.nextLine());
                try {
                    parser.elabora();
                } catch (RuntimeException e) {
                    return;
                }
                System.out.println("\nDigita un nuovo comando: ");
            }
        }
    }
}
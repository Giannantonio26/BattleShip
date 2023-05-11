package it.uniba.app;

/**
 * Classe Parser per elaborare comandi ricevuti.
 */

public final class Parser {
    public void parse (String comando, Partita partita){
       switch (comando) {
           case "/help" -> Helper.stampaHelp();
           default -> System.out.println("Comando non valido, riprova");
       }
    }

}
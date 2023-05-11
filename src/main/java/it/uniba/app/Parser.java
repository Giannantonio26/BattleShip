package it.uniba.app;

/**
 * Classe Parser per elaborare comandi ricevuti.
 */

public final class Parser {
    public void parse (String comando, Partita p){
       switch (comando) {
           case "/help" -> Helper.stampaHelp();
           case "/facile" -> {
               Helper.conferma();
               Livello livelloDiff = Livello.FACILE;
               p.setLivelloDifficolta(livelloDiff);
           }
           case "/medio" -> {
               Helper.conferma();
               Livello livelloDiff = Livello.MEDIO;
               p.setLivelloDifficolta(livelloDiff);
           } 
           case "/difficile" -> {
               Helper.conferma();
               Livello livelloDiff = Livello.DIFFICILE;
               p.setLivelloDifficolta(livelloDiff);
           }
           
           default -> System.out.println("Comando non valido, riprova");
       }
    }

}
package it.uniba.app;

/**
 * Classe Parser per elaborare comandi ricevuti.
 */

public final class Parser {
    public void parse (String comando, Partita p){
       switch (comando) {
           case "/help" -> Helper.stampaHelp();
           case "/facile","/medio","/difficile" -> {
               Helper.conferma();
               comando = comando.replace("/", "");
               p.setLivelloDifficolta(comando);
           }

           
           default -> System.out.println("Comando non valido, riprova");
       }
    }

}
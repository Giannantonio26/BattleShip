package it.uniba.app;

import it.uniba.app.comandi.*;

/**
 * Classe Parser per elaborare comandi ricevuti.
 */

public final class Parser {
     private String comando;

    public Parser (String comando) {
        this.comando = comando;
    }

    public void elabora(){
        switch (comando) {
            // in base al comando inserito dall'utente viene creato un tipo diverso di comando con una sua implementazione
            case "/help":
                Comando help = new ComandoHelp();
                help.esegui();
                break;
            case "/facile", "/medio", "/difficile":
                Comando difficolta = new ComandoLivello(comando);
                difficolta.esegui();
                break;
            case "/gioca":
                Comando gioca = new ComandoGioca();
                gioca.esegui();
                break;
            case "/esci":
                Comando exit = new ExitCommand();
                exit.esegui();
                break;
            case "/mostranavi" :
                Comando mostranavi = new ComandoMostraNavi();
                mostranavi.esegui();
                break;
            case "/mostralivello":
                Comando mostralivello = new ComandoMostraLivello();
                mostralivello.esegui();
                break;
            case "/svelagriglia":
                Comando svelagriglia = new ComandoSvelaGriglia();
                svelagriglia.esegui();
                break;
            default:
                System.out.println("Comando non valido");
        }
    }
}

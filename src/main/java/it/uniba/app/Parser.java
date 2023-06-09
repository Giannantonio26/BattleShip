package it.uniba.app;

import it.uniba.app.comandi.Comando;
import it.uniba.app.comandi.ExitCommand;
import it.uniba.app.comandi.ComandoGioca;
import it.uniba.app.comandi.ComandoHelp;
import it.uniba.app.comandi.ComandoLivello;
import it.uniba.app.comandi.ComandoMostraLivello;
import it.uniba.app.comandi.ComandoMostraNavi;
import it.uniba.app.comandi.ComandoSvelaGriglia;
import it.uniba.app.comandi.ComandoTempo;
import it.uniba.app.comandi.ComandoLivelloTentativi;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import it.uniba.app.entitaDiGioco.Partita;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe Parser per elaborare comandi ricevuti.
 */
public final class Parser {
    private final String comando;
    /**
     * Costruttore del parser con comando digitato dall'utente.
     * @param comandoUtente comando digitato dall'utente.
     */
    public Parser(final String comandoUtente) {
        this.comando = comandoUtente;
    }

    /**
     * Metodo per l'elaborazione del comando digitato.
     * @throws java.lang.InterruptedException
     */
    public void elabora(){
        String regex = "/tempo\\s\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(comando);
        
        String regex1 = "(/facile|/medio|/difficile)\\s(\\d+)";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(comando);
        
        if (comando.equalsIgnoreCase("/help")) {
            Comando help = new ComandoHelp();
            help.esegui();
        } else if (comando.equalsIgnoreCase("/facile")||comando.equalsIgnoreCase("/medio")||comando.equalsIgnoreCase("/difficile")){
            Comando difficolta = new ComandoLivello(comando);
            difficolta.esegui();   
        } else if (comando.equalsIgnoreCase("/gioca")) {
            Comando gioca = new ComandoGioca();
            gioca.esegui();          
        } else if (comando.equalsIgnoreCase("/esci")) {
            Comando exit = new ExitCommand();
            exit.esegui();      
        } else if (comando.equalsIgnoreCase("/mostranavi")) {
            Comando mostranavi = new ComandoMostraNavi();
            mostranavi.esegui();           
        } else if (comando.equalsIgnoreCase("/mostralivello")) {
            Comando mostralivello = new ComandoMostraLivello();
            mostralivello.esegui();          
        } else if (comando.equalsIgnoreCase("/svelagriglia")) {
            Comando svelagriglia = new ComandoSvelaGriglia();
            svelagriglia.esegui();          
        } else if (matcher.find()) {
            System.out.println("OK");
            String replace = comando.replace("/tempo ", "");
            int minuti = Integer.parseInt(replace);
            Thread t = new Thread(new ComandoTempo(minuti));                   
            t.start();
         }else if (matcher1.matches()) {         
            String livello = matcher1.group(1);
            int tentativi = Integer.parseInt(matcher1.group(2));
            Comando livelloTentativi = new ComandoLivelloTentativi(livello, tentativi);
            livelloTentativi.esegui();
        } else {
            System.out.println("Comando non valido");
        }
    }
}

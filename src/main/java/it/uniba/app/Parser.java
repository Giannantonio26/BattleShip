package it.uniba.app;

import it.uniba.app.comandi.Comando;
import it.uniba.app.comandi.ExitCommand;
import it.uniba.app.comandi.ComandoGioca;
import it.uniba.app.comandi.ComandoHelp;
import it.uniba.app.comandi.ComandoLivello;
import it.uniba.app.comandi.ComandoMostraLivello;
import it.uniba.app.comandi.ComandoMostraNavi;
import it.uniba.app.comandi.ComandoMostraTempo;
import it.uniba.app.comandi.ComandoSvelaGriglia;
import it.uniba.app.comandi.ComandoTempo;
import it.uniba.app.comandi.ComandoDimensioneGriglia;
import it.uniba.app.comandi.ComandoAttacco;
import it.uniba.app.comandi.ComandoAbbandona;
import it.uniba.app.comandi.ComandoMostraGriglia;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.comandi.ComandoMostraTentativi;
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
        
        String regex2 = "(/tentativi)\\s(\\d+)";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(comando);
        
        String regex3 = "([A-Za-z])-(\\d+)";
        Pattern pattern3 = Pattern.compile(regex3);
        Matcher matcher3 = pattern3.matcher(comando);
    
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
            try{
                exit.esegui();                
            }catch(RuntimeException e){
                throw new RuntimeException();
            }
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
            String replace = comando.replace("/tempo ", "");
            int minuti = Integer.parseInt(replace);
            Comando comandoImpostaTempo = new ComandoTempo(minuti);
            comandoImpostaTempo.esegui();
        } else if (matcher1.matches()) {         
            String livello = matcher1.group(1);
            int tentativi = Integer.parseInt(matcher1.group(2));
            Comando tentativiPerLivello = new ComandoLivello(livello, tentativi);
            tentativiPerLivello.esegui();
        } else if (comando.equalsIgnoreCase("/mostratempo")) {
            Comando comandoMostraTempo = new ComandoMostraTempo();
            comandoMostraTempo.esegui();
        } else if (matcher2.matches()) {
            if(Partita.isIniziata()) {
                System.out.println("Non puoi cambiare il numero di tentativi possibili durante una partita");
            }else {
                String comandoTentativi = matcher2.group(1);
                int numTentativi = Integer.parseInt(matcher2.group(2));
                Partita.setTentativi(numTentativi);
                System.out.println("OK il numero massimo di tentativi falliti è stato impostato a "+numTentativi);
            }
        } else if (comando.equals("/standard") || comando.equals("/large") || comando.equals("/extralarge")) {
            Comando dimensioneGriglia = new ComandoDimensioneGriglia(comando);
            dimensioneGriglia.esegui();
        } else if(matcher3.matches()) {
            int coord1 = convertLetterStringToInt(matcher3.group(1));
            int coord2 = Integer.parseInt(matcher3.group(2));
            Comando comandoAttacco = new ComandoAttacco(coord1, coord2);
            comandoAttacco.esegui();
        } else if (comando.equalsIgnoreCase("/mostragriglia")) {
            Comando mostraGriglia = new ComandoMostraGriglia();
            mostraGriglia.esegui();
        } else if (comando.equalsIgnoreCase("/abbandona")) {
            Comando comandoAbbandona = new ComandoAbbandona();
            comandoAbbandona.esegui();
        } else if (comando.equalsIgnoreCase("/mostratentativi")) {
            Comando mostratentativi = new ComandoMostraTentativi();
            mostratentativi.esegui();
        }
        else {
            System.out.println("Comando non valido");
        }
    }
    
    public int convertLetterStringToInt(String letterString) {
        if (letterString.length() != 1) {
            throw new IllegalArgumentException("La stringa fornita non contiene una singola lettera.");
        }

        char letter = letterString.charAt(0);

        if (Character.isUpperCase(letter)) {
            return letter - 'A' + 1;
        } else if (Character.isLowerCase(letter)) {
            return letter - 'a' + 1;
        } else {
            throw new IllegalArgumentException("Il carattere fornito non è una lettera dell'alfabeto.");
        }
    }
}

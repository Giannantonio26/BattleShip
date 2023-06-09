package it.uniba.app;

/**
 * Classe Helper.
 */


public final class Helper {
    /**
     *Costruttore vuoto.
     */
    private Helper() {
    }
    
    private static final String comandoExtraLarge = "/extralarge:\t\tcomando che imposta la dimensione della griglia a 26x26.\n\n";
    private static final String comandoLarge = "/large:\t\t\tcomando che imposta la dimensione della griglia a 18x18.\n\n";
    private static final String comandoStandard = "/standard:\t\tcomando che imposta la dimensione della griglia a 10x10.\n\n";
    private static final String comandoFacileNumero = "/facile numero:\t\tcomando che imposta a numero il numero massimo di tentativi falliti.\n\n";
    private static final String comandoMedioNumero = "/medio numero:\t\tcomando che imposta a numero il numero massimo di tentativi falliti.\n\n";
    private static final String comandoDifficileNumero = "/difficile numero:\tcomando che imposta a numero il numero massimo di tentativi falliti.\n\n";
    private static final String comandoTentativi = "/tentativi numero:\tcomando che imposta a numero il numero massimo di tentativi.\n\n";
    private static final String comandoAbbandona = "/abbandona:\t\tcomando che permette di abbandonare la partita, se la conferma e' positiva l'applicazione risponde visualizzando sulla griglia la posizione di tutte le navi e si predispone a ricevere nuovi comandi.\n\t\t\tSe la conferma e' negativa, l'applicazione si predispone a ricevere nuovi tentativi o comandi.\n\n";
    private static final String comandoMostraTentativi = "/mostratentativi:\tcomando che mostra il numero di tentativi gia' effettuati, il numero di tentativi falliti e il numero massimo di tentativi falliti.\n\n";
    private static final String comandoMostraGriglia = "/mostragriglia:\t\tcomando che mostra una griglia con le righe numerate a partire da 1 e le colonne numerate a partire da A,\n\t\t\tcon le navi affondate e le sole parti gia' colpite delle navi non affondate.\n\n";
    private static final String comandoMostraTempo = "/mostratempo:\t\tcomando che mostra il numero di minuti trascorsi nel gioco e il numero di minuti ancora disponibili.\n\n";
    private static final String comandoTempo = "/tempo numero:\t\tcomando che imposta a numero il numero di minuti a disposizione per giocare.\n\n";
    private static final String comandoGioca = "/gioca:\t\t\tcomando per avviare la partita.\n\n";
    private static final String comandoEsci = "/esci:\t\t\tcomando per uscire dall'applicativo, verra' chiesta un'ulteriore conferma.\n\n";
    private static final String comandoFacile = "/facile:\t\tcomando per impostare il livello di difficolta' della partita a facile e 50 come numero di tentavi possibili.\n\n";
    private static final String comandoMedio = "/medio:\t\t\tcomando per impostare il livello di difficolta' della partita a medio e 30 come numero di tentavi possibili.\n\n";
    private static final String comandoDifficile = "/difficile:\t\tcomando per impostare il livello di difficolta' della partita a difficile e 10 come numero di tentavi possibili.\n\n";
    private static final String comandoMostraLivello = "/mostralivello:\t\tcomando che mostra il livello di difficolta' corrente con il numero di tentativi a disposizione.\n\n";
    private static final String comandoMostraNavi = "/mostranavi:\t\tcomando che mostra i vari tipi di nave presenti nel gioco specificando per ognuna il numero di navi presenti.\n\n";
    private static final String comandoSvelaGriglia = "/svelagriglia:\t\tcomando con il quale viene stampata la griglia della partita attuale.\n\n";
    private static String comandoHelp = "Benvenuto al gioco della battaglia navale!\n"
    + "Il tuo obiettivo è indovinare dove potrebbero essere le navi, "
    + "fornire una serie di coordinate dove colpire e cercare di abbatterle tutte "
    + "prima di esaurire i tuoi tentativi.\n"
    + "Di seguito, ecco una lista dei comandi che puoi digitare. Consultare il "
    + "manuale utente per ulteriori informazioni.\n\n"
    +comandoGioca+comandoEsci+comandoFacile+comandoMedio
    +comandoDifficile+comandoMostraLivello+comandoMostraNavi+comandoSvelaGriglia
            +comandoTempo+comandoMostraTempo+comandoMostraGriglia+comandoMostraTentativi+comandoAbbandona+comandoTentativi
            +comandoFacileNumero+comandoMedioNumero+comandoDifficileNumero+comandoStandard+comandoLarge+comandoExtraLarge;
    private static String benvenuto = "Benvenuto, per una lista dei comandi"
            + " disponibili, digita /help";
    /**
     * Stampa a schermo la descrizione del gioco seguita dalla lista dei comandi ammissibili.
     */
    public static void stampaHelp() {
       System.out.println(comandoHelp);
    }
    /**
     * Stampa a schermo la stringa 'Benvenuto' quando viene aperto il programma.
     */
    public static void stampaBenvenuto() {
        System.out.println(benvenuto);
    }
}

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
    private static final String comandoTempo = "/tempo:\t\t\tcomando per impostare il tempo di gioco, deve essere espresso in minuti\n";
    private static final String comandoGioca = "/gioca:\t\t\tcomando per avviare la partita\n";
    private static final String comandoEsci = "/esci:\t\t\tcomando per uscire dall'applicativo, verra' chiesta un'ulteriore conferma\n";
    private static final String comandoFacile = "/facile:\t\tcomando per impostare il livello di difficolta' della partita a facile e 50 come numero di tentavi possibili\n";
    private static final String comandoMedio = "/medio:\t\t\tcomando per impostare il livello di difficolta' della partita a medio e 30 come numero di tentavi possibili\n";
    private static final String comandoDifficile = "/difficile:\t\tcomando per impostare il livello di difficolta' della partita a difficile e 10 come numero di tentavi possibili\n";
    private static final String comandoMostraLivello = "/mostralivello:\t\tcomando che mostra il livello di difficolta' corrente con il numero di tentativi a disposizione\n";
    private static final String comandoMostraNavi = "/mostranavi:\t\tcomando che mostra i vari tipi di nave presenti nel gioco specificando per ognuna il numero di navi presenti\n";
    private static final String comandoSvelaGriglia = "/svelagriglia:\t\tcomando con il quale viene stampata la griglia della partita attuale\n";
    private static String comandoHelp = "Benvenuto al gioco della battaglia navale!\n"
    + "Il tuo obiettivo è indovinare dove potrebbero essere le navi, "
    + "fornire una serie di coordinate dove colpire e cercare di abbatterle tutte "
    + "prima di esaurire i tuoi tentativi.\n"
    + "Di seguito, ecco una lista dei comandi che puoi digitare. Consultare il "
    + "manuale utente per ulteriori informazioni.\n"
    +comandoGioca+comandoEsci+comandoFacile+comandoMedio
    +comandoDifficile+comandoMostraLivello+comandoMostraNavi+comandoSvelaGriglia
            +comandoTempo;
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

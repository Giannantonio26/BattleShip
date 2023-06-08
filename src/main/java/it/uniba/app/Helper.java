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
    private static String comandoHelp = "Benvenuto al gioco della battaglia navale!\n"
    + "Il tuo obiettivo è indovinare dove potrebbero essere le navi, "
    + "fornire una serie di coordinate dove colpire e cercare di abbatterle tutte "
    + "prima di esaurire i tuoi tentativi.\n"
    + "Di seguito, ecco una lista dei comandi che puoi digitare. Consultare il "
    + "manuale utente per ulteriori informazioni.\n"
    + "/gioca\n/esci\n/facile\n/medio\n/difficile\n/mostralivello\n"
    + "/mostranavi\n/svelagriglia\n/tempo *numero*\n";
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

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
    private static String comandoHelp = "Descrizione concisa del gioco e"
            + " lista di comandi disponibili";
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
    /**
     * Stampa a schermo la scritta 'OK'.
     */
    public static void conferma() {
        System.out.println("OK");
    }
}

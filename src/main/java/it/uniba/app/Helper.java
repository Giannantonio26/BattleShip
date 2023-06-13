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
    private static final String COMANDO_TENTATIVI = "/tentativi numero:\tcomando"
            + " che imposta a numero il numero massimo di tentativi.\n\n";
    private static final String COMANDO_EXTRALARGE = "/extralarge:\t\t"
            + "comando che imposta la dimensione della griglia a 26x26.\n\n";
    private static final String COMANDO_LARGE = "/large:\t\t\t"
            + "comando che imposta la dimensione della griglia a 18x18.\n\n";
    private static final String COMANDO_STANDARD = "/standard:\t\t"
            + "comando che imposta la dimensione della griglia a 10x10.\n\n";
    private static final String COMANDO_FACILE_NUMERO = "/facile numero:\t\t"
            + "comando che imposta a numero il numero massimo di tentativi falliti.\n\n";
    private static final String COMANDO_MEDIO_NUMERO = "/medio numero:\t\t"
            + "comando che imposta a numero il numero massimo di tentativi falliti.\n\n";
    private static final String COMANDO_DIFFICILE_NUMERO = "/difficile numero:\t"
            + "comando che imposta a numero il numero massimo di tentativi falliti.\n\n";
    private static final String COMANDO_ABBANDONA = "/abbandona:\t\t"
            + "comando che permette di abbandonare la partita, se la conferma e' positiva "
            + "l'applicazione risponde visualizzando sulla griglia la posizione"
            + " di tutte le navi e si predispone a ricevere nuovi comandi.\n\t\t\t"
            + "Se la conferma e' negativa, l'applicazione "
            + "si predispone a ricevere nuovi tentativi o comandi.\n\n";
    private static final String COMANDO_MOSTRATENTATIVI = "/mostratentativi:\t"
            + "comando che mostra il numero di tentativi gia' effettuati, "
            + "il numero di tentativi falliti e il numero massimo di tentativi falliti.\n\n";
    private static final String COMANDO_MOSTRAGRIGLIA = "/mostragriglia:\t\t"
            + "comando che mostra una griglia"
            + " con le righe numerate a partire da 1 e le colonne numerate"
            + " a partire da A,\n\t\t\tcon le navi affondate "
            + "e le sole parti gia' colpite delle navi non affondate.\n\n";
    private static final String COMANDO_MOSTRATEMPO = "/mostratempo:\t\t"
            + "comando che mostra il numero di minuti trascorsi"
            + " nel gioco e il numero di minuti ancora disponibili.\n\n";
    private static final String COMANDO_TEMPO = "/tempo numero:\t\t"
            + "comando che imposta a numero il numero"
            + " di minuti a disposizione per giocare.\n\n";
    private static final String COMANDO_GIOCA = "/gioca:\t\t\t"
            + "comando per avviare la partita.\n\n";
    private static final String COMANDO_ESCI = "/esci:\t\t\t"
            + "comando per uscire dall'applicativo, verra' chiesta un'ulteriore conferma.\n\n";
    private static final String COMANDO_FACILE = "/facile:\t\t"
            + "comando per impostare il livello di difficolta' della partita"
            + " a facile e 50 come numero di tentavi possibili.\n\n";
    private static final String COMANDO_MEDIO = "/medio:\t\t\t"
            + "comando per impostare il livello di difficolta' della partita"
            + " a medio e 30 come numero di tentavi possibili.\n\n";
    private static final String COMANDO_DIFFICILE = "/difficile:\t\t"
            + "comando per impostare il livello di difficolta' della partita"
            + " a difficile e 10 come numero di tentavi possibili.\n\n";
    private static final String COMANDO_MOSTRA_LIVELLO = "/mostralivello:\t\t"
            + "comando che mostra il livello di difficolta'"
            + " corrente con il numero di tentativi a disposizione.\n\n";
    private static final String COMANDO_MOSTRA_NAVI = "/mostranavi:\t\t"
            + "comando che mostra i vari tipi di nave presenti nel gioco"
            + " specificando per ognuna il numero di navi presenti.\n\n";
    private static final String COMANDO_SVELA_GRIGLIA = "/svelagriglia:\t\t"
            + "comando con il quale viene stampata la griglia della partita attuale.\n\n";
    private static String comandoHelp = "Benvenuto al gioco della battaglia navale!\n"
    + "Il tuo obiettivo è indovinare dove potrebbero essere le navi, "
    + "fornire una serie di coordinate dove colpire e cercare di abbatterle tutte "
    + "prima di esaurire i tuoi tentativi.\n"
    + "Di seguito, ecco una lista dei comandi che puoi digitare. Consultare il "
    + "manuale utente per ulteriori informazioni.\n\n"
    + COMANDO_GIOCA + COMANDO_ESCI + COMANDO_FACILE + COMANDO_MEDIO
    + COMANDO_DIFFICILE + COMANDO_MOSTRA_LIVELLO + COMANDO_MOSTRA_NAVI
    + COMANDO_SVELA_GRIGLIA
    + COMANDO_TEMPO + COMANDO_MOSTRATEMPO + COMANDO_MOSTRAGRIGLIA
    + COMANDO_MOSTRATENTATIVI + COMANDO_ABBANDONA + COMANDO_TENTATIVI
    + COMANDO_FACILE_NUMERO + COMANDO_MEDIO_NUMERO + COMANDO_DIFFICILE_NUMERO
    + COMANDO_STANDARD + COMANDO_LARGE + COMANDO_EXTRALARGE;
    private static String benvenuto = "Benvenuto, per una lista dei comandi"
            + " disponibili, digita /help";
    /**
     * Stampa a schermo la descrizione del gioco seguita dalla lista dei comandi ammissibili.
     */
    public static String getHelp() {
       return comandoHelp;
    }
    /**
     * Stampa a schermo la stringa 'Benvenuto' quando viene aperto il programma.
     */
    public static String getBenvenuto() {
        return benvenuto;
    }
}

package it.uniba.app.entitaDiGioco;

import java.util.List;

/**
 * 'Entity'.
 *  Classe Partita contenente i parametri della partita in corso, come dimensione griglia,
 * numero tentativi, campo di battaglia, tempo di gioco e difficoltà.
 */
public final class Partita {
    private static final int NUMERO_TENTATIVI = 50;
    private static final int DIMENSIONE_GRIGLIA = 10;
    private static CampoDiBattaglia campo;
    private static TipoLivello livello = TipoLivello.FACILE;
    private static int tentativi = NUMERO_TENTATIVI;
    private static int minutiDiGioco; //numero di minuti a disposizione per giocare
    private static int minutiTrascorsi; //numero di minuti che sono trascorsi
    private static boolean iniziata = false;
    private static boolean tempoDiGiocoAttivo = false;
    private static int dimensioneGriglia = DIMENSIONE_GRIGLIA;
    private static int tentativiEffettuati = 0;
    public static final List<LivelloDiGioco> LIVELLI = List.of(
        new LivelloDiGioco(TipoLivello.FACILE),
        new LivelloDiGioco(TipoLivello.MEDIO),
        new LivelloDiGioco(TipoLivello.DIFFICILE)
    );
    private Partita() {
    }

/**
 * Inizializza lista di navi.
 */
    public static final List<Nave> NAVIINGIOCO = List.of(
        new Nave(2),
        new Nave(3),
        new Nave(4),
        new Nave(5)
    );

/**
 *
 * @return
 */
    public static CampoDiBattaglia getCampo() {
        return campo;
    }
    public static int getTentativiEffettuati() {
        return tentativiEffettuati;
    }

    public static void setTentativiEffettuati(final int tentEffettuati) {
        Partita.tentativiEffettuati = tentEffettuati;
    }
/**
 *
 * @param campoDiBattaglia
 */
    public static void setCampo(final CampoDiBattaglia campoDiBattaglia) {
        campo = campoDiBattaglia;
    }

/**
 *
 * @return
 */
    public static TipoLivello getLivello() {
        return livello;
    }

    public static int getTentativi() {
        return tentativi;
    }

    public static void setTentativi(final int tent) {
        Partita.tentativi = tent;
    }

    public static int getDimensioneGriglia() {
        return dimensioneGriglia;
    }

    public static void setDimensioneGriglia(final int dimGriglia) {
        Partita.dimensioneGriglia = dimGriglia;
    }

/**
 *
 * @param liv
 */
    public static void setLivello(final TipoLivello liv) {
        Partita.livello = liv;
    }

/**
 *
 * @return
 */
    public static boolean isIniziata() {
        return iniziata;
    }

/**
 *
 * @param isIniziata
 */
    public static void setIniziata(final boolean isIniziata) {
        Partita.iniziata = isIniziata;
    }
/**
 * metodo mostraNavi.
 */
    public static void mostraNavi() {
        System.out.println("Navi in gioco: \n");
        for (Nave nave : NAVIINGIOCO) {
            System.out.println(nave.toString());
        }
    }
    public static void setMinutDiGioco(final int minuti) {
        minutiDiGioco = minuti;
    }
    public static int getMinutiDiGioco() {
        return minutiDiGioco;
    }
    public static void setMinutiTrascorsi(final int minuti) {
        minutiTrascorsi = minuti;
    }
    public static int getMinutiTrascorsi() {
        return minutiTrascorsi;
    }
    public static void setTempoDiGioco(final boolean b) {
        tempoDiGiocoAttivo = b;
    }
    public static boolean isTempoDiGiocoAttivo() {
        return tempoDiGiocoAttivo;
    }
}

package it.uniba.app.entitaDiGioco;

import java.util.List;

/**
 *  Classe partita.
 */
public final class Partita {
    private static CampoDiBattaglia campo;
    private static TipoLivello livello = TipoLivello.FACILE;
    private static int minutiDiGioco; //numero di minuti a disposizione per giocare
    private static int minutiTrascorsi; //numero di minuti che sono trascorsi
    private static boolean iniziata = false;
    
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
    
    public static void setMinutDiGioco(final int minuti){
        minutiDiGioco = minuti;
    }
    
    public static int getMinutiDiGioco(){
        return minutiDiGioco;
    }
    
    public static void setMinutiTrascorsi(int minuti){
        minutiTrascorsi = minuti;
    }
    
    public static int getMinutiTrascorsi(){
        return minutiTrascorsi;
    }
    
}

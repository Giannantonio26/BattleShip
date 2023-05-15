package it.uniba.app.entitaDiGioco;

import java.util.List;

/**
 *  Classe partita.
 */
public final class Partita {
    private static CampoDiBattaglia campo;
    private static TipoLivello livello = TipoLivello.FACILE;

    public static final List<LivelloDiGioco> livelli = List.of(
        new LivelloDiGioco(TipoLivello.FACILE),
        new LivelloDiGioco(TipoLivello.MEDIO),
        new LivelloDiGioco(TipoLivello.DIFFICILE)
    );
    private static boolean iniziata = false;

/**
 * Inizializza lista di navi.
 */
    public static final List<Nave> naviInGioco = List.of(
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
 * @param livello
 */
    public static void setLivello(final TipoLivello livello) {
        Partita.livello = livello;
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
        for (Nave nave : naviInGioco) {
            System.out.println(nave.toString());
        }
    }
}

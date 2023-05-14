package it.uniba.app.entitaDiGioco;

import it.uniba.app.entitaDiGioco.TipoLivello;

/**
 *  Classe partita.
 */
public class Partita {
    public static CampoDiBattaglia campo;
    public static TipoLivello livello = TipoLivello.FACILE;

    public static final List<LivelloDiGioco> livelli = List.of(
        new LivelloDiGioco(TipoLivello.FACILE),
        new LivelloDiGioco(TipoLivello.MEDIO),
        new LivelloDiGioco(TipoLivello.DIFFICILE)
    );
    public static boolean iniziata = false;

    public static final List<Nave> navi_in_gioco = List.of(
        new Nave(2),
        new Nave(3),
        new Nave(4),
        new Nave(5)
    );
    public static CampoDiBattaglia getCampo() {
        return campo;
    }
    public static void setCampo(CampoDiBattaglia campoDiBattaglia) {
        campo = campoDiBattaglia;
    }

    public static TipoLivello getLivello() {
        return livello;
    }

    public static void setLivello(TipoLivello livello) {
        Partita.livello = livello;
    }

    public static boolean isIniziata() {
        return iniziata;
    }

    public static void mostraNavi(){
        System.out.println("Navi in gioco: \n");
        for(Nave nave : navi_in_gioco){
            System.out.println(nave.toString());
        }
    }
}

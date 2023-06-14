/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;

/**
 * 'Entity'.
 * @author leonardo
 * Classe CampoDiBattaglia, contiene la griglia di gioco, la lista delle navi,
 * il livello della partita con relativi parametri.
 * Da questa classe parte l'inizio di una nuova partita con l'inizializzazione del campo,
 * il popolamento con le navi.
 * Contiene inoltre metodi per mostrare a schermo la griglia di gioco.
 */
public final class CampoDiBattaglia {
    private static final Map<Coord, Nave> CAMPO_BATTAGLIA = new HashMap<>();
    static final List<Nave> NAVI = new ArrayList<>();
    private final Random random = new Random();
    private static LivelloDiGioco livelloPartita;
    private static int naviAffondate = 0;
    private static final int NUM = 10;

    private static final int ES2 = 4;
    private static final int ES3 = 3;
    private static final int ES4 = 2;
    private static final int ES5 = 1;

    private static int esemplari2 = ES2;
    private static int esemplari3 = ES3;
    private static int esemplari4 = ES4;
    private static int esemplari5 = ES5;

    static final int MIN_COORD = 1;
    static final int DIMENSIONE2 = 2;
    static final int DIMENSIONE3 = 3;
    static final int DIMENSIONE4 = 4;
    static final int DIMENSIONE5 = 5;

    /**
     *il costruttore assegna il livello di gioco, utile per il controllo
     *dei tentativi rimasti e inizializza il campo di battaglia.
     * @param livello Livello di gioco
     */

    public CampoDiBattaglia(final TipoLivello livello, final int tentativi) {
        CampoDiBattaglia.livelloPartita = new LivelloDiGioco(livello, tentativi);
    }
     public static LivelloDiGioco getLivelloPartita() {
        return new LivelloDiGioco(livelloPartita);
    }
    public static Map<Coord, Nave> getCampoBattaglia() {
        return new HashMap(CAMPO_BATTAGLIA);
    }
    public static int getNaviAffondate() {
        return naviAffondate;
    }
    public static void setNaviAffondate(final int naviAff) {
        CampoDiBattaglia.naviAffondate = naviAff;
    }

    public static int getEsemplari2() {
        return esemplari2;
    }

    public static void setEsemplari2(final int es2) {
        CampoDiBattaglia.esemplari2 = es2;
    }

    public static int getEsemplari3() {
        return esemplari3;
    }

    public static void setEsemplari3(final int es3) {
        CampoDiBattaglia.esemplari3 = es3;
    }

    public static int getEsemplari4() {
        return esemplari4;
    }

    public static void setEsemplari4(final int es4) {
        CampoDiBattaglia.esemplari4 = es4;
    }

    public static int getEsemplari5() {
        return esemplari5;
    }

    public static void setEsemplari5(final int es5) {
        CampoDiBattaglia.esemplari5 = es5;
    }

    /**
     * Metodo getNavi per avere la lista delle Navi.
     * Restituisce una nuova lista creata a partire dall'attributo NAVI, per non esporre rappresentazione interna.
     * @return
     */
    public static List<Nave> getNAVI() {
        List<Nave> listaNavi = new ArrayList<>(NAVI);
        return listaNavi;
    }

    /**
     * Metodo di aggiunta nave al vettore NAVI.
     * Creato principalmente a fini di testing.
     * @param n nave
     */
    public static void aggiungiNave(final Nave n) {
        NAVI.add(n);
    }

    /**
     * Metodo per posizionare una nave nella griglia campo di battaglia
     * alle coordinate fornite.
     * @param colonna
     * @param riga
     * @param n
     */
    public void posizionaNaveInCoordinata(final int colonna, final int riga, final Nave n) {
        CAMPO_BATTAGLIA.put(new Coord(colonna, riga), n);
        n.aggiungiPosizione(new Coord(colonna, riga));
    }

    /**
     * Inizio nuova partita.
     */
    public void nuovaPartita() {
        Partita.setIniziata(true);
        inizializzaCampo();
        inizializzaNavi();
        posizionaNavi();
        mostraGrigliaVuota();
    }

    /*
    il metodo inizializzaCampo() inizializza la mappa campo di battaglia
    inserendo come chiave le coordinate e come valore null.
     */
    /**
     * Metodo inizializzaCampo.
     */
    public void inizializzaCampo() {
        for (int i = 1; i < Partita.getDimensioneGriglia() + 1; i++) {
            for (int j = 1; j < Partita.getDimensioneGriglia() + 1; j++) {
                CAMPO_BATTAGLIA.put(new Coord(i, j), null);
            }
        }
    }

    /*
    il metodo inizializzaNavi() inizializza la lista di navi
    secondo i requisiti del gioco.
     */
    /**
     * Metodo inizializzaNavi.
     */
    public void inizializzaNavi() {
        NAVI.add(new Nave(DIMENSIONE2));
        NAVI.add(new Nave(DIMENSIONE2));
        NAVI.add(new Nave(DIMENSIONE2));
        NAVI.add(new Nave(DIMENSIONE2));
        NAVI.add(new Nave(DIMENSIONE3));
        NAVI.add(new Nave(DIMENSIONE3));
        NAVI.add(new Nave(DIMENSIONE3));
        NAVI.add(new Nave(DIMENSIONE4));
        NAVI.add(new Nave(DIMENSIONE4));
        NAVI.add(new Nave(DIMENSIONE5));
    }

    /*
    il metodo posizionaNavi() genera casualmente le coordinate e l'orientamento
    di ogni nave e le posiziona sul campo di battaglia dopo aver controllato che
    non ci siano collisioni con altre navi chiamando il metodo posizionaNave().
     */

    /**
     * metodo posizionaNavi.
     */
    public void posizionaNavi() {
        for (Nave nave : NAVI) {
            boolean posizionata = false;
            while (!posizionata) {
                int colonna = random.nextInt(MIN_COORD, Partita.getDimensioneGriglia());
                int riga = random.nextInt(MIN_COORD, Partita.getDimensioneGriglia());
                boolean orizzontale = random.nextBoolean();

                if (posizionaNave(nave, colonna, riga, orizzontale)) {
                    posizionata = true;
                    for (int i = 0; i < nave.getDimensione(); i++) {
                        if (orizzontale) {
                            CAMPO_BATTAGLIA.put(new Coord(colonna, riga + i), nave);
                            nave.aggiungiPosizione(new Coord(colonna, riga + i));
                        }   else {
                            CAMPO_BATTAGLIA.put(new Coord(colonna + i, riga), nave);
                            nave.aggiungiPosizione(new Coord(colonna + i, riga));
                            }
                    }
                }
            }
        }
    }

    /*
     * il metodo posizionaNave() controlla se la nave può essere posizionata.
     */

    /**
     *
     * @param nave
     * @param colonna
     * @param riga
     * @param orizzontale
     * @return booleano.
     */
    public boolean posizionaNave(final Nave nave, final int colonna, final int riga, final boolean orizzontale) {
        if (orizzontale) {
            //questo if serve per controllare che la nave non esca dal campo
            if (riga + nave.getDimensione() > Partita.getDimensioneGriglia()) {
                return false;
            }

            // questo ciclo for controlla se le posizioni
            // che dovrà occupare la nave sono libere.
            for (int i = riga; i < riga + nave.getDimensione(); i++) {
                Coord coord = new Coord(colonna, i);
                if (CAMPO_BATTAGLIA.get(coord) != null) {
                    return false;
                }
            }
        } else {                                         //caso verticale

            //questo if serve per controllare che la nave non esca dal campo
            if (colonna + nave.getDimensione() > Partita.getDimensioneGriglia()) {
                return false;
            }

            // questo ciclo for controlla se le posizioni
            // che dovrà occupare la nave sono libere
            for (int i = colonna; i < colonna + nave.getDimensione(); i++) {
                Coord coord = new Coord(i, riga);
                if (CAMPO_BATTAGLIA.get(coord) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param campo campo di battaglia
     */
    public static void svelaGriglia(final Map<Coord, Nave> campo) {
        System.out.print("    ");
        for (int i = 0; i < Partita.getDimensioneGriglia(); i++) {
            char letteraColonna = (char) ('A' + i);
            System.out.print(letteraColonna + "\t");
        }
        System.out.println();
        for (int i = 1; i <= Partita.getDimensioneGriglia(); i++) {
            if (i < NUM) {
                System.out.print(i + "   ");
                svelaRiga(i, campo);
                System.out.println();
            } else {
                System.out.print(i + "  ");
                svelaRiga(i, campo);
                System.out.println();
            }
        }
    }

    /**
     *
     * @param riga coordinata colonna
     * @param campoBattaglia campo di battaglia
     */
    public static void svelaRiga(final int riga, final Map<Coord, Nave> campoBattaglia) {
        for (int i = 1; i <= Partita.getDimensioneGriglia(); i++) {
            Coord coord = new Coord(riga, i);
            if (campoBattaglia.get(coord) == null) {
                System.out.print("\u25A2\t");
            } else {
                System.out.print(campoBattaglia.get(coord).stampaQuadratoColorato());
            }
        }
    }
    /**
     * Metodo per mostrare il campo di battaglia vuoto, senza navi.
     */
    public void mostraGrigliaVuota() {
        System.out.print("    ");
        for (int i = 0; i < Partita.getDimensioneGriglia(); i++) {
            char letteraColonna = (char) ('A' + i);
            System.out.print(letteraColonna + "\t");
        }
        System.out.println();
        for (int i = 1; i < Partita.getDimensioneGriglia() + 1; i++) {
            if (i < NUM) {
                System.out.print(i + "   " + stampaRigaVuota() + "\n");
            } else {
                System.out.print(i + "  " + stampaRigaVuota() + "\n");
            }
        }
        System.out.println("\nNumero tentativi rimasti: " + livelloPartita.getNumeroTentativi());
    }

    /**
     *
     * @return Restituisce una colonna di puntini da usare in mostraGrigliaVuota.
     */
    public String stampaRigaVuota() {
        String riga = "";
        for (int i = 0; i < Partita.getDimensioneGriglia(); i++) {
            riga = riga + "\u25A2\t";
        }
        return riga;
    }

    /**
     * Metodo che mostra a schermo la griglia di gioco aggiornata all'ultimo tentativo effettuato.
     */
    public static void mostraGrigliaAggiornata() {
        System.out.println("\n Tentativi Rimasti ---> " + livelloPartita.getNumeroTentativi());
        System.out.print("    ");
        for (int i = 0; i < Partita.getDimensioneGriglia(); i++) {
            char letteraColonna = (char) ('A' + i);
            System.out.print(letteraColonna + "\t");
        }
        System.out.println();
        for (int i = 1; i <= Partita.getDimensioneGriglia(); i++) {
            if (i >= Partita.getDimensioneGriglia()) {
                System.out.print(i + "  ");
                svelaRigaAggiornata(i, CAMPO_BATTAGLIA);
                System.out.println();
                break;
            } else {
                System.out.print(i + "   ");
                svelaRigaAggiornata(i, CAMPO_BATTAGLIA);
                System.out.println();
            }
        }
    }

    /**
     * Metodo usato da @see it.uniba.app.entitaDiGioco.CampoDiBattaglia#mostraGrigliaAggiornata()
     * per mostrare ogni riga aggiornata della griglia.
     * @param riga
     * @param campobattaglia
     */
    public static void svelaRigaAggiornata(final int riga, final Map<Coord, Nave> campobattaglia) {
        for (int i = 1; i <= Partita.getDimensioneGriglia(); i++) {
            Coord coord = new Coord(riga, i);
            if (campobattaglia.get(coord) == null
                || !(campobattaglia.get(coord).isColpita(coord))) {
                System.out.print("\u25A2\t");
            } else if (campobattaglia.get(coord).isColpita(coord)
                    || campobattaglia.get(coord).isAffondata()) {
                System.out.print(campobattaglia.get(coord).stampaQuadratoColorato());
            }
        }
    }

    /**
     * Metodo per resettare tutto ci� che riguarda il campo di battaglia e la partita.
     */
    public static void reset() {
        CAMPO_BATTAGLIA.clear();
        NAVI.clear();
        naviAffondate = 0;
        Partita.setTentativiEffettuati(0);
        if (Partita.isTempoDiGiocoAttivo()) {
            Partita.setMinutiTrascorsi(0);
        }
        esemplari2 = DIMENSIONE4;
        esemplari3 = DIMENSIONE3;
        esemplari4 = DIMENSIONE2;
        esemplari5 = 1;
    }
}

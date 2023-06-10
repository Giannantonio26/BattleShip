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
 * @author leonardo
 * Classe CampoDiBattaglia.
 */
public final class CampoDiBattaglia {
    private final Map<Coord, Nave> campoBattaglia = new HashMap<>();
    static final List<Nave> NAVI = new ArrayList<>();
    private final Random random = new Random();
    private LivelloDiGioco livelloPartita;

    static final int MIN_COORD = 1;
    static final int DIMENSIONE2 = 2;
    static final int DIMENSIONE3 = 3;
    static final int DIMENSIONE4 = 4;
    static final int DIMENSIONE5 = 5;

    /*
     il costruttore assegna il livello di gioco, utile per il controllo
     dei tentativi rimasti e inizializza il campo di battaglia.
     */
    /**
     *
     * @param livello Livello di gioco
     * @param tentativi.
     */

    public CampoDiBattaglia(TipoLivello livello, int tentativi) {
        this.livelloPartita = new LivelloDiGioco(livello, tentativi);
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

    /**
     *
     * @return campo di battaglia.
     */
    public Map<Coord, Nave> getCampoBattaglia() {
        return new HashMap(campoBattaglia);
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
                campoBattaglia.put(new Coord(i, j), null);
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
                int riga = random.nextInt(MIN_COORD, Partita.getDimensioneGriglia());
                int colonna = random.nextInt(MIN_COORD, Partita.getDimensioneGriglia());
                boolean orizzontale = random.nextBoolean();

                if (posizionaNave(nave, riga, colonna, orizzontale)) {
                    posizionata = true;
                    for (int i = 0; i < nave.getDimensione(); i++) {
                        if (orizzontale) {
                            campoBattaglia.put(new Coord(riga, colonna + i), nave);
                            nave.aggiungiPosizione(new Coord(riga, colonna + i));
                        }   else {
                            campoBattaglia.put(new Coord(riga + i, colonna), nave);
                            nave.aggiungiPosizione(new Coord(riga + i, colonna));
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
     * @param riga
     * @param colonna
     * @param orizzontale
     * @return booleano.
     */
    public boolean posizionaNave(final Nave nave, final int riga, final int colonna, final boolean orizzontale) {
        if (orizzontale) {
            //questo if serve per controllare che la nave non esca dal campo
            if (colonna + nave.getDimensione() > Partita.getDimensioneGriglia()) {
                return false;
            }

            // questo ciclo for controlla se le posizioni
            // che dovrà occupare la nave sono libere.
            for (int i = colonna; i < colonna + nave.getDimensione(); i++) {
                Coord coord = new Coord(riga, i);
                if (campoBattaglia.get(coord) != null) {
                    return false;
                }
            }
        } else {                                         //caso verticale

            //questo if serve per controllare che la nave non esca dal campo
            if (riga + nave.getDimensione() > Partita.getDimensioneGriglia()) {
                return false;
            }

            // questo ciclo for controlla se le posizioni
            // che dovrà occupare la nave sono libere
            for (int i = riga; i < riga + nave.getDimensione(); i++) {
                Coord coord = new Coord(i, colonna);
                if (campoBattaglia.get(coord) != null) {
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
        for(int i = 0; i < Partita.getDimensioneGriglia(); i++) {
            char letteraColonna = (char) ('A' + i);
            System.out.print(letteraColonna + "\t");
        }
        System.out.println();
        for (int i = 1; i <= Partita.getDimensioneGriglia(); i++) {
            if (i < 10) {
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
     * @param riga coordinata riga
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
        for(int i = 0; i < Partita.getDimensioneGriglia(); i++) {
            char letteraColonna = (char) ('A' + i);
            System.out.print(letteraColonna + "\t");
        }
        System.out.println();
        for (int i = 1; i < Partita.getDimensioneGriglia() + 1; i++) {
            if (i < 10) {
                System.out.print(i + "   " + stampaRigaVuota() + "\n");
            } else {
                System.out.print(i + "  " + stampaRigaVuota() + "\n");
            }
        }
        System.out.println("\nNumero tentativi rimasti: " + livelloPartita.getNumeroTentativi());
    }

    /**
     *
     * @return Restituisce una riga di puntini da usare in mostraGrigliaVuota.
     */
    public String stampaRigaVuota() {
        String riga = "";
        for (int i = 0; i < Partita.getDimensioneGriglia(); i++) {
            riga = riga +"\u25A2\t";
        }
        return riga;
    }
}

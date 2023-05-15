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
 *
 * @author leonardo
 */

/**
 * Classe CampoDiBattaglia.
 */
public class CampoDiBattaglia {
    private final Map<Coord, Nave> campo_battaglia = new HashMap<>();
    protected static final List<Nave> navi = new ArrayList<>();  
    private final Random random = new Random();
    private LivelloDiGioco livelloPartita;

    static final int DIM_CAMPO = 10;
    static final int MIN_COORD = 1;
    static final int MAX_COORD = 10;
    
    static final int DIMENSIONE2 = 2;
    static final int DIMENSIONE3 = 3;
    static final int DIMENSIONE4 = 4;
    static final int DIMENSIONE5 = 5;

    /*
     il costruttore assegna il livello di gioco, utile per il controllo
     dei tentativi rimasti e inizializza il campo di battaglia
     */
    /**
     *
     * @param livello Livello di gioco.
     */
    public CampoDiBattaglia(TipoLivello livello) {
        this.livelloPartita = new LivelloDiGioco(livello);
    }

    /**
     * Inizio nuova partita.
     */
    public void nuovaPartita() {
        Partita.setIniziata(true);
        inizializzaCampo();
        inizializzaNavi();
        posizionaNavi();
        mostraGriliaVuota();
    }

    /**
     *
     * @return campo di battaglia.
     */
    public Map<Coord, Nave> getCampo_battaglia() {
        return campo_battaglia;
    }

    /*
    il metodo inizializzaCampo() inizializza la mappa campo di battaglia
    inserendo come chiave le coordinate e come valore null
     */
    /**
     * Metodo inizializzaCampo.
     */
    public void inizializzaCampo() {
        for (int i = 1; i < DIM_CAMPO + 1; i++) {
            for (int j = 1; j < DIM_CAMPO + 1; j++) {
                campo_battaglia.put(new Coord(i, j), null);
            }
        }
    }

    /*
    il metodo inizializzaNavi() inizializza la lista di navi
    secondo i requisiti del gioco
     */
    /**
     * Metodo inizializzaNavi.
     */
    public void inizializzaNavi() {
        navi.add(new Nave(DIMENSIONE2));
        navi.add(new Nave(DIMENSIONE2));
        navi.add(new Nave(DIMENSIONE2));
        navi.add(new Nave(DIMENSIONE2));
        navi.add(new Nave(DIMENSIONE3));
        navi.add(new Nave(DIMENSIONE3));
        navi.add(new Nave(DIMENSIONE3));
        navi.add(new Nave(DIMENSIONE4));
        navi.add(new Nave(DIMENSIONE4));
        navi.add(new Nave(DIMENSIONE5));
    }

    /*
    il metodo posizizionaNavi() genera casualmente le coordinate e l'orientamento
    di ogni nave e le posiziona sul campo di battaglia dopo aver controllato che
    non ci siano collisioni con altre navi chiamando il metodo posizionaNave().
     */

    /**
     * metodo posizionaNavi.
     */
    public void posizionaNavi() {
        for (Nave nave : navi) {
            boolean posizionata = false;
            while (!posizionata) {
                int riga = random.nextInt(MIN_COORD, MAX_COORD);
                int colonna = random.nextInt(MIN_COORD, MAX_COORD);
                boolean orizzontale = random.nextBoolean();

                if (posizionaNave(nave, riga, colonna, orizzontale)) {
                    posizionata = true;
                    for (int i = 0; i < nave.getDimensione(); i++) {
                        if (orizzontale) {
                            campo_battaglia.put(new Coord(riga, colonna + i), nave);
                            nave.aggiungiPosizione(new Coord(riga, colonna + i));
                            }
                        else {
                            campo_battaglia.put(new Coord(riga + i, colonna), nave);
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
            if (colonna + nave.getDimensione() > DIM_CAMPO) {
                return false;
            }

            // questo ciclo for controlla se le posizioni
            // che dovrà occupare la nave sono libere.
            for (int i = colonna; i < colonna + nave.getDimensione(); i++) {
                Coord coord = new Coord(riga, i);
                if (campo_battaglia.get(coord) != null) {
                    return false;
                }
            }
        } else {                                         //caso verticale

            //questo if serve per controllare che la nave non esca dal campo
            if (riga + nave.getDimensione() > DIM_CAMPO) {
                return false;
            }

            // questo ciclo for controlla se le posizioni
            // che dovrà occupare la nave sono libere
            for (int i = riga; i < riga + nave.getDimensione(); i++) {
                Coord coord = new Coord(i, colonna);
                if (campo_battaglia.get(coord) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 
     * @param campo
     */
    public static void svelaGriglia(final Map<Coord, Nave> campo) {
        System.out.print("    A B C D E F G H I J\n");
        for (int i = 1; i <= DIM_CAMPO; i++) {
            if (i == DIM_CAMPO) {
                System.out.print(i + "  ");
                svelaRiga(i, campo);
                System.out.println();
                break;
            } else {
                System.out.print(i + "   ");
                svelaRiga(i, campo);
                System.out.println();
            }
        }
    }

    public static void svelaRiga(int riga, Map<Coord, Nave> campo_battaglia) {
        for (int i = 1; i <= DIM_CAMPO; i++) {
            Coord coord = new Coord(riga, i);
            if (campo_battaglia.get(coord) == null) {
                System.out.print(". ");
            } else {
                System.out.print(campo_battaglia.get(coord).stampaQuadratoColorato());
            }
        }
    }

    public void mostraGriliaVuota() {
        System.out.print("    A B C D E F G H I J\n");
        for (int i = 1; i < DIM_CAMPO + 1; i++) {
            if (i == DIM_CAMPO) {
                System.out.print(i + "  " + stampaRigaVuota() + "\n");
                break;
            } else {
                System.out.print(i + "   " + stampaRigaVuota() + "\n");
            }
        }
    }
    public String stampaRigaVuota() {
        return ". . . . . . . . . .";
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;

import java.util.Map;
import java.util.HashMap;

/**
 * 'Entity'.
 * @author leonardo
 * Classe Nave. Gli oggetti Nave vengono usati per popolare la griglia di gioco.
 *
*/
public class Nave {
    static final String ROSSO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String BLU = "\u001B[34m";
    static final String GIALLO = "\u001B[33m";
    static final String RESET = "\u001B[0m";
    static final int DIMENSIONE2 = 2;
    static final int DIMENSIONE3 = 3;
    static final int DIMENSIONE4 = 4;
    static final int DIMENSIONE5 = 5;
    static final int ESEMPLARE_1 = 1;
    static final int ESEMPLARE_2 = 2;
    static final int ESEMPLARE_3 = 3;
    static final int ESEMPLARE_4 = 4;
    private String nome;
    private final int dimensione;
    private int esemplariInGioco;
    private final Map<Coord, StatoPosizione> coordinate = new HashMap<>();
    private int colpiRicevuti = 0;

/**
 *
 *
 * @param dim dimensione nave
 */
    public Nave(final int dim) throws IllegalArgumentException {
        this.dimensione = dim;
        switch (dimensione) {
            case DIMENSIONE2:
                this.nome = "Cacciatorpediniere";
                this.esemplariInGioco = ESEMPLARE_4;
                break;
            case DIMENSIONE3:
                this.nome = "Incrociatore";
                this.esemplariInGioco = ESEMPLARE_3;
                break;
            case DIMENSIONE4:
                this.nome = "Corazzata";
                this.esemplariInGioco = ESEMPLARE_2;
                break;
            case DIMENSIONE5:
                this.nome = "Portaerei";
                this.esemplariInGioco = ESEMPLARE_1;
                break;
            default:
                throw new IllegalArgumentException("Dimensione nave non valida");
        }
    }

/**
 *
 * @return String.
 */
    public String getNome() {
        return nome;
    }
/**
 *
 * @return dimensione.
 */
    public int getDimensione() {
        return dimensione;
    }

/**
 *
 * @return coordinate.
 */
    public Map<Coord, StatoPosizione> getCoordinate() {
        return new HashMap(coordinate);
    }

/**
 *
 * @param posizione
 */
    public void aggiungiPosizione(final Coord posizione) {
        this.coordinate.put(posizione, StatoPosizione.INTEGRA);
    }

/**
 * Metodo per stampa di informazioni sulla nave.
 * @return
 */
    @Override
    public String toString() {
        return "NAVE: " + nome
                + "; DIMENSIONE: "
                + stampaNaveInQuadrati()
                + "; ESEMPLARI IN GIOCO: "
                + esemplariInGioco + "\n";
    }

/**
 *
 * @return N quadrati in base alla dimensione della nave.
 */
    public String stampaNaveInQuadrati() {
        String quadrati = "";
        int i = 0;
        while (i < dimensione) {
            switch (dimensione) {
                case DIMENSIONE2:
                    quadrati += ROSSO + "\u22A0" + RESET;
                    break;
                case DIMENSIONE3:
                    quadrati += VERDE + "\u22A0" + RESET;
                    break;
                case DIMENSIONE4:
                    quadrati += BLU + "\u22A0" + RESET;
                    break;
                case DIMENSIONE5:
                    quadrati += GIALLO + "\u22A0" + RESET;
                    break;
                default:
                    break;
            }
            i++;
        }
        return quadrati;
    }

/**
 * Metodo per la stampa di navi sotto forma di quadrati colorati, diversi per ogni
 * tipo di nave.
 * @return Simbolo nave colorato.
 */
    public String stampaQuadratoColorato() {
        String quadrato = "";
        switch (dimensione) {
            case DIMENSIONE2:
                quadrato = ROSSO + "\u22A0\t" + RESET;
                break;
            case DIMENSIONE3:
                quadrato = VERDE + "\u22A0\t" + RESET;
                break;
            case DIMENSIONE4:
                quadrato =  BLU + "\u22A0\t" + RESET;
                break;
            case DIMENSIONE5:
                quadrato = GIALLO + "\u22A0\t" + RESET;
                break;
            default:
                break;
        }
        return quadrato;
    }

    /**
     * Metodo chiamato quando una nave viene colpita. Aumenta il contatore di colpi ricevuti e imposta
     * la griglia colpita nell'omonimo StatoPosizione.
     * @param chiave
     */
    public final void colpita(final Coord chiave) {
        this.colpiRicevuti++;
        coordinate.put(chiave, StatoPosizione.COLPITA);
    }

    /**
     * Metodo usato per controllare se l'ultimo colpo arrivato alla nave la far� affondare.
     * @return
     */
    public final boolean isAffondata() {
        return colpiRicevuti == dimensione - 1;
    }

    /**
     * Metodo usato per controllare se la cella della nave � stata colpita.
     * @param chiave
     * @return
     */
    public final boolean isColpita(final Coord chiave) {
        return coordinate.get(chiave) == StatoPosizione.COLPITA;
    }
}

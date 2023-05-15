/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.entitaDiGioco;

import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author leonardo
 */

/**
 *
 * Classe Nave.
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
    private int esemplari_in_gioco;
    private final Map<Coord, StatoPosizione> coordinaate = new HashMap<>();

/**
 *
 *
 * @param dimensione
 */
    public Nave(final int dimensione) {
        this.dimensione = dimensione;
        switch (dimensione) {
            case DIMENSIONE2:
                this.nome = "Cacciatorpediniere";
                this.esemplari_in_gioco = ESEMPLARE_4;
                break;
            case DIMENSIONE3:
                this.nome = "Incrociatore";
                this.esemplari_in_gioco = ESEMPLARE_3;
                break;
            case DIMENSIONE4:
                this.nome = "Corazzata";
                this.esemplari_in_gioco = ESEMPLARE_2;
                break;
            case DIMENSIONE5:
                this.nome = "Portaerei";
                this.esemplari_in_gioco = ESEMPLARE_1;
                break;
            default:
                break;
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
    public Map<Coord, StatoPosizione> getCoordinaate() {
        return coordinaate;
    }

/**
 *
 * @param posizione.
 */
    public void aggiungiPosizione(Coord posizione) {
        this.coordinaate.put(posizione, StatoPosizione.INTEGRA);
    }

/**
 *
 * @return
 */
    @Override
    public String toString() {
        return "NAVE: " + nome
                + "; DIMENSIONE: "
                + stampaNaveInQuadrati()
                + "; ESEMPLARI IN GIOCO: "
                + esemplari_in_gioco + "]\n";
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
                    quadrati += ROSSO + "# " + RESET;
                    break;
                case DIMENSIONE3:
                    quadrati += VERDE + "# " + RESET;
                    break;
                case DIMENSIONE4:
                    quadrati += BLU + "# " + RESET;
                    break;
                case DIMENSIONE5:
                    quadrati += GIALLO + "# " + RESET;
                    break;
                default:
                    break;
            }
            i++;
        }
        return quadrati;
    }

/**
 * 
 * @return Simbolo nave colorato.
 */
    public String stampaQuadratoColorato() {
        String quadrato = "";
        switch (dimensione) {
            case DIMENSIONE2:
                quadrato = ROSSO + "# " + RESET;
                break;
            case DIMENSIONE3:
                quadrato = VERDE + "# " + RESET;
                break;
            case DIMENSIONE4:
                quadrato =  BLU + "# " + RESET;
                break;
            case DIMENSIONE5:
                quadrato = GIALLO + "# " + RESET;
                break;
            default:
                break;
        }
        return quadrato;
    }
}

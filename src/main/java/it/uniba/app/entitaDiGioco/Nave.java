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

/*
 * Classe Nave
*/
public class Nave {
    static final String ROSSO = "\u001B[31m";
    static final String VERDE = "\u001B[32m";
    static final String BLU = "\u001B[34m";
    static final String GIALLO = "\u001B[33m";
    static final String RESET = "\u001B[0m";
    private String nome;
    private final int dimensione;
    private int esemplari_in_gioco;
    private final Map<Coord, StatoPosizione> coordinaate = new HashMap<>();
    
    static final int DIMENSIONE2 = 2;
    static final int DIMENSIONE3 = 3;
    static final int DIMENSIONE4 = 4;
    static final int DIMENSIONE5 = 5;
    

    public Nave(int dimensione) {
        this.dimensione = dimensione;
        if (dimensione == DIMENSIONE2){
            this.nome = "Cacciatorpediniere";
            this.esemplari_in_gioco = 4;
        }
        else if (dimensione == DIMENSIONE3) {
            this.nome = "Incrociatore";
            this.esemplari_in_gioco = 3;
        }
        else if(dimensione == DIMENSIONE4) {
            this.nome = "Corazzata";
            this.esemplari_in_gioco = 2;
        }
        else if(dimensione == DIMENSIONE5) {
            this.nome = "Portaerei";
            this.esemplari_in_gioco = 1;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getDimensione() {
        return dimensione;
    }

    public Map<Coord, StatoPosizione> getCoordinaate() {
        return coordinaate;
    }

    public void aggiungiPosizione(Coord posizione) {
        this.coordinaate.put(posizione, StatoPosizione.INTEGRA);
    }

    @Override
    public String toString() {
        return "NAVE: " + nome +
                "; DIMENSIONE: " + stampaNaveInQuadrati() +
                "; ESEMPLARI IN GIOCO: " + esemplari_in_gioco + "]\n";
    }

    public String stampaNaveInQuadrati() {
        String quadrati = "";
        int i = 0;
        while(i < dimensione) {
            if(dimensione == DIMENSIONE2){
                quadrati += ROSSO + "# " + RESET;
            }
            else if(dimensione == DIMENSIONE3){
                quadrati += VERDE + "# " + RESET;
            }
            else if(dimensione == DIMENSIONE4){
                quadrati += BLU + "# " + RESET;
            }
            else if(dimensione == DIMENSIONE5){
                quadrati += GIALLO + "# " + RESET;
            }
            i++;
        }
        return quadrati;
    }

    public String stampaQuadratoColorato(){
        String quadrato = "";
        if(dimensione == 2){
            quadrato = ROSSO + "# " + RESET;
        }
        else if(dimensione == 3){
            quadrato = VERDE + "# " + RESET;
        }
        else if(dimensione == 4){
            quadrato =  BLU + "# " + RESET;
        }
        else if(dimensione == 5){
            quadrato = GIALLO + "# " + RESET;
        }
        return quadrato;
    }
}

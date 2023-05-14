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
public class Nave {
    static final String rosso = "\u001B[31m";
    static final String verde = "\u001B[32m";
    static final String blu = "\u001B[34m";
    static final String giallo = "\u001B[33m";
    static final String reset = "\u001B[0m";
    private String nome;
    private int dimensione;
    private int esemplari_in_gioco;
    private Map<Coord, StatoPosizione> coordinaate = new HashMap<>();

    private boolean affondata = false;

    public Nave(int dimensione) {
        this.dimensione = dimensione;
        if (dimensione == 2){
            this.nome = "Cacciatorpediniere";
            this.esemplari_in_gioco = 4;
        }
        else if (dimensione == 3) {
            this.nome = "Incrociatore";
            this.esemplari_in_gioco = 3;
        }
        else if(dimensione == 4) {
            this.nome = "Corazzata";
            this.esemplari_in_gioco = 2;
        }
        else if(dimensione == 5) {
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

    //grazie copilot per questa funzione <3
    public void colpisci(Coord posizione) {
        this.coordinaate.put(posizione, StatoPosizione.COLPITA);
        this.affondata = this.coordinaate.values().stream().allMatch(stato -> stato == StatoPosizione.COLPITA);
    }

    public boolean isAffondata() {
        return affondata;
    }

    public boolean isColpita(Coord posizione) {
        return this.coordinaate.get(posizione) == StatoPosizione.COLPITA;
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
            if(dimensione == 2){
                quadrati += rosso + "?" + reset;
            }
            else if(dimensione == 3){
                quadrati += verde + "?" + reset;
            }
            else if(dimensione == 4){
                quadrati += blu + "?" + reset;
            }
            else if(dimensione == 5){
                quadrati += giallo + "?" + reset;
            }
            i++;
        }
        return quadrati;
    }

    public String stampaQuadratoColorato(){
        String quadrato = "";
        if(dimensione == 2){
            quadrato = rosso + "?\t" + reset;
        }
        else if(dimensione == 3){
            quadrato = verde + "?\t" + reset;
        }
        else if(dimensione == 4){
            quadrato =  blu + "?\t" + reset;
        }
        else if(dimensione == 5){
            quadrato = giallo + "?\t" + reset;
        }
        return quadrato;
    }
}

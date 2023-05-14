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
public class CampoDiBattaglia {
    private final Map<Coord, Nave> campo_battaglia = new HashMap<>();
    public static List<Nave> navi = new ArrayList<>();
    private Random random = new Random();
    private LivelloDiGioco livello_partita;

    /*
    il coostruttore assegna il livello di gioco, utile per il controllo dei tentativi rimasti
     e inizializza il campo di battaglia
     */
    public CampoDiBattaglia(TipoLivello livello) {
        Partita.iniziata = true;
        this.livello_partita = new LivelloDiGioco(livello);
        inizializzaCampo();
        inizializzaNavi();
        posizionaNavi();
        mostraGriliaVuota();
    }
    public Map<Coord, Nave> getCampo_battaglia() {
        return campo_battaglia;
    }

    /*
    il metodo inizializzaCampo() inizializza la mappa campo di battaglia
    inserendo come chiave le coordinate e come valore null
     */
    public void inizializzaCampo(){
        for(int i = 1; i < 11; i++){
            for(int j = 1; j < 11; j++){
                campo_battaglia.put(new Coord(i, j), null);
            }
        }
    }

    /*
    il metodo inizializzaNavi() inizializza la lista di navi
    secondo i requisiti del gioco
     */
    public void inizializzaNavi(){
        navi.add(new Nave(2));
        navi.add(new Nave(2));
        navi.add(new Nave(2));
        navi.add(new Nave(2));
        navi.add(new Nave(3));
        navi.add(new Nave(3));
        navi.add(new Nave(3));
        navi.add(new Nave(4));
        navi.add(new Nave(4));
        navi.add(new Nave(5));
    }

    /*
    il metodo posizizionaNavi() genera casualmente le coordinate e l'orientamento
    di ogni nave e le posiziona sul campo di battaglia dopo aver controllato che
    non ci siano collisioni con altre navi chiamando il metodo posizionaNave().
     */
    public void posizionaNavi(){
        for(Nave nave : navi){
            boolean posizionata = false;
            while(!posizionata){
                int riga = random.nextInt(1, 10); //
                int colonna = random.nextInt(1, 10);
                boolean orizzontale = random.nextBoolean();

                if(posizionaNave(nave, riga, colonna, orizzontale)){
                    posizionata = true;
                    for(int i = 0; i < nave.getDimensione(); i++){
                        if(orizzontale){
                            campo_battaglia.put(new Coord(riga, colonna + i), nave);
                            nave.aggiungiPosizione(new Coord(riga, colonna + i));
                        }else{
                            campo_battaglia.put(new Coord(riga + i, colonna), nave);
                            nave.aggiungiPosizione(new Coord(riga + i, colonna));
                        }
                    }
                }
            }
        }
    }

    /*
    il metodo posizionaNave() controlla se la nave può essere posizionata
     */
    public boolean posizionaNave(Nave nave, int riga, int colonna, boolean orizzontale) {
        if (orizzontale) {
            //questo if serve per controllare che la nave non esca dal campo
            if (colonna + nave.getDimensione() > 10) {
                return false;
            }

            //questo ciclo for controlla se le posizioni che dovrà occupare la nave sono libere
            for (int i = colonna; i < colonna + nave.getDimensione(); i++) {
                Coord coord = new Coord(riga, i);
                if (campo_battaglia.get(coord) != null) {
                    return false;
                }
            }
        }
        else {                                         //caso verticale

            //questo if serve per controllare che la nave non esca dal campo
            if(riga + nave.getDimensione() > 10){
                return false;
            }

            //questo ciclo for controlla se le posizioni che dovrà occupare la nave sono libere
            for(int i = riga; i < riga + nave.getDimensione(); i++){
                Coord coord = new Coord(i, colonna);
                if(campo_battaglia.get(coord) != null){
                    return false;
                }
            }
        }
        return true;
    }

    public static void svelaGriglia(Map<Coord, Nave> campo){
        System.out.print("    A B C D E F G H I J\n");
        for(int i = 1; i <= 10; i++){
            if(i == 10){
                System.out.print(i + "  ");
                svelaRiga(i, campo);
                System.out.println();
                break;
            }
            else{
                System.out.print(i + "   ");
                svelaRiga(i, campo);
                System.out.println();
            }
        }
    }

    public static void svelaRiga(int riga, Map<Coord, Nave> campo_battaglia){
        for(int i = 1; i <= 10; i++){
            Coord coord = new Coord(riga, i);
            if(campo_battaglia.get(coord) == null){
                System.out.print(". ");
            }
            else{
                System.out.print(campo_battaglia.get(coord).stampaQuadratoColorato());
            }
        }
    }

    public void mostraGriliaVuota(){
        System.out.print("    A B C D E F G H I J\n");
        for(int i = 1; i < 11; i++){
            if(i == 10){
                System.out.print(i + "  " + stampaRigaVuota() + "\n");
                break;
            }
            else {
                System.out.print(i + "   " + stampaRigaVuota() + "\n");
            }
        }
    }
    public String stampaRigaVuota(){
        return ". . . . . . . . . .";
    }
}

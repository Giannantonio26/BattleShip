/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.uniba.app.comandi;
import it.uniba.app.entitaDiGioco.Partita;
import it.uniba.app.entitaDiGioco.CampoDiBattaglia;
import it.uniba.app.entitaDiGioco.Coord;
import it.uniba.app.entitaDiGioco.LivelloDiGioco;
import it.uniba.app.entitaDiGioco.StatoPosizione;
/**
 * 'Control'.
 * @author leonardo
 * Comando per dare un comando di attacco.
 */
public final class ComandoAttacco implements Comando {
    private final int riga;
    private final int colonna;
    private static final int DIM_TRE = 3;
    private static final int DIM_QUATTRO = 4;
    private static final int DIM_CINQUE = 5;
    /**
     *
     * @param colonnaIn
     * @param rigaIn
     */
    public ComandoAttacco(final int colonnaIn, final int rigaIn) {
        this.riga = colonnaIn;
        this.colonna = rigaIn;
    }
    @Override
    public void esegui() {
        if (!Partita.isIniziata()) {
            System.out.println("\nNon puoi effettuare un tentativo se non cominci una partita.");
        } else {
            if (riga > Partita.getDimensioneGriglia() || colonna > Partita.getDimensioneGriglia()) {
                System.out.println("Coordinate errate. Ritenta.\n");
            } else {
            Coord tentativo = new Coord(colonna, riga);
            for (Coord chiave : CampoDiBattaglia.getCampoBattaglia().keySet()) {
                if (tentativo.equals(chiave)) {
                    Partita.setTentativiEffettuati(Partita.getTentativiEffettuati() + 1);
                    if (CampoDiBattaglia.getCampoBattaglia().get(chiave) == null) {
                         LivelloDiGioco lvl = CampoDiBattaglia.getLivelloPartita();
                         lvl.setNumeroTentativi(CampoDiBattaglia.getLivelloPartita().getNumeroTentativi() - 1);
                        System.out.println("\nAcqua!");
                    } else if (CampoDiBattaglia.getCampoBattaglia().
                            get(chiave).getCoordinate().
                            get(chiave) == StatoPosizione.INTEGRA) {
                        if (CampoDiBattaglia.getCampoBattaglia().get(chiave).isAffondata()) {
                            CampoDiBattaglia.getCampoBattaglia().get(chiave).colpita(chiave);
                            if (CampoDiBattaglia.getCampoBattaglia().get(chiave).getDimensione() == 2) {
                                    CampoDiBattaglia.setEsemplari2(CampoDiBattaglia.getEsemplari2() - 1);
                            } else if (CampoDiBattaglia.getCampoBattaglia().get(chiave).getDimensione() == DIM_TRE) {
                                    CampoDiBattaglia.setEsemplari3(CampoDiBattaglia.getEsemplari3() - 1);
                            } else if (CampoDiBattaglia.getCampoBattaglia().get(chiave).getDimensione()
                                    == DIM_QUATTRO) {
                                    CampoDiBattaglia.setEsemplari4(CampoDiBattaglia.getEsemplari4() - 1);
                            } else if (CampoDiBattaglia.getCampoBattaglia().get(chiave).getDimensione() == DIM_CINQUE) {
                                    CampoDiBattaglia.setEsemplari5(CampoDiBattaglia.getEsemplari5() - 1);
                            }
                            System.out.println("\nColpita e Affondata!");
                            CampoDiBattaglia.setNaviAffondate(CampoDiBattaglia.getNaviAffondate() + 1);
                        } else {
                            System.out.println("\nColpita!");
                            CampoDiBattaglia.getCampoBattaglia().
                                    get(chiave).colpita(chiave);
                        }
                    } else if (CampoDiBattaglia.getCampoBattaglia().
                            get(chiave).getCoordinate().
                            get(chiave) == StatoPosizione.COLPITA) {
                        System.out.println("\nGià colpita!");
                    }
                }
            }
            if (Partita.isTempoDiGiocoAttivo()) {
            System.out.println("Minuti trascorsi: " + Partita.getMinutiTrascorsi());
            System.out.println("Minuti ancora disponibili: "
            + (Partita.getMinutiDiGioco() - Partita.getMinutiTrascorsi()));
            }
            CampoDiBattaglia.mostraGrigliaAggiornata();
                if (CampoDiBattaglia.getLivelloPartita().getNumeroTentativi() == 0) {
                    System.out.println("\nHai esaurito i tentativi, hai perso! Digita /gioca per comiciarne un'altra.");
                    System.out.println("Ecco la griglia iniziale di questa partita:");
                    CampoDiBattaglia.svelaGriglia(CampoDiBattaglia.getCampoBattaglia());
                    Partita.setIniziata(false);
                    CampoDiBattaglia.reset();
                }
                final int numNavi = 10;
                if (CampoDiBattaglia.getNaviAffondate() == numNavi) {
                    System.out.println("\nHai affondato tutte le navi, hai vinto!"
                            + " Digita /gioca per comiciarne un'altra.");
                    Partita.setIniziata(false);
                    CampoDiBattaglia.reset();
                }
            }
        }
    }
}

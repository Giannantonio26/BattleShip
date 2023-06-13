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
 *
 * @author leonardo
 */
public final class ComandoAttacco implements Comando {
    private final int riga;
    private final int colonna;
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
                    } else if (CampoDiBattaglia.getCampoBattaglia().get(chiave).getCoordinate().get(chiave) == StatoPosizione.INTEGRA) {
                        if (CampoDiBattaglia.getCampoBattaglia().get(chiave).isAffondata()) {
                            CampoDiBattaglia.getCampoBattaglia().get(chiave).colpita(chiave);
                            System.out.println("\nColpita e Affondata!");
                            CampoDiBattaglia.setNaviAffondate(CampoDiBattaglia.getNaviAffondate() + 1);
                        } else {
                            System.out.println("\nColpita!");
                            CampoDiBattaglia.getCampoBattaglia().get(chiave).colpita(chiave);
                        }
                    } else if (CampoDiBattaglia.getCampoBattaglia().get(chiave).getCoordinate().get(chiave) == StatoPosizione.COLPITA) {
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

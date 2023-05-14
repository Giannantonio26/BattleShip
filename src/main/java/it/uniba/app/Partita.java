package it.uniba.app;
/**
 *  Classe partita.
 */
public class Partita {
    private int maxTentativiFalliti;
    private TipoLivello livelloDifficolta;
    /**
    * Costruttore.
    */
    public Partita() {
        this.livelloDifficolta = TipoLivello.FACILE;
        this.maxTentativiFalliti = 50;
    }
    /**
     *
     * @param livelloDiff indica il lvl di difficoltà scelto
     * @param max_tentativi indica il numero max di tentativi a disposizione
     */
    public Partita(TipoLivello livelloDiff, int max_tentativi) {
        this.livelloDifficolta = livelloDiff;
        this.maxTentativiFalliti = max_tentativi;
    }
    /**
     *
     * @param livello
     */
    public final void setLivelloDifficolta(String livello) {
        if (livello.equals("facile")) {
            TipoLivello livelloDiff = TipoLivello.FACILE;
            this.livelloDifficolta = livelloDiff;
            this.maxTentativiFalliti = 50;
        }
        if (livello.equals("medio")) {
            TipoLivello livelloDiff = TipoLivello.MEDIO;
            this.livelloDifficolta = livelloDiff;
            this.maxTentativiFalliti = 30;
        }
        if (livello.equals("difficile")) {
            TipoLivello livelloDiff = TipoLivello.DIFFICILE;
            this.livelloDifficolta = livelloDiff;
            this.maxTentativiFalliti = 10;
        }
    }
    /**
     *
     * @return il livello di difficoltà
     */
    public final TipoLivello getLivelloDifficolta() {
        return livelloDifficolta;
    }
    /**
     *
     * @return il numero massimo di tentativi falliti
     */
    public final int getMaxTentativi() {
        return maxTentativiFalliti;
    }
}

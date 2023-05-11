package it.uniba.app;

/**
 *  Classe partita
 */
public class Partita {
    private int maxTentativiFalliti;
    private Livello livelloDifficolta;
    public Partita() {
        this.livelloDifficolta = Livello.FACILE;
        this.maxTentativiFalliti = 50;
    }
    public Partita(Livello livelloDiff, int max_tentativi) {
        this.livelloDifficolta = livelloDiff;
        this.maxTentativiFalliti = max_tentativi;
    }
    public final void setLivelloDifficolta(String livello) {
        if (livello.equals("facile")) {
            Livello livelloDiff = Livello.FACILE;
            this.livelloDifficolta = livelloDiff;
            this.maxTentativiFalliti = 50;
        }
        if (livello.equals("medio")) {
            Livello livelloDiff = Livello.MEDIO;
            this.livelloDifficolta = livelloDiff;
            this.maxTentativiFalliti = 30;
        }
        if (livello.equals("difficile")) {
            Livello livelloDiff = Livello.DIFFICILE;
            this.livelloDifficolta = livelloDiff;
            this.maxTentativiFalliti = 10;
        }   
    }
    public final Livello getLivelloDifficolta() {
        return livelloDifficolta;
    }
    public final int getMaxTentativi() {
        return maxTentativiFalliti;
    }
}
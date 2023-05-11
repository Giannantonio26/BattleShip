package it.uniba.app;

/**
 *  Classe partita
 */
public class Partita {    
    private int maxTentativiFalliti;
    private Livello livello_difficolta;
    
    public Partita(){
        this.livello_difficolta = Livello.FACILE;
        this.maxTentativiFalliti = 50;
    }
    
    public Partita(Livello livello_diff, int max_tentativi){
        this.livello_difficolta = livello_diff;
        this.maxTentativiFalliti = max_tentativi;
    }
    
    public void setLivelloDifficolta(Livello livelloDiff){
        this.livello_difficolta = livelloDiff;
        
        if (this.livello_difficolta==Livello.FACILE) {
            this.maxTentativiFalliti = 50;
        }
        
        if (this.livello_difficolta==Livello.MEDIO) {
            this.maxTentativiFalliti = 30;
        }
        
        if (this.livello_difficolta==Livello.DIFFICILE) {
            this.maxTentativiFalliti = 10;
        }
        
    }
    
    public Livello getLivelloDifficolta(){
        return livello_difficolta;
    }
    
    public int getMaxTentativi(){
        return maxTentativiFalliti;
    }
    
}

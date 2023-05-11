package it.uniba.app;

/**
 * Classe Helper.
 */


public class Helper {

    private Helper(){
        
    }
    
    private static String comandoHelp = "Descrizione concisa del gioco e"
            + " lista di comandi disponibili";
    private static String benvenuto = "Benvenuto, per una lista dei comandi"
            + " disponibili, digita /help";
    
    public static void stampaHelp(){
       System.out.println(comandoHelp);
    }
    public static void stampaBenvenuto(){
        System.out.println(benvenuto);
    }
  
}

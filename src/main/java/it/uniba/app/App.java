package it.uniba.app;

/**
 * 'Boundary'.
 * Classe Main del programma, si preoccupa di mostrare all'utente un benvenuto
 * oppure direttamente il comando help parametrizzato.
 * Dopodichè delega alla classe InputScanner la creazione dello scanner per ricevere comandi in input.
 */
public final class App {

    /**
     * Get a greeting sentence.
     *
     * @return the "Hello World!" string.
     */
    public String getGreeting() {
        return "Hello World!!!";
    }

    /**
     * Entrypoint of the application.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        if (args.length > 0) {
            if (args[0].equals("--help") || args[0].equals("-h")) {
                String help = Helper.getHelp();
                System.out.println(help);
            } else {
                String benvenuto = Helper.getBenvenuto();
                System.out.println(benvenuto);
            }
        } else {
            String benvenuto = Helper.getBenvenuto();
            System.out.println(benvenuto);
        }
        InputScanner.userInputScanner();
    }
}

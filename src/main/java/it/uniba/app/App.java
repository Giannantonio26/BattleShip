package it.uniba.app;
import java.util.Scanner;

/**
 * Main class of the application.
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
                Helper.stampaHelp();
            } else {
                Helper.stampaBenvenuto();
            }
        } else {
            Helper.stampaBenvenuto();
        }
        InputScanner.userInputScanner();
    }
}

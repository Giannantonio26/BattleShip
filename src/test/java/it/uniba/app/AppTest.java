package it.uniba.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main test class of the application.
 */
class AppTest {
    /**
     * Test the getGreeting method of the App class.
     */
    @Test
    void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(
                classUnderTest.getGreeting(), "app should have a greeting");
    }
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStream() {
        try {
            System.setOut(new PrintStream(outContent, true, "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("Corretta chiamata dell'help se passato come parametro di lancio")
    void testHelpConArgs() {
       String[] args = new String[1];
       args[0] = "--help";
       App.main(args);
        try {
            assertEquals(Helper.getHelp().trim(), outContent.toString("UTF-8").trim(),
                    "Help visualizzato correttamente");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    @DisplayName("Corretta chiamata a getBenvenuto in caso di assenza parametri di lancio"
            + "o con parametro di lancio non valido")
    void testBenvenuto() {
       String[] args = new String[1];
       args[0] = "stringa";
       App.main(args);
        try {
            assertEquals(Helper.getBenvenuto().trim(), outContent.toString("UTF-8").trim(),
                    "Benvenuto visualizzato correttamente");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

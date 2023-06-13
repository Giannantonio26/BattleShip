package it.uniba.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(System.out);
    }
    
    @Test
    @DisplayName("Corretta chiamata dell'help se passato come parametro di lancio")
    void testHelpConArgs() {
       String [] args = new String[1];
       args[0] = "--help";
       App.main(args);
       assertEquals(Helper.getHelp().trim(), outContent.toString().trim());
    }
    
    @Test
    @DisplayName("Corretta chiamata a getBenvenuto in caso di assenza parametri di lancio"
            + "o con parametro di lancio non valido")
    void testBenvenuto() {
       String [] args = new String[1];
       args[0] = "stringa";
       App.main(args);
       assertEquals(Helper.getBenvenuto().trim(), outContent.toString().trim());
    }
}

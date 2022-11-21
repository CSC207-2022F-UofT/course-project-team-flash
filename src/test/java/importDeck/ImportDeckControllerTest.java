package importDeck;

import java.io.IOException;
import java.io.FileWriter;
import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImportDeckControllerTest {
    private void createFile(String fileName, String fileContent){
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(fileContent);
            writer.close();
        }
        catch (IOException e) {
            fail(e.toString());
        }
    }

    private ImportDeckController controllerSetUp(){
        ImportDeckPresenter presenter = new ImportDeckPresenter();
        CardFactory factory = new FlashcardFactory();
        ImportDeckInteractor interactor = new ImportDeckInteractor(presenter, factory);
        ImportDeckController controller = new ImportDeckController(interactor);
        return controller;
    }

    @Test
    public void basicImportTest(){
        ImportDeckController controller = controllerSetUp();
        String fileLocation = "Test.deck";
        String testName = "Test";
        String testType = "1";
        String testQ = "Did this pass?";
        String testA = "No";

        createFile(fileLocation,testType+";"+testQ+";"+testA);

        controller.runImport(fileLocation);

        Deck actualDeck = Deck.getTracker().get(testName);

        Flashcard firstCard = actualDeck.getCards().get(0);

        String actualQ = firstCard.getQuestion();
        String actualA = firstCard.getAnswer();
        assertEquals(testName, actualDeck.getName());
        assertEquals(testQ, actualQ);
        assertEquals(testA, actualA);
    }
}

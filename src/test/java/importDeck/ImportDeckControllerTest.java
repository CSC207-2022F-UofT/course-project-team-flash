package importDeck;

import java.io.IOException;
import java.io.FileWriter;
import entities.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImportDeckControllerTest {
    @Test
    public void BasicImportTest(){
        ImportDeckPresenter presenter = new ImportDeckPresenter();
        CardFactory factory = new FlashcardFactory();
        ImportDeckInteractor interactor = new ImportDeckInteractor(presenter, factory);
        ImportDeckController controller = new ImportDeckController(interactor);
        String fileLocation = "Test.deck";

        String testName = "Test";
        String testType = "1";
        String testQ = "Did this pass?";
        String testA = "No";

        try {
            FileWriter writer = new FileWriter(fileLocation);
            writer.write(testType+";"+testQ+";"+testA);
            writer.close();
        }
        catch (IOException e) {
            fail(e.toString());
        }

        Deck actualDeck = controller.runImport(fileLocation).getImportedDeck();

        Flashcard firstCard = actualDeck.getCards().get(0);

        String actualQ = firstCard.getQuestion();
        String actualA = firstCard.getAnswer();
        assertEquals(testName, actualDeck.getName());
        assertEquals(testQ, actualQ);
        assertEquals(testA, actualA);
    }
}

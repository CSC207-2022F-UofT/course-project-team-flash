package importDeck;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.IOException;

import entities.CardFactory;
import entities.FlashcardFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImportDeckControllerTest {
    @Test
    public void ImportDeckControllerTest(){
        ImportDeckPresenter presenter = new ImportDeckPresenter();
        CardFactory factory = new FlashcardFactory();
        ImportDeckInteractor interactor = new ImportDeckInteractor(presenter, factory);
        ImportDeckController controller = new ImportDeckController(interactor);

        String fileLocation = "Test.deck";
        File deckFile = new File(fileLocation);
        try {
            FileWriter writer = new FileWriter(fileLocation);
            writer.write("1;Did this pass?;No");
        }
        catch (IOException e) {

        }

        System.out.println(controller.runImport(fileLocation));
    }
}

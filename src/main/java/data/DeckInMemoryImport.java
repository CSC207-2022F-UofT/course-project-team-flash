/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 26/22
 */

package data;

import entities.Deck;
import importDeck.ImportDeckDsGateway;
import importDeck.ImportDeckDsInputData;
import importDeck.ImportDeckDsOutputData;
import screens.ImportDeckFail;

import java.util.List;
import java.util.Map;

import static data.DeckPathCleaner.cleanName;

/**
 * This reads something pretending to be a file and creates a deck
 * Should be used in testing only
 */
public class DeckInMemoryImport implements ImportDeckDsGateway {
    private final Map<String, List<String>> file;

    /**
     * Constructor for deck import from memory
     * @param file the file for testing
     */
    public DeckInMemoryImport(Map<String, List<String>> file){
        this.file = file;
    }

    /**
     * Reads a file and packages the information for use in the interactor
     * @param dsInputData the input data for the gateway
     * @return an output data object for use in the interactor
     */
    @Override
    public ImportDeckDsOutputData importFromFile(ImportDeckDsInputData dsInputData){
        String filePath = dsInputData.getFilePath();
        List<String> importedCards = file.get(filePath);
        String deckName = cleanName(filePath);
        if (Deck.getTracker().get(deckName) != null){
            throw new ImportDeckFail("Could not import! " + deckName + " already exists!");
        }
        if (importedCards == null){
            throw new ImportDeckFail(deckName + " doesn't exist");
        }
        return new ImportDeckDsOutputData(deckName, importedCards);
    }
}

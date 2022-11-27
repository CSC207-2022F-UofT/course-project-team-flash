/*
 * Author: Aldo Bani
 * Date: November 26/22
 * This reads something pretending to be a file and creates a deck
 * Should be used in testing only
 */

package data;

import importDeck.ImportDeckDsGateway;
import importDeck.ImportDeckDsInputData;
import importDeck.ImportDeckDsOutputData;
import screens.ImportDeckFail;

import java.util.List;
import java.util.Map;

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
        String deckName = dsInputData.getFilePath();
        List<String> importedCards = file.get(deckName);
        if (importedCards == null){
            throw new ImportDeckFail(deckName + " doesn't exist");
        }
        return new ImportDeckDsOutputData(deckName, importedCards);
    }
}

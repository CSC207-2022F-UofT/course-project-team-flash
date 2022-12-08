/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 26/22
 */

package data;

import entities.Deck;
import import_deck.ImportDeckDsGateway;
import import_deck.ImportDeckDsInputData;
import import_deck.ImportDeckDsOutputData;
import screens.ImportDeckFail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static data.DeckPathCleaner.cleanName;

/**
 * This reads a file and packages its information for use by the interactor
 */
public class DeckFileImport implements ImportDeckDsGateway{
    /**
     * Reads from a file containing information about a deck and returns an output data object
     * @param dsInputData the input data required
     */
    @Override
    public ImportDeckDsOutputData importFromFile(ImportDeckDsInputData dsInputData){
        String filePath = dsInputData.getFilePath();
        try {
            File fileToRead = new File(filePath);
            Scanner reader = new Scanner(fileToRead);
            List<String> cardsRead = new ArrayList<>();
            while (reader.hasNextLine()){
                cardsRead.add(reader.nextLine());
            }
            String deckName = cleanName(filePath);
            if (Deck.getTracker().get(deckName) != null){
                throw new ImportDeckFail("Could not import deck! " + deckName + " already exists!");
            }
            return new ImportDeckDsOutputData(deckName, cardsRead);
        }
        catch(FileNotFoundException e){
            throw new ImportDeckFail("Could not find " + filePath);
        }
    }
}

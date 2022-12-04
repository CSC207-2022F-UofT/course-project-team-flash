/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 26/22
 * This reads a file and packages its information for use by the interactor
 */

package data;

import importDeck.ImportDeckDsGateway;
import importDeck.ImportDeckDsInputData;
import importDeck.ImportDeckDsOutputData;
import screens.ImportDeckFail;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static data.DeckPathCleaner.cleanName;


public class DeckFileImport implements ImportDeckDsGateway{
    /**
     * Reads from a file containing information about a deck and returns an output data object
     * @param dsInputData the input data required
     */
    @Override
    public ImportDeckDsOutputData importFromFile(ImportDeckDsInputData dsInputData){
        try {
            String filePath = dsInputData.getFilePath();
            File fileToRead = new File(filePath);
            Scanner reader = new Scanner(fileToRead);
            List<String> cardsRead = new ArrayList<>();
            while (reader.hasNextLine()){
                cardsRead.add(reader.nextLine());
            }
            return new ImportDeckDsOutputData(cleanName(filePath), cardsRead);
        }
        catch(FileNotFoundException e){
            throw new ImportDeckFail(e.toString());
        }
    }
}

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


public class DeckFileImport implements ImportDeckDsGateway{
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
            return new ImportDeckDsOutputData(filePath, cardsRead);
        }
        catch(FileNotFoundException e){
            throw new ImportDeckFail(e.toString());
        }
    }
}

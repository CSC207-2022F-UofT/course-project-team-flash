/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the use case interactor for the deck import system
 */

package importDeck;

import entities.CardFactory;
import screens.ImportDeckFail;

public class ImportDeckInteractor implements ImportDeckInputBoundary{
    private final ImportDeckDsGateway dsGateway;
    private final ImportDeckOutputBoundary outputBoundary;
    private final CardFactory cardFactory;

    /**
     * The interactor for the deck import use case
     * @param dsGateway the gateway for file access
     * @param outputBoundary The output boundary for the deck import use case.
     * @param cardFactory The card factory for card creation
     */
    public ImportDeckInteractor(ImportDeckDsGateway dsGateway, ImportDeckOutputBoundary outputBoundary, CardFactory cardFactory){
        this.dsGateway = dsGateway;
        this.outputBoundary = outputBoundary;
        this.cardFactory = cardFactory;
    }

    /**
     * Takes in data input containing the file and creates a data output with a deck containing its cards
     * @param inputData data retrieved from the input
     */
    @Override
    public void importDeck(ImportDeckInputData inputData){
        ImportDeckDsInputData dsInputData = new ImportDeckDsInputData(inputData.getFileName());
        try {
            ImportDeckDsOutputData dsOutputData = dsGateway.importFromFile(dsInputData);
            ImportDeckOutputData outputData = new ImportDeckOutputData(dsOutputData.getImportedDeckName());
            outputBoundary.prepareSuccessView(outputData);
        }
        catch (ImportDeckFail e) {
            outputBoundary.prepareFailView(e.toString());
        }
    }
}

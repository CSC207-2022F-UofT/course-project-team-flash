/*
 * Author: Aldo Bani
 * Date: November 9/22
 * This is the use case interactor for the deck import system
 */

package importDeck;

import entities.CardFactory;
import entities.Deck;
import entities.Flashcard;
import screens.ImportDeckFail;

import java.util.Arrays;
import java.util.List;

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
     * Creates a card object from a string containing information about the card
     * @param cardInfo information about the card
     * @return a card object
     */
    private Flashcard cardFormatter(String cardInfo){
        String[] cardInfoArray = cardInfo.split(";");
        List<String> options;
        try {
            options = Arrays.asList(cardInfoArray[3].split(","));
        }
        catch (ArrayIndexOutOfBoundsException e){
            options = null;
        }
        return cardFactory.createCard(Integer.parseInt(cardInfoArray[0]), cardInfoArray[1], cardInfoArray[2], options);
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
            String deckName = dsOutputData.getImportedDeckName();
            Deck importedDeck = new Deck(deckName);
            Deck.addTracker(deckName, importedDeck);
            for (String cardInfo : dsOutputData.getImportedCards()){
                Flashcard newCard = cardFormatter(cardInfo);
                if (newCard != null) importedDeck.addCard(newCard);
            }
            ImportDeckOutputData outputData = new ImportDeckOutputData(deckName);
            outputBoundary.prepareSuccessView(outputData);
        }
        catch (ImportDeckFail e) {
            outputBoundary.prepareFailView(e.toString());
        }
    }
}

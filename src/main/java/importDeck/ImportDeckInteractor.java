/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 9/22
 * This is the use case interactor for the deck import system
 */

package importDeck;

import entities.CardFactory;
import entities.Deck;
import entities.Flashcard;
import entities.FlashcardType;
import screens.ImportDeckFail;

import java.util.Arrays;
import java.util.List;

public class ImportDeckInteractor implements ImportDeckInputBoundary{
    private static final int INVALID_CARD_TYPE = -1;
    private static final int TYPE_POSITION = 0;
    private static final int QUESTION_POSITION = 1;
    private static final int ANSWER_POSITION = 2;
    private static final int OPTIONS_POSITION = 3;
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

        FlashcardType type = null;
        try {
            int tempType = Integer.parseInt(cardInfoArray[TYPE_POSITION]);
            if (tempType == 1) {
                type = FlashcardType.QandAFlashcard;
            } else {
                type = FlashcardType.MCFlashcard;
            }
        }
        catch (NumberFormatException e){
            int tempType = INVALID_CARD_TYPE;
        }

        String question;
        try {
            question = cardInfoArray[QUESTION_POSITION];
        }
        catch (ArrayIndexOutOfBoundsException e){
            question = null;
        }

        String answer;
        try {
            answer = cardInfoArray[ANSWER_POSITION];
        }
        catch (ArrayIndexOutOfBoundsException e){
            answer = null;
        }

        List<String> options;
        try {
            options = Arrays.asList(cardInfoArray[OPTIONS_POSITION].split(","));
        }
        catch (ArrayIndexOutOfBoundsException e){
            options = null;
        }

        return cardFactory.createCard(type, question, answer, options);
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
                if (newCard != null){
                    Flashcard.addTracker(newCard.getUniqueID(), newCard);
                    importedDeck.addCard(newCard);
                }
            }
            ImportDeckOutputData outputData = new ImportDeckOutputData(deckName);
            outputBoundary.prepareSuccessView(outputData);
        }
        catch (ImportDeckFail e) {
            outputBoundary.prepareFailView(e.toString());
        }
    }
}

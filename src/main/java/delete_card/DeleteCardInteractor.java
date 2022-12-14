/*
 * Author: Derrick Cho
 * Date: November 26/22
 * Description: Implementation of DeleteCardInteractor
 */
package delete_card;

import entities.Flashcard;
import entities.Deck;

/**
 * This file contains the implementation of the DeleteCardInteractor class
 * It contains the instance variables of DeleteCardInteractor
 * and contains a delete method
 */
public class DeleteCardInteractor implements DeleteCardInputBoundary{

    private final DeleteCardOutputBoundary deleteCardOutputBoundary;

    /**
     * Creates a new DeleteCardInteractor with a given DeleteCardOutputBoundary
     * @param deleteCardOutputBoundary a DeleteCardOutputBoundary
     */
    public DeleteCardInteractor(DeleteCardOutputBoundary deleteCardOutputBoundary) {
        this.deleteCardOutputBoundary = deleteCardOutputBoundary;
    }

    /**
     * Takes in a given DeleteCardInputData and prepares a success of fail view depending
     * on if the card has been deleted or not
     * @param deleteCardInputData a DeleteCardInputData
     */
    @Override
    public void delete(DeleteCardInputData deleteCardInputData){
        if (!(Flashcard.getTracker().containsKey(deleteCardInputData.getCardID())) ||
                !(Deck.getTracker().get(deleteCardInputData.getDeckName()).getCards()
                        .contains(Flashcard.getTracker().get(deleteCardInputData.getCardID())))) {
            DeleteCardOutputData deleteCardOutputData = new DeleteCardOutputData("Card not found", deleteCardInputData.getCardID());
            deleteCardOutputBoundary.prepareFailView(deleteCardOutputData);
        } else {
            Flashcard card = Flashcard.getTracker().get(deleteCardInputData.getCardID());
            Deck deck = Deck.getTracker().get(deleteCardInputData.getDeckName());

            deck.removeCard(card);
            Flashcard.removeTracker(deleteCardInputData.getCardID());

            DeleteCardOutputData deleteCardOutputData = new DeleteCardOutputData("Card Deleted", deleteCardInputData.getCardID());
            deleteCardOutputBoundary.prepareSuccessView(deleteCardOutputData);
        }
    }
}

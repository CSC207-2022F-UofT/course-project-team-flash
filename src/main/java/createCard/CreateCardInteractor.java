/**
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the CreateCardInteractor class, which implements CreateCardInputBoundary.
 */

package createCard;

import entities.CardFactory;
import entities.Flashcard;

public class CreateCardInteractor implements CreateCardInputBoundary {

    final CreateCardOutputBoundary outputBoundary;
    final CardFactory cardFactory;

    /**
     * Creates a new CreateCardInteractor with the given output boundary and card factory.
     *
     * @param outputBoundary the CreateCardOutputBoundary associated with the flashcard to be created
     * @param cardFactory the CardFactory associated with the flashcard to be created
     */
    public CreateCardInteractor(CreateCardOutputBoundary outputBoundary, CardFactory cardFactory) {
        this.outputBoundary = outputBoundary;
        this.cardFactory = cardFactory;
    }

    /**
     * Creates the new flashcard and store it in the deck where it is supposed to go to.
     * Also prepares fail view if the question or answer part of this flashcard is missing; otherwise, prepares
     * success view.
     *
     * @param inputData the CreateCardInputData associated with the flashcard to be created
     */
    @Override
    public void create(CreateCardInputData inputData) {
        if (inputData.getQuestion().isEmpty()) {
            CreateCardOutputData outputData = new CreateCardOutputData("Flashcard Creation Failed. No Question Stated.");
            outputBoundary.prepareFailView(outputData);
        } else if (inputData.getAnswer().isEmpty()) {
            CreateCardOutputData outputData = new CreateCardOutputData("Flashcard Creation Failed. No Answer Stated.");
            outputBoundary.prepareFailView(outputData);
        }

        Flashcard newCard = cardFactory.createCard(
                inputData.getType(),
                inputData.getQuestion(),
                inputData.getAnswer(),
                inputData.getOptions());

        Flashcard.addTracker(newCard.getUniqueID(), newCard);

        inputData.getDeck().addCard(newCard);

        CreateCardOutputData outputData = new CreateCardOutputData(
                "Flashcard created.",
                inputData.getType(),
                inputData.getQuestion(),
                inputData.getAnswer());
        outputBoundary.prepareSuccessView(outputData);
    }
}

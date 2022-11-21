package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * The use case interactor for editing cards given an input boundary
 */

import createCard.CreateCardInputBoundary;
import createCard.CreateCardOutputData;
import entities.Flashcard;
import entities.MCFlashcard;

public class EditCardInteractor implements EditCardInputBoundary {

    final EditCardOutputBoundary editCardOutputBoundary;

    public EditCardInteractor(EditCardOutputBoundary editCardOutputBoundary) {
        this.editCardOutputBoundary = editCardOutputBoundary;
    }

    @Override
    public void edit(EditCardInputData inputData) {
        Flashcard card = Flashcard.getTracker().get(inputData.getCardID());
        card.setQuestion(inputData.getQuestion());
        card.setAnswer(inputData.getQuestion());
        if (inputData.getOptions() != null) {
            ((MCFlashcard) card).setOptions(inputData.getOptions());
        }
        EditCardOutputData outputData = new EditCardOutputData(card, "Changes Made.");
        editCardOutputBoundary.prepareSuccessView(outputData);
    }
}

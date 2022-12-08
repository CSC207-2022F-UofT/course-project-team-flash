/*
 * Author: Albert Yan
 * Date: October 31/22
 * The use case interactor for editing cards given an input boundary
 */
package edit_card;

import entities.Flashcard;
import entities.MCFlashcard;

/**
 * This file contains implementation of the EditCardInteractor class.
 * It includes the instance attributes of EditCardInteractor,
 * and an edit method
 */
public class EditCardInteractor implements EditCardInputBoundary {

    final EditCardOutputBoundary editCardOutputBoundary;

    /**
     * Creates a new EditCardInteractor with a given EditCardOutputBoundary
     * @param editCardOutputBoundary an EditCardOutputBoundary
     */
    public EditCardInteractor(EditCardOutputBoundary editCardOutputBoundary) {
        this.editCardOutputBoundary = editCardOutputBoundary;
    }

    /**
     * Takes in an EditCardInputData and assigns a success or fail view to editCardOutputBoundary
     * @param inputData an EditCardInputData
     */
    @Override
    public void edit(EditCardInputData inputData) {
        String type = "QandAFlashcard";
        Flashcard card = Flashcard.getTracker().get(inputData.getCardID());
        card.setQuestion(inputData.getQuestion());
        card.setAnswer(inputData.getAnswer());
        if (inputData.getOptions() != null) {
            ((MCFlashcard) card).setOptions(inputData.getOptions());
            type = "MCFlashcard";
        }
        EditCardOutputData outputData = new EditCardOutputData(inputData.getCardID(),
                inputData.getQuestion(), inputData.getAnswer(), "Changes Made.", type);
        editCardOutputBoundary.prepareSuccessView(outputData);
    }
}

package createCard;

import entities.CardFactory;
import entities.Flashcard;

public class CreateCardInteractor implements CreateCardInputBoundary {

    final CreateCardOutputBoundary outputBoundary;
    final CardFactory cardFactory;

    public CreateCardInteractor(CreateCardOutputBoundary outputBoundary, CardFactory cardFactory) {
        this.outputBoundary = outputBoundary;
        this.cardFactory = cardFactory;
    }

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

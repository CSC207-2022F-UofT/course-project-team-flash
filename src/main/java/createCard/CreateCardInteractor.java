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
        Flashcard newCard = cardFactory.getCard(
                inputData.getType(),
                inputData.getQuestion(),
                inputData.getAnswer(),
                inputData.getOptions());

        Flashcard.addTracker(newCard.getUniqueID(), newCard);

        inputData.getDeck().addCard(newCard);

        CreateCardOutputData outputData = new CreateCardOutputData("Flashcard created.");
        outputBoundary.prepareSuccessView(outputData);
    }
}

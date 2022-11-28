package enterDeck;

import entities.Deck;
import entities.Flashcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EnterDeckInteractor implements EnterDeckInputBoundary {
    final EnterDeckOutputBoundary outputBoundary;

    public EnterDeckInteractor(EnterDeckOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void enter(EnterDeckInputData inputData) {
        Deck deck = Deck.getTracker().get(inputData.getDeckName());
        List<String> cardIDs = deck.getCardIds();

        List<List<String>> cardInfo = new ArrayList<>();
        Map<String, Flashcard> tracker = Flashcard.getTracker();

        for (String id : cardIDs) {
            Flashcard card = tracker.get(id);
            String question = card.getQuestion();
            String answer = card.getAnswer();

            List<String> tempList = new ArrayList<>();
            tempList.add(question);
            tempList.add(answer);

            cardInfo.add(tempList);
        }

        EnterDeckOutputData outputData = new EnterDeckOutputData(cardInfo);
        outputBoundary.prepareSuccessView(outputData);
    }
}

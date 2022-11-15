package startQuiz;

import entities.Deck;
import entities.Flashcard;
import entities.Quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StartQuizInteractor implements StartQuizInputBoundary{
    final StartQuizOutputBoundary outputBoundary;

    private StartQuizInteractor(StartQuizOutputBoundary outPutBoundary){
        this.outputBoundary = outPutBoundary;
    }

    @Override
    public StartQuizOutputData start(StartQuizInputData userInputData) {

        Quiz currQuiz = entities.Quiz.getQuiz(userInputData.getQuizId());

        if(currQuiz == null){
            return outputBoundary.prepareFailView("Quiz of name \"" + userInputData.getQuizId() + "\" does not exist.");
        }

        List<Deck> decks = currQuiz.getDecks();

        List<String> flashcardIds = new ArrayList<String>();

        //This is an inelegant way of doing this, but the deck class does not have a way to
        //access cardIDs without depending on the flashcard class in our GROUP's entity implementation.
        for(Deck deck:decks){
            for(Flashcard card:deck.getCards()){
                flashcardIds.add(card.getUniqueID());
            }
        }

        if (userInputData.getIsRandomized()){

            Collections.shuffle(flashcardIds);
        }

        StartQuizOutputData outputData = new StartQuizOutputData(flashcardIds);

        return outputBoundary.prepareSuccessView(outputData);


    }
}

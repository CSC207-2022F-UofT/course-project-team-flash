/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 * <p>
 * This file contains the implementation of the RunQuizInteractor class,
 * which implements RunQuizInputBoundary.
 */

package run_quiz;

import entities.Deck;
import entities.Flashcard;
import entities.MCFlashcard;
import entities.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunQuizInteractor implements RunQuizInputBoundary {


    final RunQuizOutputBoundary outputBoundary;

    /**
     * Creates a new RunQuizInteractor with the given output boundary.
     *
     * @param outputBoundary the RunQuizOutputBoundary associated with the quiz to be run
     */
    public RunQuizInteractor(RunQuizOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Creates a StartQuizOutputData and passes it to the presenter.
     * If the quiz does not exist, gives fail view output data;
     * otherwise, returns success view output data.
     *
     * @param inputData the StartQuizInputData associated with the quiz to be run
     */
    @Override
    public void startQuiz(StartQuizInputData inputData) {

        //Get the quiz object corresponding the ID given.
        Quiz currQuiz = entities.Quiz.getQuiz(inputData.getQuizId());

        //Check if quiz doesn't exist.
        if (currQuiz == null) {
            outputBoundary.quizFailView("Quiz of name \"" + inputData.getQuizId() + "\" does not exist.");
            return;
        }

        //Check if quiz is empty.
        else if (quizEmpty(currQuiz)){
            outputBoundary.quizFailView("Quiz is empty. A quiz with no flashcards cannot be run.");
            return;
        }

        //Get a list of flashcard IDs corresponding to each flashcard within the quiz.
        List<String> flashcardIdList = fetchQuizCardIds(currQuiz);
        if (inputData.getIsRandomized()) {
            Collections.shuffle(flashcardIdList);
        }

        //Convert list to array because quiz contents should not change while running.
        //Also get the first card's problem and answer.
        String[] flashcardIds = flashcardIdList.toArray(new String[0]);
        Flashcard firstCard = Flashcard.getTracker().get(flashcardIds[0]);
        String firstCardProblem = firstCard.getQuestion();
        String firstCardAnswer = firstCard.getAnswer();

        //Return the options of the first card if it is a multiple choice card.
        List<String> firstCardOptions = null;

        if(firstCard instanceof MCFlashcard){
            firstCardOptions = ((MCFlashcard) firstCard).getOptions();
        }

        //Pass information to presenter through the outputBoundary.
        StartQuizOutputData outputData = new StartQuizOutputData(flashcardIds, firstCardProblem,
                firstCardAnswer ,firstCardOptions);

        outputBoundary.prepareSuccessView(outputData);
    }

    /**
     * Creates a ShowProblemOutputData and passes it to the presenter.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     */
    @Override
    public void showProblem(ShowQuizCardInputData inputData) {

        //Gets the flashcard object corresponding to the given ID.
        Flashcard currCard = fetchCard(inputData);

        //If the card is a multiple choice card, get its options.
        List<String> options = null;

        if(currCard instanceof MCFlashcard){
            options = ((MCFlashcard) currCard).getOptions();
        }

        //Pass data to the presenter through the output boundary.
        ShowProblemOutputData outputData = new ShowProblemOutputData(inputData.getFlashcardIdList(),
                inputData.getCurrCardIndex(),
                currCard.getQuestion(),
                currCard.getAnswer(),
                options
        );

        outputBoundary.prepareSuccessView(outputData);
    }

    /**
     * Creates a ShowAnswerOutputData and passes it to the presenter.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     */
    @Override
    public void showAnswer(ShowQuizCardInputData inputData) {
        //Get the flashcard object corresponding to the given id.
        Flashcard currCard = fetchCard(inputData);

        //Pass the data to the presenter through the output boundary and increase the index by 1.
        ShowAnswerOutputData outputData = new ShowAnswerOutputData(inputData.getFlashcardIdList(),
                inputData.getCurrCardIndex(),
                inputData.getUserAnswer(),
                currCard.getAnswer());

        outputData.incCurrCardIndex(1);

        outputBoundary.prepareSuccessView(outputData);
    }

    /**
     * This is a private method that returns the flashcard to be shown.
     * This method is only used in the showProblem and showAnswer methods.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     * @return the flashcard object
     */
    private Flashcard fetchCard(ShowQuizCardInputData inputData) {
        if(inputData.getCurrCardIndex() >= inputData.getFlashcardIdList().length){
            return Flashcard.getTracker().get(inputData.getFlashcardIdList()[0]);
        }
        return Flashcard.getTracker().get(inputData.getFlashcardIdList()[inputData.getCurrCardIndex()]);
    }

    /**
     * This is a private method that returns a list of flashcard IDs in this quiz.
     * This method is only used in the startQuiz method.
     *
     * @param quiz this quiz object
     * @return a list of flashcard IDs in this quiz
     */
    private ArrayList<String> fetchQuizCardIds(Quiz quiz) {

        ArrayList<String> flashcardIdList = new ArrayList<>();
        //Iterate through each flashcard in each deck of the quiz and get its ID.
        for (Deck deck : quiz.getDecks()) {
            for (Flashcard card : deck.getCards()) {
                flashcardIdList.add(card.getUniqueID());
            }
        }

        return flashcardIdList;
    }

    /**
     * This is a private method that checks whether a quiz contains any flashcards or not.
     * @param quiz the quiz to check
     * @return true if the quiz has no flashcards, else false.
     */
    private boolean quizEmpty(Quiz quiz) {
        //Iterate through each deck in the quiz
        for(Deck deck : quiz.getDecks()) {
            //If any deck has at least 1 card, then the quiz is not empty.
            if(deck.getCardIds().size() > 0) {
                return false;
            }
        }

        return true;

    }

}

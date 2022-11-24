/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the RunQuizInteractor class,
 * which implements RunQuizInputBoundary.
 */

package runQuiz;

import entities.Deck;
import entities.Flashcard;
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
     * Returns a StartQuizOutputData given the input data.
     * If the quiz does not exist, gives fail view output data;
     * otherwise, returns success view output data.
     *
     * @param inputData the StartQuizInputData associated with the quiz to be run
     * @return a StartQuizOutputData associated with the quiz to be run
     */
    @Override
    public StartQuizOutputData startQuiz(StartQuizInputData inputData) {

        Quiz currQuiz = entities.Quiz.getQuiz(inputData.getQuizId());

        if(currQuiz == null){
            return outputBoundary.quizFailView("Quiz of name \"" + inputData.getQuizId() + "\" does not exist.");
        }

        List<String> flashcardIdList = fetchQuizCardIds(currQuiz);

        if (inputData.getIsRandomized()){
            Collections.shuffle(flashcardIdList);
        }

        String[] flashcardIds = flashcardIdList.toArray(new String[0]);

        StartQuizOutputData outputData = new StartQuizOutputData(flashcardIds);

        return outputBoundary.prepareSuccessView(outputData);
    }

    /**
     * Returns a ShowProblemOutputData given the input data.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     * @return a ShowProblemOutputData associated with the problem to be shown
     */
    @Override
    public ShowProblemOutputData showProblem(ShowQuizCardInputData inputData) {

        Flashcard currCard = fetchCard(inputData);

        ShowProblemOutputData outputData = new ShowProblemOutputData(inputData.getFlashcardIdList(),
                inputData.getCurrCardIndex(),
                currCard.getQuestion()
                );

        return outputBoundary.prepareSuccessView(outputData);
    }

    /**
     * Returns a ShowAnswerOutputData given the input data.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     * @return a ShowAnswerOutputData associated with the answer for this problem
     */
    @Override
    public ShowAnswerOutputData showAnswer(ShowQuizCardInputData inputData) {

        Flashcard currCard = fetchCard(inputData);

        ShowAnswerOutputData outputData = new ShowAnswerOutputData(inputData.getFlashcardIdList(),
                inputData.getCurrCardIndex(),
                inputData.getUserAnswer(),
                currCard.getAnswer());

        outputData.incCurrCardIndex(1);

        return outputBoundary.prepareSuccessView(outputData);
    }

    /**
     * This is a private method that returns the flashcard to be shown.
     * This method is only used in the showProblem and showAnswer methods.
     *
     * @param inputData the ShowQuizCardInputData associated with the flashcard to be shown
     * @return the flashcard object
     */
    private Flashcard fetchCard(ShowQuizCardInputData inputData){
        return Flashcard.getTracker().get(inputData.getFlashcardIdList()[inputData.getCurrCardIndex()]);
    }

    /**
     * This is a private method that returns a list of flashcard IDs in this quiz.
     * This method is only used in the startQuiz method.
     *
     * @param quiz this quiz object
     * @return a list of flashcard IDs in this quiz
     */
    private List<String> fetchQuizCardIds(Quiz quiz){

        List<String> flashcardIdList = new ArrayList<String>();

        for(Deck deck:quiz.getDecks()){
            for(Flashcard card:deck.getCards()){
                flashcardIdList.add(card.getUniqueID());
            }
        }

        return flashcardIdList;
    }
}

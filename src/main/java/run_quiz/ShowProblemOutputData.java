/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 * This file contains the implementation of the ShowProblemOutputData class.
 * It includes the instance attributes of the ShowProblemOutputData class and
 * their getter methods.
 * It also includes the setter method for viewState and a method to determine
 * if there is no more problem in this quiz.
 */

package run_quiz;

import java.util.List;

public class ShowProblemOutputData {

    private final String[] flashcardIdList;
    private final int currCardIndex;
    private final String currCardQuestion;
    private final String currCardAnswer;
    private final List<String> cardOptions;

    /**
     * Creates a new ShowProblemOutputData given a list of flashcard IDs, the index of the
     * current flashcard, and the current flashcard's question.
     *
     * @param flashcardIdList a list of flashcard IDs
     * @param currCardIndex the index of the current flashcard in flashcardIdList
     * @param currCardQuestion the question on the current flashcard
     * @param currCardAnswer the answer on the current flashcard
     */
    public ShowProblemOutputData(String[] flashcardIdList, int currCardIndex,
                                 String currCardQuestion, String currCardAnswer, List<String> cardOptions){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.currCardQuestion = currCardQuestion;
        this.currCardAnswer = currCardAnswer;
        this.cardOptions = cardOptions;
    }

    /**
     * Returns the flashcardIdList of this ShowProblemOutputData.
     *
     * @return the flashcardIdList of this ShowProblemOutputData
     */
    String[] getFlashcardIdList(){
        return this.flashcardIdList;
    }

    /**
     * Returns the currCardIndex of this ShowProblemOutputData.
     *
     * @return the currCardIndex of this ShowProblemOutputData
     */
    int getCurrCardIndex(){
        return this.currCardIndex;
    }

    /**
     * Returns the currCardQuestion of this ShowProblemOutputData.
     *
     * @return the currCardQuestion of this ShowProblemOutputData
     */
    String getCurrCardQuestion(){
        return this.currCardQuestion;
    }

    /**
     * Returns the currCardAnswer of this ShowProblemOutputData.
     *
     * @return the currCardAnswer of this ShowProblemOutputData
     */
    String getCurrCardAnswer(){
        return this.currCardAnswer;
    }

    /**
     * Returns the cardOptions of the outputData object.
     *
     * @return a list of Strings if the card is a multiple choice, else null.
     */
    List<String> getCardOptions(){
        return this.cardOptions;
    }

    /**
     * Return if there is no more problems in this quiz.
     *
     * @return a boolean value indicating if there is no more problems in this quiz
     */
    public boolean noMoreProblems() {
        return this.getCurrCardIndex() >= this.flashcardIdList.length;
    }
}

/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the ShowAnswerOutputData class.
 * It includes the instance attributes of the ShowAnswerOutputData class and
 * their getter methods.
 * It also includes the setter method for viewState and a method to increment
 * currCardIndex.
 */

package runQuiz;

import screens.viewStates;

import java.util.List;

public class ShowAnswerOutputData {

    private final String[] flashcardIdList;

    private int currCardIndex;

    private final String userAnswer;
    private final String currCardAnswer;

    private viewStates viewState;

    /**
     * Creates a new ShowAnswerOutputData given a list of flashcard IDs, the index of the
     * current flashcard, the user's answer, and the current flashcard's answer.
     *
     * @param flashcardIdList a list of flashcard IDs
     * @param currCardIndex the index of the current flashcard in flashcardIdList
     * @param userAnswer the user's answer to this flashcard problem
     * @param currCardAnswer the correct answer to this flashcard problem
     */
    ShowAnswerOutputData(String[] flashcardIdList, int currCardIndex, String userAnswer, String currCardAnswer){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.userAnswer = userAnswer;
        this.currCardAnswer = currCardAnswer;
        this.viewState = null;
    }

    /**
     * Returns the flashcardIdList of this ShowAnswerOutputData.
     *
     * @return the flashcardIdList of this ShowAnswerOutputData
     */
    public String[] getFlashcardIdList(){
        return this.flashcardIdList;
    }

    /**
     * Returns the currCardIndex of this ShowAnswerOutputData.
     *
     * @return the currCardIndex of this ShowAnswerOutputData
     */
    public int getCurrCardIndex(){
        return this.currCardIndex;
    }

    /**
     * Returns the userAnswer of this ShowAnswerOutputData.
     *
     * @return the userAnswer of this ShowAnswerOutputData
     */
    public String getUserAnswer(){
        return this.userAnswer;
    }

    /**
     * Returns the currCardAnswer of this ShowAnswerOutputData.
     *
     * @return the currCardAnswer of this ShowAnswerOutputData
     */
    public String getCurrCardAnswer(){
        return this.currCardAnswer;
    }

    /**
     * Returns the viewState of this ShowAnswerOutputData.
     *
     * @return the viewState of this ShowAnswerOutputData
     */
    public viewStates getViewState(){
        return this.viewState;
    }

    /**
     * Set the viewState of this ShowAnswerOutputData.
     *
     * @param state the viewStates object to be set as viewState of this ShowAnswerOutputData
     */
    public void setViewState(viewStates state){
        this.viewState = state;
    }

    /**
     * Increment currCardIndex by the given increment.
     *
     * @param increment the amount to be incremented
     */
    public void incCurrCardIndex(int increment){
        this.currCardIndex += increment;
    }
}

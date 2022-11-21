/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the ShowProblemOutputData class.
 * It includes the instance attributes of the ShowProblemOutputData class and
 * their getter methods.
 * It also includes the setter method for viewState and a method to determine
 * if there is no more problem in this quiz.
 */

package runQuiz;

import screens.viewStates;
import static screens.viewStates.SHOW_PROBLEM;

public class ShowProblemOutputData {
    private final String[] flashcardIdList;
    private final int currCardIndex;

    private final String currCardQuestion;
    private viewStates viewState;

    /**
     * Creates a new ShowProblemOutputData given a list of flashcard IDs, the index of the
     * current flashcard, and the current flashcard's question.
     *
     * @param flashcardIdList a list of flashcard IDs
     * @param currCardIndex the index of the current flashcard in flashcardIdList
     * @param currCardQuestion the question on the current flashcard
     */
    public ShowProblemOutputData(String[] flashcardIdList, int currCardIndex, String currCardQuestion){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.currCardQuestion = currCardQuestion;
        this.viewState = null;
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
     * Returns the viewState of this ShowProblemOutputData.
     *
     * @return the viewState of this ShowProblemOutputData
     */
    public viewStates getViewState(){
        return this.viewState;
    }

    /**
     * Set the viewState of this ShowProblemOutputData.
     *
     * @param state the viewStates object to be set as viewState of this ShowProblemOutputData
     */
    public void setViewState(viewStates state){
        this.viewState = state;
    }

    /**
     * Return if there is no more problems in this quiz.
     *
     * @return a boolean value indicating if there is no more problems in this quiz
     */
    public boolean noMoreProblems(){
        if(this.getCurrCardIndex() >= this.flashcardIdList.length){
            return true;
        }

        return false;
    }
}

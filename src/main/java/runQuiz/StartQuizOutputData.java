/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the StartQuizOutputData class.
 * It includes the instance attributes of the ShowProblemOutputData class and
 * their getter methods. It also includes the setter method for viewState.
 */

package runQuiz;

import screens.ViewState;

public class StartQuizOutputData {
    private final String[] flashcardIds;

    private int currCardIndex;
    private ViewState viewState;

    /**
     * Creates a new StartQuizOutputData given a list of flashcard IDs.
     *
     * @param flashcardIds a list of flashcard IDs
     */
    StartQuizOutputData(String[] flashcardIds){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.viewState = null;
    }

    /**
     * Returns the flashcardIds of this StartQuizOutputData.
     *
     * @return the flashcardIds of this StartQuizOutputData
     */
    public String[] getFlashcardIdList(){
        return this.flashcardIds;
    }

    /**
     * Returns the viewState of this StartQuizOutputData.
     *
     * @return the viewState of this StartQuizOutputData
     */
    public viewStates getViewState(){
        return this.viewState;
    }

    /**
     * Set the viewState of this StartQuizOutputData.
     *
     * @param state the viewStates object to be set as viewState of this StartQuizOutputData
     */
    public void setViewState(viewStates state){
        this.viewState = state;
    }
}

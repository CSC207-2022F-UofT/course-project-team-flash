/**
 * Author: Jamie Chew
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains implementation of the ShowQuizCardInputData class.
 * It includes two overloaded constructor methods for ShowQuizCardInputData,
 * one with user answer, and the other without.
 * It also includes the instance attributes of CreateQuizInputData and
 * the getter methods for them.
 */

package runQuiz;

public class ShowQuizCardInputData {

    private final String[] flashcardIdList;

    private int currCardIndex;

    private final String userAnswer;

    /**
     * Creates a new ShowQuizCardInputData with the given list of flashcard IDs, the current
     * flashcard index in the list, and a user answer.
     *
     * @param flashcardIdList a list of flashcard IDs in this quiz
     * @param currCardIndex the index of the current flashcard in flashcardIdList
     * @param userAnswer the user's answer to this flashcard problem
     */
    public ShowQuizCardInputData(String[] flashcardIdList, int currCardIndex, String userAnswer){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.userAnswer = userAnswer;
    }

    /**
     * Creates a newShowQuizCardInputData with the given list of flashcard IDs and the current
     * flashcard index in the list.
     * userAnswer of this ShowQuizCardInputData will be set to null.
     *
     * @param flashcardIdList a list of flashcard IDs in this quiz
     * @param currCardIndex the index of the current flashcard in flashcardIdList
     */
    public ShowQuizCardInputData(String[] flashcardIdList, int currCardIndex){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.userAnswer = null;
    }

    /**
     * Returns the flashcardIdList of this ShowQuizCardInputData.
     *
     * @return the flashcardIdList of this ShowQuizCardInputData
     */
    public String[] getFlashcardIdList(){
        return this.flashcardIdList;
    }

    /**
     * Returns the currCardIndex of this ShowQuizCardInputData.
     *
     * @return the currCardIndex of this ShowQuizCardInputData
     */
    public int getCurrCardIndex(){
        return this.currCardIndex;
    }

    /**
     * Returns the userAnswer of this ShowQuizCardInputData.
     *
     * @return the userAnswer of this ShowQuizCardInputData
     */
    public String getUserAnswer(){
        return this.userAnswer;
    }


}

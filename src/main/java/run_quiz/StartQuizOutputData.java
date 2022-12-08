/**
 * Author: Jamie Chew
 * Documentation Author: Jamie Chew
 * Date: December 7th, 2022
 * This file contains implementation of the StartQuizOutputData class.
 * It contains a constructor, the instance attributes of StartQuizOutputData,
 * and the getter methods for them.
 */


package run_quiz;

import java.util.List;

public class StartQuizOutputData {
    private final String[] flashcardIds;
    private final int currCardIndex;
    private final String firstCardProblem;
    private final String firstCardAnswer;
    private final List<String> firstCardOptions;

    /**
     * Create a new StartQuizOutputData object that stores an array of flashcard IDs, the index of the current
     * flashcard, the question and answer to the first flashcard, and a list of flashcard IDs.
     * @param flashcardIds The flashcards within the current quiz.
     * @param firstCardProblem The question to the first flashcard.
     * @param firstCardAnswer The answer to the first flashcard.
     * @param firstCardOptions The options for the first flashcard (null if not an MCFlashcard)
     */
    StartQuizOutputData(String[] flashcardIds, String firstCardProblem, String firstCardAnswer,List<String> firstCardOptions){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.firstCardProblem = firstCardProblem;
        this.firstCardAnswer = firstCardAnswer;
        this.firstCardOptions = firstCardOptions;
    }

    /**
     * Get the array of flashcard IDs stored in the StartQuizOutputData object.
     * @return the IDs of the flashcards within the quiz.
     */
    public String[] getFlashcardIdList(){
        return this.flashcardIds;
    }

    /**
     * Get the current flashcard index stored in the StartQuizOutputData object.
     * @return the index of the current flashcard in the quiz. (Automatically set to 0)
     */
    public int getCurrCardIndex(){
        return this.currCardIndex;
    }

    /**
     * Get the question for the first card in the quiz stored in the StartQuizOutputData object.
     * @return The first card's question in the quiz.
     */
    public String getFirstCardProblem(){
        return this.firstCardProblem;
    }

    /**
     * Get the answer for the first card in the quiz stored in the StartQuizOutputData object.
     * @return The first card's answer in the quiz.
     */
    public String getFirstCardAnswer() {
        return this.firstCardAnswer;
    }

    /**
     * Get the list of card options for the first card in the quiz stored in the StartQuizOutputData object.
     * @return The first card's options in the quiz.
     */
    public List<String> getFirstCardOptions(){
        return this.firstCardOptions;
    }

}

package runQuiz;

import screens.ViewState;

public class StartQuizOutputData {
    private final String[] flashcardIds;
    private int currCardIndex;

    private String firstCardProblem;


  
    StartQuizOutputData(String[] flashcardIds, String firstCardProblem){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.firstCardProblem = firstCardProblem;
    }

    /**
     * Returns the flashcard IDs as a String array.
     *
     * @return the flashcard IDs.
     */
    public String[] getFlashcardIdList(){
        return this.flashcardIds;
    }

    /**
     * Returns the current flashcard list index.
     *
     * @return the current flascard index.
     */
    public int getCurrCardIndex(){
        return this.currCardIndex;
    }

    public String getFirstCardProblem(){
        return this.firstCardProblem;
    }

}

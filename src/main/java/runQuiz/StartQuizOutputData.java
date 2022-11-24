package runQuiz;

import screens.ViewState;

public class StartQuizOutputData {
    private final String[] flashcardIds;
    private int currCardIndex;
    private ViewState viewState;


    /**
     * Creates a new StartQuizOutputData object given a list of flashcard IDs.
     *
     * @param flashcardIds
     */
    StartQuizOutputData(String[] flashcardIds){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.viewState = null;
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

}

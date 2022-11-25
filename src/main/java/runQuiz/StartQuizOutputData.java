package runQuiz;

import screens.ViewState;

public class StartQuizOutputData {
    private final String[] flashcardIds;
    private int currCardIndex;
    private ViewState viewState;



    StartQuizOutputData(String[] flashcardIds){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.viewState = null;
    }

    public String[] getFlashcardIdList(){
        return this.flashcardIds;
    }

    public int getCurrCardIndex(){
        return this.currCardIndex;
    }

}

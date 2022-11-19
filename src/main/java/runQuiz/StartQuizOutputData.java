package runQuiz;

import screens.viewStates;

import java.util.List;

public class StartQuizOutputData {
    private final String[] flashcardIds;

    private int currCardIndex;
    private viewStates viewState;



    StartQuizOutputData(String[] flashcardIds){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.viewState = null;
    }

    public String[] getFlashcardIdList(){
        return this.flashcardIds;
    }

    public viewStates getViewState(){
        return this.viewState;
    }

    public void setViewState(viewStates state){
        this.viewState = state;
    }
}

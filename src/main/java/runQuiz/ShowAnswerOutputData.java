package runQuiz;

import screens.viewStates;

import java.util.List;

public class ShowAnswerOutputData {

    private final String[] flashcardIdList;

    private int currCardIndex;

    private final String userAnswer;
    private final String currCardAnswer;

    private viewStates viewState;

    ShowAnswerOutputData(String[] flashcardIdList, int currCardIndex, String userAnswer, String currCardAnswer){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.userAnswer = userAnswer;
        this.currCardAnswer = currCardAnswer;
        this.viewState = null;
    }

    public String[] getFlashcardIdList(){
        return this.flashcardIdList;
    }

    public int getCurrCardIndex(){
        return this.currCardIndex;
    }

    public String getUserAnswer(){
        return this.userAnswer;
    }

    public String getCurrCardAnswer(){
        return this.currCardAnswer;
    }

    public viewStates getViewState(){
        return this.viewState;
    }

    public void setViewState(viewStates state){
        this.viewState = state;
    }

    public void incCurrCardIndex(int increment){
        this.currCardIndex += increment;
    }
}

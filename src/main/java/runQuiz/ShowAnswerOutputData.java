package runQuiz;

import screens.ViewState;

public class ShowAnswerOutputData {

    private final String[] flashcardIdList;

    private int currCardIndex;

    private final String userAnswer;
    private final String currCardAnswer;

    private ViewState viewState;

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

    public ViewState getViewState(){
        return this.viewState;
    }

    public void setViewState(ViewState state){
        this.viewState = state;
    }

    public void incCurrCardIndex(int increment){
        this.currCardIndex += increment;
    }
}

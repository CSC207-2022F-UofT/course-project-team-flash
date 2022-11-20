package runQuiz;

import screens.viewStates;
import static screens.viewStates.SHOW_PROBLEM;

public class ShowProblemOutputData {
    private final String[] flashcardIdList;
    private final int currCardIndex;

    private final String currCardQuestion;
    private viewStates viewState;


    public ShowProblemOutputData(String[] flashcardIdList, int currCardIndex, String currCardQuestion){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.currCardQuestion = currCardQuestion;
        this.viewState = null;
    }
    
    String[] getFlashcardIdList(){
        return this.flashcardIdList;
    }
    
    int getCurrCardIndex(){
        return this.currCardIndex;
    }

    String getCurrCardQuestion(){
        return this.currCardQuestion;
    }

    public viewStates getViewState(){
        return this.viewState;
    }

    public void setViewState(viewStates state){
        this.viewState = state;
    }

    public boolean noMoreProblems(){
        if(this.getCurrCardIndex() >= this.flashcardIdList.length){
            return true;
        }

        return false;
    }
}

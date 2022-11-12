package showProblem;

public class ShowProblemOutputData {
    final String[] flashcardIdList;
    final int currCardIndex;

    ShowProblemOutputData(String[] flashcardIdList, int currCardIndex){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
    }
    
    String[] getFlashcardIdList(){
        return this.flashcardIdList;
    }
    
    int getCurrCardIndex(){
        return this.currCardIndex;
    }
}

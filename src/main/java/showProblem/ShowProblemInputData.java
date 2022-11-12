package showProblem;

import java.util.ArrayList;

public class ShowProblemInputData {
    final String[] flashcardIdList;
    final int currCardIndex;

    public ShowProblemInputData(String[] flashcardIdList, int currCardIndex) {
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

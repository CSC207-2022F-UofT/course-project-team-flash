package showProblem;

import java.util.ArrayList;

public class ShowProblemInputData {
    final ArrayList<String> flashcardIdList;
    final int currCardIndex;

    public ShowProblemInputData(ArrayList<String> flashcardIdList, int currCardIndex) {
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
    }

    ArrayList<String> getFlashcardIdList(){
        return this.flashcardIdList;
    }

    int getCurrCardIndex(){
        return this.currCardIndex;
    }
}

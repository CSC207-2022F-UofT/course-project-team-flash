package startQuiz;

import java.util.List;

public class StartQuizOutputData {
    private final List<String> flashcardIdList;

    StartQuizOutputData(List<String> flashcardIds){
        this.flashcardIdList = flashcardIds;
    }

    private List<String> getFlashcardIdList(){
        return this.flashcardIdList;
    }
}

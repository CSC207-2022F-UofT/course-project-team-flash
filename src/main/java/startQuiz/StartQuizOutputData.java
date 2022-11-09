package startQuiz;

public class StartQuizOutputData {
    private final String[] flashcardIdList;

    private StartQuizOutputData(String[] flashcardIds){
        this.flashcardIdList = flashcardIds;
    }

    private String[] getFlashcardIdList(){
        return this.flashcardIdList;
    }
}

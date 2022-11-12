package showAnswer;

public class ShowAnswerOutputData {

    private final String[] flashcardIdList;

    private int currCardIndex;

    private final String userAnswer;

    ShowAnswerOutputData(String[] flashcardIdList, int currCardIndex, String userAnswer){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.userAnswer = userAnswer;
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

    public void incCurrCardIndex(int increment){
        this.currCardIndex += increment;
    }
}

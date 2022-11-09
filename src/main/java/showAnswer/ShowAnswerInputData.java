package showAnswer;

public class ShowAnswerInputData {

    final String[] flashcardIdList;

    final int currCardIndex;

    final String userAnswer;

    ShowAnswerInputData(String[] flashcardIdList, int currCardIndex, String userAnswer){
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

}

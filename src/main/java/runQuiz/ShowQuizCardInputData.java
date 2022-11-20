package runQuiz;

public class ShowQuizCardInputData {

    private final String[] flashcardIdList;

    private int currCardIndex;

    private final String userAnswer;

    public ShowQuizCardInputData(String[] flashcardIdList, int currCardIndex, String userAnswer){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.userAnswer = userAnswer;
    }

    public ShowQuizCardInputData(String[] flashcardIdList, int currCardIndex){
        this.flashcardIdList = flashcardIdList;
        this.currCardIndex = currCardIndex;
        this.userAnswer = null;
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

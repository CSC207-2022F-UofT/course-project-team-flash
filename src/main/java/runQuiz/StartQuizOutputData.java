package runQuiz;

import screens.ViewState;

public class StartQuizOutputData {
    private final String[] flashcardIds;
    private int currCardIndex;

    private String firstCardProblem;




    StartQuizOutputData(String[] flashcardIds, String firstCardProblem){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.firstCardProblem = firstCardProblem;
    }

    public String[] getFlashcardIdList(){
        return this.flashcardIds;
    }

    public int getCurrCardIndex(){
        return this.currCardIndex;
    }

    public String getFirstCardProblem(){
        return this.firstCardProblem;
    }

}

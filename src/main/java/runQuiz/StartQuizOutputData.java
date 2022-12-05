package runQuiz;

import java.util.List;

public class StartQuizOutputData {
    private final String[] flashcardIds;
    private int currCardIndex;
    private String firstCardProblem;
    private String firstCardAnswer;
    private List<String> firstCardOptions;

    StartQuizOutputData(String[] flashcardIds, String firstCardProblem, String firstCardAnswer,List<String> firstCardOptions){
        this.flashcardIds = flashcardIds;
        this.currCardIndex = 0;
        this.firstCardProblem = firstCardProblem;
        this.firstCardAnswer = firstCardAnswer;
        this.firstCardOptions = firstCardOptions;
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

    public String getFirstCardAnswer() {
        return this.firstCardAnswer;
    }

    public List<String> getFirstCardOptions(){
        return this.firstCardOptions;
    }

}

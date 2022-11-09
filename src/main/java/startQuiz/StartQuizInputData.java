package startQuiz;

public class StartQuizInputData {
    private final String quizId;
    private final boolean isRandomized;

    public StartQuizInputData(String quizId, Boolean isRandomized) {
        this.quizId = quizId;
        this.isRandomized = isRandomized;
    }

    private String getQuizId(){
        return this.quizId;
    }

    private boolean getIsRandomized(){
        return this.isRandomized;
    }
}


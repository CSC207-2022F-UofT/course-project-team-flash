package runQuiz;

public class StartQuizInputData {
    private final String quizId;
    private final boolean isRandomized;

    public StartQuizInputData(String quizId, Boolean isRandomized) {
        this.quizId = quizId;
        this.isRandomized = isRandomized;
    }

    public String getQuizId(){
        return this.quizId;
    }

    public boolean getIsRandomized(){
        return this.isRandomized;
    }
}


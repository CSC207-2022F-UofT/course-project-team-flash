package startQuiz;

public class StartQuizController {

    final StartQuizInputBoundary quizStartInputBound;

    public StartQuizController(StartQuizInputBoundary quizStartInput) {
        this.quizStartInputBound = quizStartInput;
    }

    StartQuizOutputData start(String quizId, Boolean isRandomized) {
        StartQuizInputData requestModel = new StartQuizInputData(quizId, isRandomized);

        return quizStartInputBound.start(requestModel);
    }

}

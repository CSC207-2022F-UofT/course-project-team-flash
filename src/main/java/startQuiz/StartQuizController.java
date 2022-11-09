package startQuiz;

public class StartQuizController {

    final StartQuizInputBoundary quizStartInput;

    public StartQuizController(StartQuizInputBoundary quizStartInput) {
        this.quizStartInput = quizStartInput;
    }

    StartQuizOutputData start(String quizId, Boolean isRandomized) {
        StartQuizInputData requestModel = new StartQuizInputData(quizId, isRandomized);

        return quizStartInput.start(requestModel);
    }

}

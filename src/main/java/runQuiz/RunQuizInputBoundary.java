package runQuiz;

public interface RunQuizInputBoundary {

    void startQuiz(StartQuizInputData inputData);

    void showProblem(ShowQuizCardInputData inputData);

    void showAnswer(ShowQuizCardInputData inputData);

}

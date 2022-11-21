package runQuiz;

public interface RunQuizOutputBoundary {

    void prepareSuccessView(ShowAnswerOutputData outputData);

    void prepareSuccessView(ShowProblemOutputData outputData);

    void prepareSuccessView(StartQuizOutputData outputData);

    void quizFailView(String error);
}

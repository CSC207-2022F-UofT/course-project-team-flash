package runQuiz;

public interface RunQuizOutputBoundary {

    ShowAnswerOutputData prepareSuccessView(ShowAnswerOutputData outputData);

    ShowProblemOutputData prepareSuccessView(ShowProblemOutputData outputData);

    StartQuizOutputData prepareSuccessView(StartQuizOutputData outputData);

    StartQuizOutputData quizFailView(String error);
}

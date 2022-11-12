package startQuiz;

public interface StartQuizOutputBoundary {

    StartQuizOutputData prepareSuccessView(StartQuizOutputData outputData);

    StartQuizOutputData prepareFailView(String error);
}

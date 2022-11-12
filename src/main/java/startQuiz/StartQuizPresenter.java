package startQuiz;

public class StartQuizPresenter implements StartQuizOutputBoundary{
    @Override
    public StartQuizOutputData prepareSuccessView(StartQuizOutputData outputData) {
        return null;
    }

    @Override
    public StartQuizOutputData prepareFailView(String error) {
        return null;
    }
}

package startQuiz;

public class StartQuizInteractor implements StartQuizInputBoundary{
    final StartQuizOutputBoundary outputBoundary;

    private StartQuizInteractor(StartQuizOutputBoundary outPutBoundary){
        this.outputBoundary = outPutBoundary;
    }

    @Override
    public StartQuizOutputData start(StartQuizInputData userInputData) {
        return null;
    }
}

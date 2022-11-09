package showAnswer;

public class ShowAnswerInteractor implements ShowAnswerInputBoundary{

    final ShowAnswerOutputBoundary outputBoundary;

    ShowAnswerInteractor(ShowAnswerOutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ShowAnswerOutputData show(ShowAnswerInputData userInputData) {
        return null;
    }
}

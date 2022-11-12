package showAnswer;

public class ShowAnswerPresenter implements ShowAnswerOutputBoundary{

    @Override
    public ShowAnswerOutputData prepareSuccessView(ShowAnswerOutputData outputData) {
        outputData.incCurrCardIndex(1);
        return outputData;
    }

    @Override
    public ShowAnswerOutputData prepareFailView(ShowAnswerOutputData outputData) {
        return null;
    }
}

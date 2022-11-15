package showAnswer;

public class ShowAnswerPresenter implements ShowAnswerOutputBoundary{

    /**
     * Increase the current index of the flashcard list by one.
     *
     * @param outputData data object to be modified
     * @return outputData modified data object
     */
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

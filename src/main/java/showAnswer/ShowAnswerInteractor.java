package showAnswer;

public class ShowAnswerInteractor implements ShowAnswerInputBoundary{

    final ShowAnswerOutputBoundary outputBoundary;

    ShowAnswerInteractor(ShowAnswerOutputBoundary outputBoundary){
        this.outputBoundary = outputBoundary;
    }

    @Override
    public ShowAnswerOutputData show(ShowAnswerInputData userInputData) {

        ShowAnswerOutputData outputData = new ShowAnswerOutputData(userInputData.getFlashcardIdList(),
                userInputData.getCurrCardIndex(),
                userInputData.getUserAnswer());

        return outputBoundary.prepareSuccessView(outputData);
    }
}

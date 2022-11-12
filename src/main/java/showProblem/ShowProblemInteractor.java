package showProblem;



public class ShowProblemInteractor implements ShowProblemInputBoundary{

    final ShowProblemOutputBoundary outputBoundary;

    ShowProblemInteractor(ShowProblemOutputBoundary outPutBoundary){
        this.outputBoundary = outPutBoundary;
    }


    @Override
    public ShowProblemOutputData show(ShowProblemInputData userInputData) {

        if(userInputData.getCurrCardIndex() == userInputData.getFlashcardIdList().length - 1){
            return outputBoundary.prepareFailView("End of quiz.");
        }

        ShowProblemOutputData outputData = new ShowProblemOutputData(userInputData.getFlashcardIdList(),
                userInputData.getCurrCardIndex());

        return outputBoundary.prepareSuccessView(outputData);
    }
}

package showProblem;

public class ShowProblemInteractor implements ShowProblemInputBoundary{

    final ShowProblemOutputBoundary outputBoundary;

    private ShowProblemInteractor(ShowProblemOutputBoundary outPutBoundary){
        this.outputBoundary = outPutBoundary;
    }


    @Override
    public ShowProblemOutputData show(ShowProblemInputData userInputData) {
        return null;
    }
}

package showProblem;

public interface ShowProblemOutputBoundary {

    ShowProblemOutputData prepareSuccessView(ShowProblemOutputData outputData);

    ShowProblemOutputData prepareFailView(String error);
}

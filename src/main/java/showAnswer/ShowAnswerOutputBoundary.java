package showAnswer;

public interface ShowAnswerOutputBoundary {

    ShowAnswerOutputData prepareSuccessView(ShowAnswerOutputData outputData);

    ShowAnswerOutputData prepareFailView(ShowAnswerOutputData outputData);
}

package enterDeck;

public interface EnterDeckOutputBoundary {
    void prepareSuccessView(EnterDeckOutputData outputData);
    void prepareFailView(String message);
}

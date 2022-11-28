package editDeck;

public interface EditDeckOutputBoundary {
    void prepareSuccessView(EditDeckOutputData outputData);

    void prepareFailView(EditDeckOutputData editDeckOutputData);
}

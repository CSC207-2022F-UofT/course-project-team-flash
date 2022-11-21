package deleteDeck;

public interface DeleteDeckOutputBoundary {

    void prepareSuccessView(DeleteDeckOutputData outputData);

    void prepareFailView(String error);
}

package deleteDeck;

public interface DeleteDeckOutputBoundary {
    /**
     * Prepares view if deletion success
     * @param outputData the output data created from the interactor
     */
    void prepareSuccessView(DeleteDeckOutputData outputData);

    /**
     * Prepares view if deletion fails
     * @param error the error message
     */
    void prepareFailView(String error);
}

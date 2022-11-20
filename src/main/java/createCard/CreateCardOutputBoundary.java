package createCard;

public interface CreateCardOutputBoundary {
    void prepareSuccessView(CreateCardOutputData outputData);
    void prepareFailView(CreateCardOutputData outputData);
}

package moveCard;

/**
 * This file contains an interface named MoveCardOutputBoundary
 * It has two abstract methods prepareSuccessView and prepareFailView
 */
public interface MoveCardOutputBoundary {

    public void prepareSuccessView(MoveCardOutputData moveCardOutputData);

    public void prepareFailView(MoveCardOutputData moveCardOutputData);
}

package moveCard;


public class MoveCardInteractor implements MoveCardInputBoundary{

    private MoveCardOutputBoundary moveCardOutputBoundary;

    public MoveCardInteractor(MoveCardOutputBoundary moveCardOutputBoundary) {
        this.moveCardOutputBoundary = moveCardOutputBoundary;
    }

    @Override
    public void move(MoveCardInputData moveCardInputData) {
        moveCardInputData.getDeck().addCard(moveCardInputData.getCard());

        MoveCardOutputData moveCardOutputData = new MoveCardOutputData("Flashcard moved.");
        moveCardOutputBoundary.prepareSuccessView(moveCardOutputData);
    }
}

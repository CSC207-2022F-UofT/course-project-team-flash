package enterDeck;

public class EnterDeckController {
    final EnterDeckInputBoundary inputBoundary;


    public EnterDeckController(EnterDeckInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void enter(String deckName) {
        EnterDeckInputData inputData = new EnterDeckInputData(deckName);

        inputBoundary.enter(inputData);
    }
}

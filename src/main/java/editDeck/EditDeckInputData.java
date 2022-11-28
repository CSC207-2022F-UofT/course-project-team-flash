package editDeck;

public class EditDeckInputData {

    private final String name;
    private final String deckTracker;
    public EditDeckInputData(String name, String deckTracker) {
        this.name = name;
        this.deckTracker = deckTracker;
    }

    public String getName() {
        return name;
    }

    public String getDeckTracker() {
        return deckTracker;
    }
}

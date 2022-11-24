package enterDeck;

import java.util.List;

public class EnterDeckOutputData {
    private final List<String> cardIDs;
    public EnterDeckOutputData(List<String> cardIDs) {
        this.cardIDs = cardIDs;
    }

    public List<String> getCardIDs() {
        return cardIDs;
    }
}

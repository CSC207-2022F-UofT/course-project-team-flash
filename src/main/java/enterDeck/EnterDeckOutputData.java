package enterDeck;

import java.util.List;

public class EnterDeckOutputData {
    private final List<List<String>> cardInfo;
    public EnterDeckOutputData(List<List<String>> cardInfo) {
        this.cardInfo = cardInfo;
    }

    public List<List<String>> getCardInfo() {
        return cardInfo;
    }
}

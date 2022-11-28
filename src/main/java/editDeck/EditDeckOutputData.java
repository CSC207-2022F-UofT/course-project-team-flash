package editDeck;
/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

public class EditDeckOutputData {

    private String deckName;
    private String message;
    public EditDeckOutputData(String deckName, String message) {
        this.deckName = deckName;
        this.message = message;
    }

    public String getDeckName() {
        return deckName;
    }

    public String getMessage() {
        return message;
    }
}

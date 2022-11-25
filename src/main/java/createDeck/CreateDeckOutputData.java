package createDeck;

public class CreateDeckOutputData {

    private final String message;

    private String deckName;

    public CreateDeckOutputData (String message, String deckName) {
        this.message = message;
        this.deckName = deckName;
    }

    String getMessage(){
        return this.message;
    }

    String getDeckName(){
        return this.deckName;
    }
}

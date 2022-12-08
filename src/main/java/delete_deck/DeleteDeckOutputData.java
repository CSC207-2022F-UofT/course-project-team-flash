package delete_deck;

public class DeleteDeckOutputData {
    private final String deckName;

    /**
     * Creates an instance for the output data to be used by the presenter
     * @param deckName name of the deck that was deleted
     */
    DeleteDeckOutputData(String deckName){
        this.deckName = deckName;
    }

    /**
     * @return name of the deck that was deleted
     */
    String getDeckName(){
        return this.deckName;
    }

}

package deleteDeck;

public class DeleteDeckInputData {
    private final String deckName;

    /**
     * Input data for the DeleteDeckInteractor
     * @param deckName the name of the deck to be deleted
     */
    DeleteDeckInputData(String deckName){
        this.deckName = deckName;
    }

    /**
     * @return the name of the deck to be deleted
     */
    public String getDeckName(){
        return this.deckName;
    }
}

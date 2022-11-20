package deleteDeck;

public class DeleteDeckInputData {

    final String deckName;

    DeleteDeckInputData(String deckName){
        this.deckName = deckName;
    }

    public String getDeckName(){
        return this.deckName;
    }
}

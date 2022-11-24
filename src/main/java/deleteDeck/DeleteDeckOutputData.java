package deleteDeck;

public class DeleteDeckOutputData {

    String deckName;

    DeleteDeckOutputData(String deckName){
        this.deckName = deckName;
    }

    String getDeckName(){
        return this.deckName;
    }

}

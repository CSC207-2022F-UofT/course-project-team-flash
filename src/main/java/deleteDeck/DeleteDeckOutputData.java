package deleteDeck;

public class DeleteDeckOutputData {

    private String deckName;

    DeleteDeckOutputData(String deckName){
        this.deckName = deckName;
    }

    String getDeckName(){
        return this.deckName;
    }

}

package deleteDeck;

public class DeleteDeckController {

    final private DeleteDeckInputBoundary inputBound;

    public DeleteDeckController(DeleteDeckInputBoundary inputBound){
        this.inputBound = inputBound;
    }

    public void delete(String deckName){

        DeleteDeckInputData inputData = new DeleteDeckInputData(deckName);

        inputBound.delete(inputData);


    }
}

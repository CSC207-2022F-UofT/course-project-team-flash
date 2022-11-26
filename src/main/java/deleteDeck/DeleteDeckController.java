package deleteDeck;

public class DeleteDeckController {

    final private DeleteDeckInputBoundary inputBound;

    DeleteDeckController(DeleteDeckInputBoundary inputBound){
        this.inputBound = inputBound;
    }

    void delete(String deckName){

        DeleteDeckInputData inputData = new DeleteDeckInputData(deckName);

        inputBound.delete(inputData);


    }
}

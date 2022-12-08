package delete_deck;

public class DeleteDeckController {
    final private DeleteDeckInputBoundary inputBound;

    /**
     * Creates a controller instance for deck deletion.
     * @param inputBound The input boundary for the deck deletion use case
     */
    public DeleteDeckController(DeleteDeckInputBoundary inputBound){
        this.inputBound = inputBound;
    }

    /**
     * Deletes a given deck from a given name.
     * @param deckName the deck to be deleted
     */
    public void delete(String deckName){
        DeleteDeckInputData inputData = new DeleteDeckInputData(deckName);
        inputBound.delete(inputData);
    }
}

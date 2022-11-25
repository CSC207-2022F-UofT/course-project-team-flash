package createDeck;

/**
 * This file contains the implementation of the CreateDeckPresenter,
 * which implements CreateDeckOutputBoundary.
 */
public class CreateDeckPresenter implements CreateDeckOutputBoundary{

    /**
     * Prepare the success view given outputData, if the deck is created and stored successfully.
     *
     * @param outputData the CreateDeckOutputData associated with this created deck.
     */
    @Override
    public void prepareSuccessView(CreateDeckOutputData outputData){

    }

    /**
     * Prepare the fail view given outputData, if the deck cannot be created and stored successfully.
     *
     * @param outputData the CreateDeckOutputData associated with this created deck.
     */
    @Override
    public void prepareFailView(CreateDeckOutputData outputData) {

    }
}

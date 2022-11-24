/**
 * Author: Andrew Nguyen
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the CreateCardPresenter, which implements CreateCardOutputBoundary.
 */

package createCard;

public class CreateCardPresenter implements CreateCardOutputBoundary{

    /**
     * Prepare the success view given outputData, if the card is created and stored successfully.
     *
     * @param outputData the CreateCardOutputData associated with this created quiz
     */
    @Override
    public void prepareSuccessView(CreateCardOutputData outputData) {

    }

    /**
     * Prepare the fail view given outputData, if the card cannot be created or stored successfully.
     *
     * @param outputData the CreateCardOutputData associated with this created quiz
     */
    @Override
    public void prepareFailView(CreateCardOutputData outputData) {

    }
}

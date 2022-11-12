/*
 * Author: Aldo Bani
 * Date: November 12/22
 * This is the use case interactor for the deck export system
 */

package exportDeck;

public class ExportDeckInteractor implements ExportDeckInputBoundary{
    final ExportDeckController exportDeckController;
    final ExportDeckPresenter exportDeckPresenter;

    public ExportDeckInteractor(ExportDeckController exportDeckController, ExportDeckPresenter exportDeckPresenter) {
        this.exportDeckController = exportDeckController;
        this.exportDeckPresenter = exportDeckPresenter;
    }

    /**
     * Takes a deck and creates a file containing information about the deck and saves to user's filesystem
     * @param inputData data retrieved from the input
     * @return an OutputData object (for ExportDeck) containing a message
     */
    @Override
    public ExportDeckOutputData exportDeck(ExportDeckInputData inputData) {
        //creates a file and puts into user's filesystem
        return new ExportDeckOutputData("the message");
    }
}

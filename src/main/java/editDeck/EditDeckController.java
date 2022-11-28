package editDeck;
/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 * This file contains implementation of the EditDeckController class.
 * The task of it is to edit an existing deck.
 */


public class EditDeckController {

    private final EditDeckInputBoundary inputBoundary;

    public EditDeckController(EditDeckInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void edit(String oldName, String newName) {
        EditDeckInputData inputData = new EditDeckInputData(oldName, newName);
        inputBoundary.edit(inputData);
    }
}

/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 * This file contains implementation of the EditDeckController class.
 * The task of it is to edit an existing deck.
 */

package edit_deck;

public class EditDeckController {
    private final EditDeckInputBoundary inputBoundary;

    /**
     * Creates a controller instance for the edit deck use case.
     * @param inputBoundary input boundary for edit deck use case
     */
    public EditDeckController(EditDeckInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Renames a deck with the old name with the new name.
     * @param oldName deck to be renamed
     * @param newName new name for the deck
     */
    public void edit(String oldName, String newName) {
        EditDeckInputData inputData = new EditDeckInputData(oldName, newName);
        inputBoundary.edit(inputData);
    }
}

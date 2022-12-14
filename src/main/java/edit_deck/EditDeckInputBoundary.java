/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

package edit_deck;

public interface EditDeckInputBoundary {
    /**
     * Edits a deck's name.
     * @param inputData data from the controller
     */
    void edit(EditDeckInputData inputData);
}

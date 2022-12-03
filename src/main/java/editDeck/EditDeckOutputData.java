/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

package editDeck;

public class EditDeckOutputData {
    private final String text;
    private final String oldName;

    /**
     * Creates an instance for the output data to be used by the presenter.
     * @param text the message for the presenter
     */
    public EditDeckOutputData(String text) {
        this.text = text;
        this.oldName = null;
    }

    /**
     * Creates an instance for the output data to be used by the presenter.
     * @param newName the new name of the deck
     * @param oldName the old name of the deck
     */
    public EditDeckOutputData(String newName, String oldName) {
        this.text = newName;
        this.oldName = oldName;
    }
    /**
     * @return message for the presenter
     */
    public String getText() {
        return text;
    }

    public String getOldName() {
        return oldName;
    }
}

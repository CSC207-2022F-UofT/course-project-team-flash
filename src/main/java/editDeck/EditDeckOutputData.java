/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

package editDeck;

public class EditDeckOutputData {
    private final String text;

    /**
     * Creates an instance for the output data to be used by the presenter.
     * @param text the message for the presenter
     */
    public EditDeckOutputData(String text) {
        this.text = text;
    }

    /**
     * @return message for the presenter
     */
    public String getText() {
        return text;
    }
}

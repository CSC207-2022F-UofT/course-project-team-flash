/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

package editDeck;

public class EditDeckInputData {
    private final String oldName;
    private final String newName;
    public EditDeckInputData(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    /**
     * @return the old name of the deck
     */
    public String getoldName() {
        return oldName;
    }

    /**
     * @return the new name for the deck
     */
    public String getnewName() {
        return newName;
    }
}

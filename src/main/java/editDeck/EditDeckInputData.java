package editDeck;
/*
 * Author: Jay Kanchankoti
 * Date: November 27/22
 *
 */

public class EditDeckInputData {

    private final String oldName;
    private final String newName;
    public EditDeckInputData(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    public String getoldName() {
        return oldName;
    }

    public String getnewName() {
        return newName;
    }
}

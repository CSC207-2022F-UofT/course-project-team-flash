/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 12/22
 * This is the output data needed for the deck export system
 */

package export_deck;

public class ExportDeckOutputData {
    private final String message;

    /**
     * Creates a data object for the deck export output.
     * @param message output message
     */
    public ExportDeckOutputData(String message){
        this.message = message;
    }

    /**
     * @return the output message
     */
    public String getMessage() {
        return message;
    }
}

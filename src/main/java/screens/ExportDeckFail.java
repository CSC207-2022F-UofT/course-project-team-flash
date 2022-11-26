/*
 * Author: Aldo Bani
 * Date: November 20/22
 * This an exception in case the export fails.
 */

package screens;

public class ExportDeckFail extends RuntimeException{
    /**
     * Creates a new exception incase the deck export fails.
     * @param exception the exception message
     */
    public ExportDeckFail(String exception){
        super(exception);
    }
}

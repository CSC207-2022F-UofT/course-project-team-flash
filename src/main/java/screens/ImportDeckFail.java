/*
 * Author: Aldo Bani
 * Date: Novembet 26/22
 * This is an exception incase the import fails.
 */
package screens;

public class ImportDeckFail extends RuntimeException{
    /**
     * Creates a new exception in case the deck import fails.
     * @param exception the exception message
     */
    public ImportDeckFail(String exception){
        super(exception);
    }
}

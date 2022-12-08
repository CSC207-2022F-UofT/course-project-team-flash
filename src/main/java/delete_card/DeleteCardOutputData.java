/*
 * Author: Derrick Cho
 * Date: November 26/22
 * Description: Implementation of DeleteCardOutputData
 */
package delete_card;

/**
 * This file contains the implementation of the DeleteCardOutputData class
 * It contains the instance variables of DeleteCardOutputData
 * and contains the getter methods for them
 */
public class DeleteCardOutputData {

    private final String message;

    private final String id;

    /**
     * Creates a new DeleteCardOutputData with a given String message
     * @param message a String indicating whether the card was deleted or not
     */
    public DeleteCardOutputData(String message, String id) {
        this.id = id;
        this.message = message;
    }

    /**
     * Returns the message of the given DeleteCardOutputData
     * @return the message of the given DeleteCardOutputData
     */
    public String getMessage() { return this.message;}

    public String getId() { return this.id;}
}

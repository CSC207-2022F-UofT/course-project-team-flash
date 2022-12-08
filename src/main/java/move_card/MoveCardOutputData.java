/*
 * Author: Derrick Cho
 * Date: November 13/22
 */

package move_card;

/**
 * This file contains implementation of the MoveCardOutputData class.
 * It includes the instance attributes of MoveCardOutputData
 */
public class MoveCardOutputData {

    private final String message;
    private final String id;

    /**
     * Creates a new MoveCardOutputData with a given message
     * @param message indicates whether card was moved successfully or not
     */
    public MoveCardOutputData(String message, String id) {
        this.message = message;
        this.id = id;
    }

    /**
     * Gets message of a given MoveCardOutputData
     * @return message of a given MoveCardOutputData
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Gets id of the moved card
     * @return id of the moved card
     */
    public String getId() {
        return id;
    }
}

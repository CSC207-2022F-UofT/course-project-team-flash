package moveCard;

/**
 * This file contains implementation of the MoveCardOutputData class.
 * It includes the instance attributes of MoveCardOutputData
 */
public class MoveCardOutputData {

    private String message;

    /**
     * Creates a new MoveCardOutputData with a given message
     * @param message indicates whether card was moved successfully or not
     */
    public MoveCardOutputData(String message) {
        this.message = message;
    }

    /**
     * Returns message of a given MoveCardOutputData
     * @return message of a given MoveCardOutputData
     */
    public String getMessage() {
        return this.message;
    }
}

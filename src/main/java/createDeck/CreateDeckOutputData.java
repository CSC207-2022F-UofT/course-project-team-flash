package createDeck;

/**
 * This file contains the implementation of the CreateDeckOutputData class.
 * It includes an instance attribute of the CreateDeckOutputData class and
 * its getter method.
 */
public class CreateDeckOutputData {

    private final String message;

    /**
     * Creates a new CreateDeckOutputData given the message.
     *
     * @param message a message indicating whether this quiz is created and stored successfully.
     */
    public CreateDeckOutputData (String message) {
        this.message = message;
    }

    /**
     * Returns the message of this CreateDeckOutputData.
     *
     * @return
     */
    public String getMessage() {
        return message;
    }
}

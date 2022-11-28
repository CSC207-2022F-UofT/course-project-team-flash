/*
 * Author: Jay Kanchankoti
 * Documentation Author: Jay Kanchankoti
 * Date: November 14/22
 */
package createDeck;

/**
 * This file contains the implementation of the CreateDeckOutputData class.
 * It includes an instance attribute of the CreateDeckOutputData class and
 * its getter method.
 */
public class CreateDeckOutputData {

    private final String text;
    /**
     * Creates a new CreateDeckOutputData given the message.
     *
     * @param text the name of the deck or an error message
     */
    public CreateDeckOutputData (String text) {
        this.text = text;
    }

    /**
     * A getter function
     *
     * @return text the name of the deck or an error message
     */
    String getText() {
        return this.text;
    }
}

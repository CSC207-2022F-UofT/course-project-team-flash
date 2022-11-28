/*
 * Author: Jay Kanchankoti
 * Documentation Author: Jay Kanchankoti
 * Date: November 14/22
 */

package createDeck;

/**This file contains implementation of the CreateDeckController class.
 * The task of it is to create a new deck.
 */
public class CreateDeckController {
    final CreateDeckInputBoundary inputBoundary;

    /**
     * Constructor for CreateDeckController using the given input boundary.
     *
     * @param inputBoundary a CreateDeckInputBoundary
     */
    public CreateDeckController(CreateDeckInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Creates a new deck with the given name.
     *
     * @param name the name of the deck
     */
    public void create(String name) {
        CreateDeckInputData inputData = new CreateDeckInputData(name);

        inputBoundary.create(inputData);
    }
}
/**
 * This file contains implementation of the CreateDeckInputData class.
 * It includes an instance attribute of CreateDeckInputData and
 * the getter methods for it.
 */
package createDeck;

public class CreateDeckInputData {

    private final String name;

    /**
     * Constructor for CreateDeckInputData using the given deck name.
     *
     * @param name the name of the deck
     */
    public CreateDeckInputData(String name) {
        this.name = name;
    }

    /**
     * Returns the name of the CreateDeckInputData
     * @return name of the CreateDeckInputData
     */
    public String getName() {
        return name;
    }
}

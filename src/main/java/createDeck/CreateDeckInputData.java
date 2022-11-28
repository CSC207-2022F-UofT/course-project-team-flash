/*
 * Author: Jay Kanchankoti
 * Documentation Author: Jay Kanchankoti
 * Date: November 14/22
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
     *
     * @return name of the CreateDeckInputData
     */
    public String getName() {
        return name;
    }
}
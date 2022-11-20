/*
 * Author: Jay Kanchankoti
 * Date: November 14/22
 * Description: Small description of what this class does
 */
package createDeck;

public class CreateDeckController {
    final CreateDeckInputBoundary inputBoundary;

    public CreateDeckController(CreateDeckInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    // Creates Deck
    public void create(String name) {
        CreateDeckInputData inputData = new CreateDeckInputData(name);

        inputBoundary.create(inputData);
    }
}

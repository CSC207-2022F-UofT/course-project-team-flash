package moveCard;
/*
 * Author: Derrick Cho
 * Date: November 13/22
 * Description:
 */

import entities.Deck;

import entities.Flashcard;

public class MoveCardController {

    final MoveCardInputBoundary moveCardInputBoundary;

    public MoveCardController(MoveCardInputBoundary moveCardInputBoundary) {
        this.moveCardInputBoundary = moveCardInputBoundary;
    }

    public void move(String oldDeck, String newDeck, String card) {
        MoveCardInputData moveCardInputData = new MoveCardInputData(card, oldDeck, newDeck);

        moveCardInputBoundary.move(moveCardInputData);
    }
}

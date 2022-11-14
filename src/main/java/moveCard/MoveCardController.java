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

    public void move(Deck deck, Flashcard card) {
        MoveCardInputData moveCardInputData = new MoveCardInputData(card, deck);

        moveCardInputBoundary.move(moveCardInputData);
    }
}

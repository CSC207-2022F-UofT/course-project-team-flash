package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * The output data class for edit card systems, packages data related to output together to be sent to viewmodel
 */

import entities.Flashcard;

public class EditCardOutputData {

    private Flashcard card;
    private String message;

    public EditCardOutputData(Flashcard card, String message) {
        this.card = card;
        this.message = message;
    }

    public Flashcard getCard() {
        return card;
    }

    public String getMessage() {
        return message;
    }
}

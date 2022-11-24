package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * This class is a container for the input data related to edit card systems,
 * it is created by the controller and sent to the interactor
 */

import entities.Flashcard;

import java.util.List;

public class EditCardInputData {

    private final String cardID;
    private final String question;
    private final String answer;
    private final List<String> options;

    public EditCardInputData(String cardID, String question, String answer) {
        this.cardID = cardID;
        this.question = question;
        this.answer = answer;
        this.options = null;
    }

    public EditCardInputData(String cardID, String question, String answer, List<String> options) {
        this.cardID = cardID;
        this.question = question;
        this.answer = answer;
        this.options = options;
    }

    public String getCardID() {
        return cardID;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getOptions() { return options; }
}

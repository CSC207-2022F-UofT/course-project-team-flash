package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * This class is a container for the input data related to edit card systems
 */

public class EditCardInputData {

    private Flashcard card;
    private String question;
    private String answer;

    public EditCardInputData(Flashcard card, String question, String answer) {
        this.card = card;
        this.question = question;
        this.answer = answer;
    }

    public Flashcard getCard() {
        return card;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

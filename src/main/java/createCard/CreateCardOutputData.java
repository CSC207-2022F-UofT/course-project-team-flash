package createCard;

public class CreateCardOutputData {
    private final String message;
    private final String type;
    private final String question;
    private final String answer;

    public CreateCardOutputData(String message) {
        this.message = message;
        this.type = null;
        this.question = null;
        this.answer = null;
    }

    public CreateCardOutputData(String message, int type, String question, String answer) {
        this.message = message;

        String strType = "";
        if (type == 1) {
            strType = "Q and A";
        } else if (type == 2) {
            strType = "Multiple Choice";
        } else if (type == 3) {
            strType = "Select All";
        }

        this.type = strType;
        this.question = question;
        this.answer = answer;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}

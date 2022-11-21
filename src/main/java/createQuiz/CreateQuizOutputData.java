package createQuiz;

import entities.Quiz;

public class CreateQuizOutputData {

    private final Quiz quiz;
    private final String message;

    public CreateQuizOutputData(Quiz quiz, String message) {
        this.quiz = quiz;
        this.message = message;
    }

    public Quiz getQuiz() {
        return this.quiz;
    }

    public String getMessage() {
        return this.message;
    }
}

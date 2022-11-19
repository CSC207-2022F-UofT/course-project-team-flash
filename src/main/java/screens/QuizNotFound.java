package screens;

public class QuizNotFound extends RuntimeException{

    public QuizNotFound(String error){
        super(error);
    }
}

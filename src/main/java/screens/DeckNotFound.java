package screens;

public class DeckNotFound extends RuntimeException{

    public DeckNotFound(String error){
        super(error);
    }
}

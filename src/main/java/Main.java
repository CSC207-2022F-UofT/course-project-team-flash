import createCard.*;
import createDeck.*;
import createQuiz.*;
import entities.CardFactory;
import entities.FlashcardFactory;

import screens.*;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;
    public static void main(String[] args) {
        // Instantiate the view
        View view = new View();

        // Build the Jframes

        // Call what needs to be called
        CreateCardController createCardController = createCardConstructor();
        CreateDeckController createDeckController = createDeckConstructor();
        CreateQuizController createQuizController = createQuizConstructor();
        // IDK what else needs to be done
    }

    private static CreateCardController createCardConstructor() {
        CreateCardOutputBoundary presenter = new CreateCardPresenter();
        CardFactory factory = new FlashcardFactory();
        CreateCardInputBoundary interactor = new CreateCardInteractor(presenter, factory);
        return new CreateCardController(interactor);
    }

    private static CreateDeckController createDeckConstructor() {
        CreateDeckOutputBoundary presenter = new CreateDeckPresenter();
        CreateDeckInputBoundary interactor = new CreateDeckInteractor(presenter);
        return new CreateDeckController(interactor);
    }

    private static CreateQuizController createQuizConstructor() {
        CreateQuizOutputBoundary presenter = new CreateQuizPresenter();
        CreateQuizInputBoundary interactor = new CreateQuizInteractor(presenter);
        return new CreateQuizController(interactor);
    }
}

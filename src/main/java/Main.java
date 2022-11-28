import createCard.*;
import createDeck.*;
import createQuiz.*;
import deleteDeck.*;
import deleteQuiz.*;
import entities.CardFactory;
import entities.FlashcardFactory;

import createCard.CreateCardController;
import createCard.CreateCardInteractor;
import createCard.CreateCardOutputData;
import createCard.CreateCardPresenter;
import createDeck.CreateDeckController;
import screens.*;

import javax.swing.*;
import java.awt.*;


public class Main {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;
    public static void main(String[] args) {

        // Instantiate the view
        View view = new View();

        // Call what needs to be called
        CreateCardController createCardController = createCardConstructor();
        CreateDeckController createDeckController = createDeckConstructor(view);
        CreateQuizController createQuizController = createQuizConstructor(view);
        DeleteDeckController deleteDeckController = deleteDeckConstructor(view);
        DeleteQuizController deleteQuizController = deleteQuizConstructor(view);

        // Setting controllers of the view
        view.setController(createCardController, createDeckController, createQuizController, deleteDeckController, deleteQuizController);

        // IDK what else needs to be done
    }

    private static CreateCardController createCardConstructor() {
        CreateCardOutputBoundary presenter = new CreateCardPresenter();
        CardFactory factory = new FlashcardFactory();
        CreateCardInputBoundary interactor = new CreateCardInteractor(presenter, factory);
        return new CreateCardController(interactor);
    }

    private static CreateDeckController createDeckConstructor(View view) {
        CreateDeckOutputBoundary presenter = new CreateDeckPresenter(view);
        CreateDeckInputBoundary interactor = new CreateDeckInteractor(presenter);
        return new CreateDeckController(interactor);
    }

    private static CreateQuizController createQuizConstructor(View view) {
        CreateQuizOutputBoundary presenter = new CreateQuizPresenter(view);
        CreateQuizInputBoundary interactor = new CreateQuizInteractor(presenter);
        return new CreateQuizController(interactor);
    }

    private static DeleteDeckController deleteDeckConstructor(View view) {
        DeleteDeckOutputBoundary presenter = new DeleteDeckPresenter(view);
        DeleteDeckInputBoundary interactor = new DeleteDeckInteractor(presenter);
        return new DeleteDeckController(interactor);
    }

    private static DeleteQuizController deleteQuizConstructor(View view) {
        DeleteQuizOutputBoundary presenter = new DeleteQuizPresenter(view);
        DeleteQuizInputBoundary interactor = new DeleteQuizInteractor(presenter);
        return new DeleteQuizController(interactor);
    }
}

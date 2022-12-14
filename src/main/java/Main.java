import create_card.*;
import create_deck.*;
import create_quiz.*;
import delete_card.*;
import delete_deck.*;
import delete_quiz.*;
import edit_card.*;
import edit_deck.*;
import edit_quiz.*;
import move_card.*;
import enter_deck.*;
import export_deck.*;
import import_deck.*;
import data.*;
import run_quiz.*;

import entities.CardFactory;
import entities.FlashcardFactory;

import screens.*;

public class Main {
    public static void main(String[] args) {

        // Instantiate the view
        View view = new View();

        // Call what needs to be called
        CreateCardController createCardController = createCardConstructor(view);
        CreateDeckController createDeckController = createDeckConstructor(view);
        CreateQuizController createQuizController = createQuizConstructor(view);
        DeleteCardController deleteCardController = deleteCardConstructor(view);
        DeleteDeckController deleteDeckController = deleteDeckConstructor(view);
        DeleteQuizController deleteQuizController = deleteQuizConstructor(view);
        EditCardController editCardController = editCardConstructor(view);
        EditDeckController editDeckController = editDeckConstructor(view);
        EditQuizController editQuizController = editQuizConstructor(view);
        MoveCardController moveCardController = moveCardConstructor(view);
        EnterDeckController enterDeckController = enterDeckConstructor(view);
        ImportDeckController importDeckController = importDeckConstructor(view);
        ExportDeckController exportDeckController = exportDeckConstructor(view);
        RunQuizController runQuizController = runQuizConstructor(view);


        // Setting controllers of the view
        view.setController(
                createCardController, createDeckController, createQuizController,
                deleteCardController, deleteDeckController,deleteQuizController,
                editCardController, editDeckController, editQuizController,
                moveCardController,
                enterDeckController, exportDeckController, importDeckController,
                runQuizController
        );

        // IDK what else needs to be done
    }

    private static CreateCardController createCardConstructor(View view) {
        CreateCardOutputBoundary presenter = new CreateCardPresenter(view);
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
    private static DeleteCardController deleteCardConstructor(View view) {
        DeleteCardOutputBoundary presenter = new DeleteCardPresenter(view);
        DeleteCardInputBoundary interactor = new DeleteCardInteractor(presenter);
        return new DeleteCardController(interactor);

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
    private static EditCardController editCardConstructor(View view) {
        EditCardOutputBoundary presenter = new EditCardPresenter(view);
        EditCardInputBoundary interactor = new EditCardInteractor(presenter);
        return new EditCardController(interactor);
    }
    private static EditDeckController editDeckConstructor(View view) {
        EditDeckOutputBoundary presenter = new EditDeckPresenter(view);
        EditDeckInputBoundary interactor = new EditDeckInteractor(presenter);
        return new EditDeckController(interactor);
    }
    private static EditQuizController editQuizConstructor(View view) {
        EditQuizOutputBoundary presenter = new EditQuizPresenter(view);
        EditQuizInputBoundary interactor = new EditQuizInteractor(presenter);
        return new EditQuizController(interactor);
    }
    private static MoveCardController moveCardConstructor(View view) {
        MoveCardOutputBoundary presenter = new MoveCardPresenter(view);
        MoveCardInputBoundary interactor = new MoveCardInteractor(presenter);
        return new MoveCardController(interactor);
    }
    private static EnterDeckController enterDeckConstructor(View view) {
        EnterDeckOutputBoundary presenter = new EnterDeckPresenter(view);
        EnterDeckInputBoundary interactor = new EnterDeckInteractor(presenter);
        return new EnterDeckController(interactor);
    }
    private static ExportDeckController exportDeckConstructor(View view) {
        ExportDeckOutputBoundary presenter = new ExportDeckPresenter(view);
        ExportDeckDsGateway gateway = new DeckFileExport();
        ExportDeckInteractor interactor = new ExportDeckInteractor(gateway, presenter);
        return new ExportDeckController(interactor);
    }
    private static ImportDeckController importDeckConstructor(View view) {
        ImportDeckOutputBoundary presenter = new ImportDeckPresenter(view);
        ImportDeckDsGateway gateway = new DeckFileImport();
        CardFactory factory = new FlashcardFactory();
        ImportDeckInteractor interactor = new ImportDeckInteractor(gateway, presenter, factory);
        return new ImportDeckController(interactor);
    }

    private static RunQuizController runQuizConstructor(View view) {
        RunQuizOutputBoundary presenter = new RunQuizPresenter(view);
        RunQuizInputBoundary interactor = new RunQuizInteractor(presenter);
        return new RunQuizController(interactor);
    }
}

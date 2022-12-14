package screens;

import create_card.CreateCardController;
import create_deck.CreateDeckController;
import create_quiz.CreateQuizController;
import delete_card.DeleteCardController;
import delete_deck.DeleteDeckController;
import delete_quiz.DeleteQuizController;
import edit_card.EditCardController;
import edit_deck.EditDeckController;
import edit_quiz.EditQuizController;
import move_card.MoveCardController;
import enter_deck.EnterDeckController;
import export_deck.ExportDeckController;
import import_deck.ImportDeckController;
import run_quiz.RunQuizController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View implements ViewBoundary {
    // Elements of the screen
    public static final int WIDTH = 1024;
    public static final int HEIGHT = 600;

    // Storing the controllers required by all use cases
    private CreateCardController createCardController;
    private CreateDeckController createDeckController;
    private CreateQuizController createQuizController;
    private DeleteCardController deleteCardController;
    private DeleteDeckController deleteDeckController;
    private DeleteQuizController deleteQuizController;
    private EditCardController editCardController;
    private EditDeckController editDeckController;
    private EditQuizController editQuizController;
    private MoveCardController moveCardController;
    private EnterDeckController enterDeckController;
    private ExportDeckController exportDeckController;
    private ImportDeckController importDeckController;
    private RunQuizController runQuizController;


    // Storing the JFrame and Jpanels in the view
    private final JFrame application;
    private final CardScreen cardScreen;
    private final DeckScreen deckScreen;
    private final QuizScreen quizScreen;
    private final ShowProblemScreen showProblemScreen;
    private final ShowAnswerScreen showAnswerScreen;

    //These should probably be enough right here, but add more if you need another type of information to
    //give to the view. Don't forget to update the ViewModel as well.

    //Required parameter(s):
    private ViewState viewState;

    //Optional parameter(s):
    private String returnString;

    private String cardType;
    private String cardQuestion;
    private String userAnswer;
    private String cardAnswer;
    private String cardID;
    private String quizName;
    private String quizName2;
    private String deckName;
    private String deckName2;
    private List<String> cardOptions;
    private List<String> cardTypes;
    private List<String> cardQuestions;
    private List<String> cardAnswers;
    private List<String> cardIDs;
    private String[] cardIdArray;
    private int currCardIndex;

    public View() {

        // Build the Jframe
        application = new JFrame("Flashcard");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Build a blank screen
        CardLayout interfaceLayout = new CardLayout();
        JPanel screens = new JPanel(interfaceLayout);
        application.add(screens);

        cardScreen = new CardScreen(createCardController, deleteCardController, editCardController, moveCardController);
        deckScreen = new DeckScreen(createDeckController, deleteDeckController, editDeckController,
                                    enterDeckController, exportDeckController, importDeckController);
        MainMenuScreen mainMenuScreen = new MainMenuScreen();
        quizScreen = new QuizScreen(createQuizController, deleteQuizController,
                                    editQuizController, runQuizController);
        showProblemScreen = new ShowProblemScreen(runQuizController);
        showAnswerScreen = new ShowAnswerScreen(runQuizController);

        screens.add(cardScreen);
        screens.add(deckScreen);
        screens.add(mainMenuScreen);
        screens.add(quizScreen);
        screens.add(showProblemScreen);
        screens.add(showAnswerScreen);

        cardScreen.setVisible(false);
        deckScreen.setVisible(false);
        mainMenuScreen.setVisible(true);
        quizScreen.setVisible(false);
        showProblemScreen.setVisible(false);
        showAnswerScreen.setVisible(false);

        application.setSize(WIDTH, HEIGHT);
        application.setResizable(true);
        application.setVisible(true);
        application.setLocationRelativeTo(null);
    }

    // General method for setting the controllers of the view
    public void setController(CreateCardController createCardController,
                              CreateDeckController createDeckController,
                              CreateQuizController createQuizController,
                              DeleteCardController deleteCardController,
                              DeleteDeckController deleteDeckController,
                              DeleteQuizController deleteQuizController,
                              EditCardController editCardController,
                              EditDeckController editDeckController,
                              EditQuizController editQuizController,
                              MoveCardController moveCardController,
                              EnterDeckController enterDeckController,
                              ExportDeckController exportDeckController,
                              ImportDeckController importDeckController,
                              RunQuizController runQuizController) {

        this.createCardController = createCardController;
        this.createDeckController = createDeckController;
        this.createQuizController = createQuizController;
        this.deleteCardController = deleteCardController;
        this.deleteDeckController = deleteDeckController;
        this.deleteQuizController = deleteQuizController;
        this.editCardController = editCardController;
        this.editDeckController = editDeckController;
        this.editQuizController = editQuizController;
        this.moveCardController = moveCardController;
        this.enterDeckController = enterDeckController;
        this.exportDeckController = exportDeckController;
        this.importDeckController = importDeckController;
        this.runQuizController = runQuizController;

        cardScreen.setController(createCardController, deleteCardController, editCardController, moveCardController);
        deckScreen.setController(createDeckController, deleteDeckController, editDeckController,
                                enterDeckController, exportDeckController, importDeckController);
        quizScreen.setController(createQuizController, deleteQuizController, editQuizController ,runQuizController);
        deckScreen.setController(createDeckController, deleteDeckController, editDeckController, enterDeckController,
                                exportDeckController, importDeckController);
        quizScreen.setController(createQuizController, deleteQuizController, editQuizController ,runQuizController);
        showAnswerScreen.setController(runQuizController);
        showProblemScreen.setController(runQuizController);
    }

    @Override
    public void updateView(ViewModel viewModel) {

        this.returnString = viewModel.getReturnString();
        this.userAnswer = viewModel.getUserAnswer();
        this.cardAnswer = viewModel.getCardAnswer();
        this.cardID = viewModel.getCardId();
        this.quizName = viewModel.getQuizName();
        this.quizName2 = viewModel.getQuizName2();
        this.deckName = viewModel.getDeckName();
        this.deckName2 = viewModel.getDeckName2();
        this.cardIdArray = viewModel.getCardIdArray();
        this.currCardIndex = viewModel.getCurrCardIndex();
        this.cardType = viewModel.getCardType();
        this.cardQuestion = viewModel.getCardQuestion();
        this.cardAnswer = viewModel.getCardAnswer();
        this.cardOptions = viewModel.getCardOptions();
        this.cardTypes = viewModel.getMultipleCardTypes();
        this.cardIDs = viewModel.getMultipleCardIDs();
        this.cardQuestions = viewModel.getMultipleCardQuestions();
        this.cardAnswers = viewModel.getMultipleCardAnswers();
        this.viewState = viewModel.getViewState();
        this.menuSwitch();
    }

    private void menuSwitch() {

        switch (this.viewState) {
            case ERROR:
                createErrorMessage(returnString);
                break;

            case MAIN_MENU:
                application.setVisible(false);
                for (Component c : application.getParent().getComponents()) {
                    if (c instanceof MainMenuScreen) {
                        c.setVisible(true);
                        return;
                    }
                }
                break;

            case QUIZ_MENU:
                //Menu that displays the quizzes.
                quizScreen.setVisible(true);
                break;

            case SHOW_ANSWER:
                //Menu that shows the answer to a flashcard along with a show next problem button.
                showAnswerScreen.setQuiz(cardIdArray, currCardIndex, cardAnswer, userAnswer);
                showAnswerScreen.setVisible(true);
                break;

            case SHOW_PROBLEM:
                //Menu that shows the question of a flashcard along with a show answer button.
                quizScreen.setVisible(false);
                showProblemScreen.setQuiz(cardIdArray, currCardIndex, returnString, cardAnswer, cardOptions);
                showProblemScreen.setVisible(true);
                break;

            case CARD_CREATED:
                cardScreen.reconstructCards(false, new String[]{cardType, cardQuestion, cardAnswer, cardID});
                break;

            case CARD_MOVED:

            case CARD_DELETED:
                cardScreen.reconstructCards(true, new String[]{cardType, cardQuestion, cardAnswer, cardID});
                break;

            case CARD_EDITED:
                cardScreen.reconstructCards(true, new String[]{cardType, cardQuestion, cardAnswer, cardID});
                cardScreen.reconstructCards(false, new String[]{cardType, cardQuestion, cardAnswer, cardID});
                break;

            case DECK_CREATED:

            case DECK_IMPORTED:
                //Changes to the view when a deck is created
                deckScreen.reconstructDecks(false, deckName);
                quizScreen.reconstructDecks(false, deckName);
                break;

            case DECK_DELETED:
                deckScreen.reconstructDecks(true, deckName);
                quizScreen.reconstructDecks(true, deckName);
                break;

            case DECK_EDITED:
                deckScreen.reconstructDecks(true, deckName2);
                deckScreen.reconstructDecks(false, deckName);
                quizScreen.reconstructDecks(true, deckName2);
                quizScreen.reconstructDecks(false, deckName);
                break;

            case DECK_EXPORTED:
                createExportMessage();
                break;

            case QUIZ_CREATED:
                quizScreen.reconstructQuizzes(false, quizName);
                break;

            case QUIZ_DELETED:
                quizScreen.reconstructQuizzes(true, quizName);
                break;

            case QUIZ_EDITED:
                quizScreen.reconstructQuizzes(true, quizName2);
                quizScreen.reconstructQuizzes(false, quizName);
                break;

            case ENTER_DECK:
                cardScreen.swapScreen();
                cardScreen.reconstructCards();
                for (int i = 0; i < cardQuestions.size(); i++) {
                    cardScreen.reconstructCards(false, new String[]{cardTypes.get(i), cardQuestions.get(i), cardAnswers.get(i), cardIDs.get(i)});
                }
                break;
        }
    }

    private void createErrorMessage(String message) {
        // Create The Error Message
        JLabel errorMessage = new JLabel(message);
        errorMessage.setHorizontalAlignment(JLabel.CENTER);
        errorMessage.setVerticalTextPosition(JLabel.BOTTOM);
        errorMessage.setHorizontalTextPosition(JLabel.CENTER);

        JOptionPane.showMessageDialog(null, errorMessage, "Error", JOptionPane.PLAIN_MESSAGE);
    }

    private void createExportMessage() {
        JLabel exportMessage = new JLabel("Export Underway! Please wait a few seconds for changes to load.");
        exportMessage.setHorizontalAlignment(JLabel.CENTER);
        exportMessage.setVerticalTextPosition(JLabel.BOTTOM);
        exportMessage.setHorizontalTextPosition(JLabel.CENTER);

        JOptionPane.showMessageDialog(null, exportMessage, "Export", JOptionPane.PLAIN_MESSAGE);
    }
}

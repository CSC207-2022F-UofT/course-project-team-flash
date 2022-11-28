package screens;

import createCard.CreateCardController;
import createDeck.CreateDeckController;
import deleteDeck.DeleteDeckController;
import createQuiz.CreateQuizController;
import deleteQuiz.DeleteQuizController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class View implements ViewBoundary {
    // Elements of the screen
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 600;

    // Storing the controllers required by all use cases
    private CreateCardController createCardController;
    private CreateDeckController createDeckController;
    private CreateQuizController createQuizController;
    private DeleteDeckController deleteDeckController;
    private DeleteQuizController deleteQuizController;

    // Storing the JFrame and Jpanels in the view
    private JFrame application;
    private CardScreen cardScreen;
    private DeckScreen deckScreen;
    private QuizScreen quizScreen;
    private MainMenuScreen mainMenuScreen;

    //These should probably be enough right here, but add more if you need another type of information to
    //give to the view. Don't forget to update the ViewModel as well.


    //Required parameter(s):
    private ViewState viewState;

    //Optional parameter(s):
    private String returnString;

    private String userAnswer;

    private String cardAnswer;
    private String quizName;

    private String deckName;

    private String cardId;

    private List<String> cardIdList;

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

        cardScreen = new CardScreen(createCardController);
        deckScreen = new DeckScreen(createDeckController, deleteDeckController);
        mainMenuScreen = new MainMenuScreen();
        quizScreen = new QuizScreen(createQuizController, deleteQuizController);

        screens.add(cardScreen);
        screens.add(deckScreen);
        screens.add(mainMenuScreen);
        screens.add(quizScreen);

        cardScreen.setVisible(false);
        deckScreen.setVisible(false);
        mainMenuScreen.setVisible(true);
        quizScreen.setVisible(false);

        application.setSize(WIDTH, HEIGHT);
        application.setResizable(true);
        application.setVisible(true);
    }

    // General method for setting the controllers of the view
    public void setController(CreateCardController createCardController, CreateDeckController createDeckController, CreateQuizController createQuizController, DeleteDeckController deleteDeckController, DeleteQuizController deleteQuizController) {
        this.createCardController = createCardController;
        this.createDeckController = createDeckController;
        this.createQuizController = createQuizController;
        this.deleteDeckController = deleteDeckController;
        this.deleteQuizController = deleteQuizController;
        deckScreen.setController(createDeckController, deleteDeckController);
        quizScreen.setController(createQuizController, deleteQuizController);
    }

    @Override
    public void updateView(ViewModel viewModel) {

        this.returnString = viewModel.getReturnString();
        this.userAnswer = viewModel.getUserAnswer();
        this.cardAnswer = viewModel.getCardAnswer();
        this.quizName = viewModel.getQuizName();
        this.deckName = viewModel.getDeckName();
        this.cardId = viewModel.getCardId();
        this.cardIdList = viewModel.getCardIdList();
        this.cardIdArray = viewModel.getCardIdArray();
        this.currCardIndex = viewModel.getCurrCardIndex();
        // Conditional removed, we need to update if the same action is made
        // ---If the viewState changes, update it and call the menuSwitch method to update the view.---
        //if (this.viewState != viewModel.getViewState()) {
        this.viewState = viewModel.getViewState();
        this.menuSwitch();
        //}

    }

    private void menuSwitch() {

        switch (this.viewState) {
            case ERROR:
                createErrorMessage(returnString);
                break;

            //ADD WHATEVER VIEWSTATES YOUR USECASE NEEDS HERE, I HAVE ADDED SOME ALREADY HERE AS AN EXAMPLE:

            case DECK_SCREEN:
                //Creates and updates the Deck screen when a change is made to the deck screen


                break;

            case QUIZ_MENU:
                //Menu that displays the quizzes.


                break;

            case SHOW_ANSWER:
                //Menu that shows the answer to a flashcard along with a show next problem button.


                break;

            case SHOW_PROBLEM:
                //Menu that shows the question of a flashcard along with a show answer button.


                break;


            case START_QUIZ:
                //Menu that shows the view before a quiz starts with a button like "begin quiz".


                break;

            case DECK_CREATED:
                //Changes to the view when a deck is created
                deckScreen.reconstructDecks(false, deckName);
                quizScreen.reconstructDecks(false, deckName);

                break;

            case DECK_DELETED:
                deckScreen.reconstructDecks(true, deckName);
                quizScreen.reconstructDecks(true, deckName);

                break;

            case DECK_IMPORTED:


                break;

            case QUIZ_CREATED:
                quizScreen.reconstructQuizzes(false, quizName);

                break;

            case QUIZ_DELETED:
                quizScreen.reconstructQuizzes(true, quizName);

                break;
        }


        //BELOW HERE:
        //Implement all the callback methods that will be triggered by button click events. These methods
        //will be the ones that'll call the methods in the controllers, so they should be specific to each useCase.
    }

    private void createErrorMessage(String message) {
        JFrame errorFrame = new JFrame();
        JDialog errorDialog = new JDialog(errorFrame);

        JLabel prompt = new JLabel(message);
        JButton createButton = new JButton("Ok");
        errorDialog.add(prompt);
        errorDialog.add(createButton);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                errorFrame.dispose();
            }
        });

        errorFrame.pack();
        errorFrame.setVisible(true);
    }
}

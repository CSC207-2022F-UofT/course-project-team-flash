package screens;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View implements ViewBoundary {
    // Elements of the screen
    public static final int WIDTH = 400;
    public static final int HEIGHT = 500;

    // Storing the JFrame and Jpanels in the view
    private JFrame application;
    private DeckScreen deckScreen;
    private QuizScreen quizScreen;
    private MainMenuScreen mainMenuScreen;

    //These should probably be enough right here, but add more if you need another type of information to
    //give to the view. Don't forget to update the ViewModel as well.


    //Required parameter(s):
    private ViewState viewState;

    //Optional parameter(s):
    private String returnString;

    private String quizName;

    private String deckName;

    private String cardId;

    private List<String> cardIdList;

    private int currCardIndex;


    public View() {

        // Build the Jframes
        application = new JFrame("Flashcard");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        deckScreen = new DeckScreen();
        mainMenuScreen = new MainMenuScreen();
        quizScreen = new QuizScreen();

        screens.add(deckScreen);
        screens.add(mainMenuScreen);
        screens.add(quizScreen);

        deckScreen.setVisible(false);
        mainMenuScreen.setVisible(true);
        quizScreen.setVisible(false);

        application.setSize(WIDTH, HEIGHT);
        application.setVisible(true);
    }

    @Override
    public void updateView(ViewModel viewModel) {

        this.returnString = viewModel.getReturnString();
        this.quizName = viewModel.getQuizName();
        this.deckName = viewModel.getDeckName();
        this.cardId = viewModel.getCardId();
        this.cardIdList = viewModel.getCardIdList();
        this.currCardIndex = viewModel.getCurrCardIndex();

        //If the viewState changes, update it and call the menuSwitch method to update the view.
        if (this.viewState != viewModel.getViewState()) {
            this.viewState = viewModel.getViewState();
            this.menuSwitch();
        }

    }

    private void menuSwitch() {

        switch (this.viewState) {

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

            case DECK_DELETED:
                //Menu that pops up when you delete a deck (says something like "deck deleted") and has an
                //"OK" button or smth.


                break;
        }


        //BELOW HERE:
        //Implement all the callback methods that will be triggered by button click events. These methods
        //will be the ones that'll call the methods in the controllers, so they should be specific to each useCase.
    }
}

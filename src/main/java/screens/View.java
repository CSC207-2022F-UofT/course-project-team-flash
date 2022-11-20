package screens;

import java.util.List;

public class View implements ViewBoundary{

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


    public View(){
        this.viewState = ViewState.MAIN_MENU;
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
        if(this.viewState != viewModel.getViewState()){
            this.viewState = viewModel.getViewState();
            this.menuSwitch();
        }

    }

    private void menuSwitch(){

        switch(this.viewState){

            //ADD WHATEVER VIEWSTATES YOUR USECASE NEEDS HERE, I HAVE ADDED SOME ALREADY HERE AS AN EXAMPLE:

            case MAIN_MENU:
                //Main menu buttons/frames etc.


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

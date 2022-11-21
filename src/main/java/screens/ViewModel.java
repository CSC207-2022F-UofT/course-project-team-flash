package screens;

//A class to store any current information needed for the view.

import java.util.List;

public class ViewModel {

    //Required Parameter(s):
    private ViewState viewState;


    //Optional parameter(s):
    private String returnString;

    private String quizName;

    private String deckName;

    private String cardId;

    private List<String> cardIdList;

    private int currCardIndex;


    private ViewModel(ViewModelBuilder builder){

        this.viewState = builder.ViewState;

        this.returnString = builder.returnString;
        this.quizName = builder.quizName;
        this.deckName = builder.deckName;
        this.cardId = builder.cardId;
        this.cardIdList = builder.cardIdList;
        this.currCardIndex = builder.currCardIndex;

    }

    //Getters:

    public ViewState getViewState() {
        return viewState;
    }

    public String getReturnString() {
        return returnString;
    }

    public String getQuizName() {
        return quizName;
    }

    public String getDeckName() {
        return deckName;
    }

    public String getCardId() {
        return cardId;
    }

    public List<String> getCardIdList() {
        return cardIdList;
    }

    public int getCurrCardIndex() {
        return currCardIndex;
    }


    //Builder:
    public static class ViewModelBuilder{

        //Required parameter(s):
        private ViewState ViewState;

        //Optional parameter(s):
        private String returnString;
        private String quizName;
        private String deckName;
        private String cardId;
        private List<String> cardIdList;
        private int currCardIndex;


        //Constructor (required parameter(s)):
        public ViewModelBuilder(ViewState viewState){
            this.ViewState = viewState;
        }


        //Setters (optional parameter(s)):
        public ViewModelBuilder setReturnString(String returnString) {
            this.returnString = returnString;
            return this;
        }

        public ViewModelBuilder setQuizName(String quizName) {
            this.quizName = quizName;
            return this;
        }

        public ViewModelBuilder setDeckName(String deckName) {
            this.deckName = deckName;
            return this;
        }

        public ViewModelBuilder setCardId(String cardId) {
            this.cardId = cardId;
            return this;
        }

        public ViewModelBuilder setCardIdList(List<String> cardIdList) {
            this.cardIdList = cardIdList;
            return this;
        }

        public ViewModelBuilder setCurrCardIndex(int currCardIndex) {
            this.currCardIndex = currCardIndex;
            return this;
        }

        public ViewModel build(){
            return new ViewModel(this);
        }

    }

}
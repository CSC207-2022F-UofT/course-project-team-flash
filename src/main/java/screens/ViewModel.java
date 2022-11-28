package screens;

//A class to store any current information needed for the view.

import java.util.List;

public class ViewModel {

    //Required Parameter(s):
    private ViewState viewState;


    //Optional parameter(s):
    private String returnString;

    private String userAnswer;

    private String cardAnswer;

    private String cardQuestion;

    private String cardType;
    private String quizName;

    private String deckName;

    private String cardId;

    private List<String> cardIdList;

    private String[] cardIdArray;

    private int currCardIndex;



    private ViewModel(ViewModelBuilder builder){

        this.viewState = builder.ViewState;

        this.returnString = builder.returnString;
        this.userAnswer = builder.userAnswer;
        this.cardAnswer = builder.cardAnswer;
        this.cardQuestion = builder.cardQuestion;
        this.cardType = builder.cardType;
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

    public String getUserAnswer(){
        return this.userAnswer;
    }

    public String getCardAnswer(){
        return this.cardAnswer;
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

    public String[] getCardIdArray(){
        return this.cardIdArray;
    }

    public int getCurrCardIndex() {
        return currCardIndex;
    }

    public String getCardQuestion() {
        return cardQuestion;
    }

    public String getCardType() {
        return cardType;
    }


    //Builder:
    public static class ViewModelBuilder{

        //Required parameter(s):
        private ViewState ViewState;

        //Optional parameter(s):
        private String returnString;

        private String userAnswer;

        private String cardAnswer;
        private String cardQuestion;
        private String cardType;
        private String quizName;
        private String deckName;
        private String cardId;
        private List<String> cardIdList;

        private String[] cardIdArray;
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

        public ViewModelBuilder setUserAnswer(String userAnswer) {
            this.userAnswer = userAnswer;
            return this;
        }

        public ViewModelBuilder setCardAnswer(String cardAnswer){
            this.cardAnswer = cardAnswer;
            return this;
        }

        public ViewModelBuilder setCardQuestion(String cardQuestion) {
            this.cardQuestion = cardQuestion;
            return this;
        }

        public ViewModelBuilder setCardType(String cardType) {
            this.cardType = cardType;
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

        public ViewModelBuilder setCardIdArray(String[] cardIdArray) {
            this.cardIdArray = cardIdArray;
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

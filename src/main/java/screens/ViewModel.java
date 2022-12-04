package screens;

//A class to store any current information needed for the view.

import java.util.List;

public class ViewModel {

    //Required Parameter(s):
    private final ViewState viewState;

    //Optional parameter(s):
    private final String returnString;

    private final String userAnswer;
    private final String cardQuestion;
    private final String cardAnswer;
    private final List<String> cardOptions;
    private final List<String> multipleCardTypes;
    private final List<String> multipleCardAnswers;
    private final List<String> multipleCardQuestions;
    private final List<String> multipleCardIDs;
    private final String cardType;
    private final String quizName;
    private final String quizName2;
    private final String deckName;
    private final String deckName2;
    private final String cardId;
    private final List<String> cardIdList;
    private final String[] cardIdArray;
    private final int currCardIndex;



    private ViewModel(ViewModelBuilder builder){

        this.viewState = builder.ViewState;
        this.returnString = builder.returnString;
        this.userAnswer = builder.userAnswer;
        this.cardQuestion = builder.cardQuestion;
        this.cardAnswer = builder.cardAnswer;
        this.multipleCardTypes = builder.multipleCardTypes;
        this.multipleCardAnswers = builder.multipleCardAnswers;
        this.multipleCardQuestions = builder.multipleCardQuestions;
        this.multipleCardIDs = builder.multipleCardIDs;
        this.cardType = builder.cardType;
        this.quizName = builder.quizName;
        this.quizName2 = builder.quizName2;
        this.deckName = builder.deckName;
        this.deckName2 = builder.deckName2;
        this.cardId = builder.cardId;
        this.cardIdList = builder.cardIdList;
        this.cardIdArray = builder.cardIdArray;
        this.currCardIndex = builder.currCardIndex;
        this.cardOptions = builder.cardOptions;
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

    public String getQuizName2() {
        return quizName2;
    }

    public String getDeckName() {
        return deckName;
    }

    public String getDeckName2() {
        return deckName2;
    }

    public String getCardId() { return cardId; }

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

    public List<String> getMultipleCardTypes() {return multipleCardTypes;}

    public List<String> getMultipleCardQuestions() {
        return multipleCardQuestions;
    }

    public List<String> getMultipleCardAnswers() {
        return multipleCardAnswers;
    }

    public List<String> getMultipleCardIDs() {
        return multipleCardIDs;
    }

    public List<String> getCardOptions() {
        return cardOptions;
    }

    //Builder:
    public static class ViewModelBuilder{

        //Required parameter(s):
        private final ViewState ViewState;

        //Optional parameter(s):
        private String returnString;
        private String userAnswer;
        private String cardQuestion;
        private String cardAnswer;
        private List<String> cardOptions;
        private List<String> multipleCardTypes;
        private List<String> multipleCardAnswers;
        private List<String> multipleCardQuestions;
        private List<String> multipleCardIDs;
        private String cardType;
        private String quizName;
        private String quizName2;
        private String deckName;
        private String deckName2;
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
        public ViewModelBuilder setCardQuestion(String cardQuestion) {
            this.cardQuestion = cardQuestion;
            return this;
        }
        public ViewModelBuilder setCardAnswer(String cardAnswer){
            this.cardAnswer = cardAnswer;
            return this;

        }
        public ViewModelBuilder setCardOptions(List<String> cardOptions){
            this.cardOptions = cardOptions;
            return this;
        }
        public ViewModelBuilder setMultipleCardTypes(List<String> types) {
            this.multipleCardTypes = types;
            return this;
        }
        public ViewModelBuilder setMultipleCardQuestions(List<String> questions) {
            this.multipleCardQuestions = questions;
            return this;
        }
        public ViewModelBuilder setMultipleCardAnswers(List<String> answers) {
            this.multipleCardAnswers = answers;
            return this;
        }
        public ViewModelBuilder setMultipleCardIDs(List<String> ids) {
            this.multipleCardIDs = ids;
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

        public ViewModelBuilder setQuizName2(String quizName2) {
            this.quizName2 = quizName2;
            return this;
        }

        public ViewModelBuilder setDeckName(String deckName) {
            this.deckName = deckName;
            return this;
        }

        public ViewModelBuilder setDeckName2(String deckName2) {
            this.deckName2 = deckName2;
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

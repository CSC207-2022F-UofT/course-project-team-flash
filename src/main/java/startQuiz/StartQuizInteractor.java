//package startQuiz;
//
//import entities.Deck;
//import entities.Flashcard;
//import entities.Quiz;
//import runQuiz.StartQuizInputData;
//import runQuiz.StartQuizOutputData;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class StartQuizInteractor implements StartQuizInputBoundary {
//    final StartQuizOutputBoundary outputBoundary;
//
//    public StartQuizInteractor(StartQuizOutputBoundary outPutBoundary){
//        this.outputBoundary = outPutBoundary;
//    }
//
//    @Override
//    public StartQuizOutputData start(StartQuizInputData userInputData) {
//
//        Quiz currQuiz = entities.Quiz.getQuiz(userInputData.getQuizId());
//
//        if(currQuiz == null){
//            return outputBoundary.prepareFailView("Quiz of name \"" + userInputData.getQuizId() + "\" does not exist.");
//        }
//
//        List<Deck> decks = currQuiz.getDecks();
//
//        List<String> flashcardIdList = new ArrayList<String>();
//
//        //This is an inelegant way of doing this, but the deck class does not have a way to
//        //access cardIDs without depending on the flashcard class in our group's entity implementation.
//        for(Deck deck:decks){
//            for(Flashcard card:deck.getCards()){
//                flashcardIdList.add(card.getUniqueID());
//            }
//        }
//
//        if (userInputData.getIsRandomized()){
//
//            Collections.shuffle(flashcardIdList);
//        }
//
//        //Now that the list of flashcards has been shuffled, they will not need to ever change again.
//        //To discourage changes to attributes of this list, like list length, I have converted the list into an array. \jjc4
//        String[] flashcardIds = flashcardIdList.toArray(new String[0]);
//
//        StartQuizOutputData outputData = new StartQuizOutputData(flashcardIds);
//
//        return outputBoundary.prepareSuccessView(outputData);
//
//
//    }
//}

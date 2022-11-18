//package showAnswer;
//
//import entities.Flashcard;
//import entities.Deck;
//import entities.QandAFlashcard;
//import entities.Quiz;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import runQuiz.ShowAnswerOutputData;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ShowAnswerInteractorTest {
//
//    @Test
//    void start() {
//
//        //Create and set up flashcards, decks, and quizzes to simulate the program:
//
//
//        //Flashcards:
//        Flashcard f1 = new QandAFlashcard("What is music?", "doot doot");
//        Flashcard.addTracker(f1.getUniqueID(), f1);
//        Flashcard f2 = new QandAFlashcard("Who is music?", "boop boop");
//        Flashcard.addTracker(f2.getUniqueID(), f2);
//        Flashcard f3 = new QandAFlashcard("Why is music?", "hoop hoop");
//        Flashcard.addTracker(f3.getUniqueID(), f3);
//
//        //Decks:
//        Deck deck1 = new Deck("music1");
//        Deck.addTracker(deck1.getName(), deck1);
//        Deck deck2 = new Deck("music2");
//        Deck.addTracker(deck2.getName(), deck2);
//
//        deck1.addCard(f1);
//        deck1.addCard(f2);
//        deck2.addCard(f3);
//
//
//        //Quiz:
//        List<Deck> quizDecks = new ArrayList<Deck>();
//
//        quizDecks.add(deck1);
//        quizDecks.add(deck2);
//
//        Quiz musicQuiz = new Quiz("music", quizDecks);
//        Quiz.addTracker(musicQuiz.getQuizName(), musicQuiz);
//
//
//        //Anonymous implementing class
//        ShowAnswerOutputBoundary outputBound = new ShowAnswerOutputBoundary() {
//
//            @Override
//            public ShowAnswerOutputData prepareSuccessView(ShowAnswerOutputData outputData) {
//                Assertions.assertArrayEquals(new String[]{f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()},
//                        outputData.getFlashcardIdList());
//
//                Assertions.assertEquals(2, outputData.getCurrCardIndex());
//
//                Assertions.assertEquals("boop boop", outputData.getCurrCardAnswer());
//
//                Assertions.assertEquals("boop boot", outputData.getUserAnswer());
//
//                return null;
//            }
//
//            @Override
//            public ShowAnswerOutputData prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//                return null;
//            }
//        };
//
//        //Set up the input data:
//        String[] cardIds = {f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()};
//        int currCardIndex = 1;
//        String userAnswer = "boop boot";
//
//        ShowAnswerInputData inputData = new ShowAnswerInputData(cardIds, currCardIndex, userAnswer);
//
//
//        //Create the interactor and run the use case:
//        ShowAnswerInputBoundary interactor = new ShowAnswerInteractor(outputBound);
//        interactor.show(inputData);
//    }
//}
//

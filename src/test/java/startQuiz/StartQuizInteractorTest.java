//package startQuiz;
//
//import entities.Flashcard;
//import entities.Deck;
//import entities.QandAFlashcard;
//import entities.Quiz;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import runQuiz.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class StartQuizInteractorTest {
//
//    @Test
//    void start() {
//        // To test the use case:
//        // 1) Create a UserRegisterInteractor and prerequisite objects
//        //    (arguments for the UserRegisterInteractor constructor parameters)
//        // 2) create the Input Data
//        // 3) Call the use case User Input Boundary method to run the use case
//        // 4) Check that the Output Data passed to the Presenter is correct
//        // 5) Check that the expected changes to the data layer are there.
//
//        // 1) UserRegisterInteractor and prerequisite objects
//        // We're going to need a place to save and look up information. We could
//        // use FileUser, but because unit tests are supposed to be independent
//        // that would make us also reset the file when we are done.
//        // Instead, we're going to "mock" that info using a short-lived solution
//        // that just keeps the info in a dictionary, and it won't be persistent.
//        // (Separately, elsewhere, we will need to test the FileUser works
//        // properly.)
//
//        // This creates an anonymous implementing class for the Output Boundary.
//
//        Flashcard f1 = new QandAFlashcard("What is music", "doot doot");
//        Flashcard.addTracker(f1.getUniqueID(), f1);
//        Flashcard f2 = new QandAFlashcard("Who is music", "boop boop");
//        Flashcard.addTracker(f2.getUniqueID(), f2);
//        Flashcard f3 = new QandAFlashcard("Why is music", "hoop hoop");
//        Flashcard.addTracker(f3.getUniqueID(), f3);
//
//        Deck deck1 = new Deck("music1");
//        Deck.addTracker(deck1.getName(), deck1);
//        Deck deck2 = new Deck("music2");
//        Deck.addTracker(deck2.getName(), deck2);
//
//        deck1.addCard(f1);
//        deck1.addCard(f2);
//        deck2.addCard(f3);
//
//        List<Deck> quizDecks = new ArrayList<Deck>();
//
//        quizDecks.add(deck1);
//        quizDecks.add(deck2);
//
//        Quiz musicQuiz = new Quiz("music", quizDecks);
//        Quiz.addTracker(musicQuiz.getQuizName(), musicQuiz);
//
//        StartQuizOutputBoundary outputBound = new StartQuizOutputBoundary() {
//
//            @Override
//            public StartQuizOutputData prepareSuccessView(StartQuizOutputData outputData) {
//                assertArrayEquals(new String[]{f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()},
//                        outputData.getFlashcardIdList());
//                return null;
//            }
//
//            @Override
//            public StartQuizOutputData prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//                return null;
//            }
//        };
//
//        StartQuizInputBoundary interactor = new StartQuizInteractor(outputBound);
//
//        // 2) Input data — we can make this up for the test. Normally it would
//        // be created by the Controller.
//        StartQuizInputData inputData = new StartQuizInputData(
//                "music", false);
//
//        // 3) Run the use case
//        interactor.start(inputData);
//    }
//}
//

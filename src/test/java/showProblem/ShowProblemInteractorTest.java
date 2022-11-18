//package runQuiz;
//
//import entities.Flashcard;
//import entities.Deck;
//import entities.QandAFlashcard;
//import entities.Quiz;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import showProblem.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ShowProblemInteractorTest {
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
//        ShowProblemOutputBoundary outputBound = new ShowProblemOutputBoundary() {
//
//            @Override
//            public ShowProblemOutputData prepareSuccessView(ShowProblemOutputData outputData) {
//                Assertions.assertArrayEquals(new String[]{f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()},
//                        outputData.getFlashcardIdList());
//
//                Assertions.assertEquals(1, outputData.getCurrCardIndex());
//
//                Assertions.assertEquals("Who is music?", outputData.getCurrCardQuestion());
//                return null;
//            }
//
//            @Override
//            public ShowProblemOutputData prepareFailView(String error) {
//                fail("Use case failure is unexpected.");
//                return null;
//            }
//        };
//
//        //Set up the input data:
//        String[] cardIds = {f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()};
//        int currCardIndex = 1;
//
//        ShowProblemInputData inputData = new ShowProblemInputData(cardIds, currCardIndex);
//
//
//        //Create the interactor and run the use case:
//        ShowProblemInputBoundary interactor = new ShowProblemInteractor(outputBound);
//        interactor.show(inputData);
//    }
//}
//

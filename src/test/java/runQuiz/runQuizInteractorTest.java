package runQuiz;

import entities.Deck;
import entities.Flashcard;
import entities.QandAFlashcard;
import entities.Quiz;


import org.junit.jupiter.api.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RunQuizInteractorTest {

    Flashcard f1;
    Flashcard f2;
    Flashcard f3;
    
    Deck d1;
    Deck d2;
    
    Quiz q1;
    
    @BeforeEach
    void flashcardSetUp() {
        f1 = new QandAFlashcard("What is music?", "doot doot");
        Flashcard.addTracker(f1.getUniqueID(), f1);
        f2 = new QandAFlashcard("Who is music?", "boop boop");
        Flashcard.addTracker(f2.getUniqueID(), f2);
        f3 = new QandAFlashcard("Why is music?", "hoop hoop");
        Flashcard.addTracker(f3.getUniqueID(), f3);
    }
    
    @BeforeEach
    void deckSetup(){
        d1 = new Deck("music1");
        Deck.addTracker(d1.getName(), d1);
        d2 = new Deck("music2");
        Deck.addTracker(d2.getName(), d2);

        d1.addCard(f1);
        d1.addCard(f2);
        d2.addCard(f3);
    }

    @BeforeEach
    void quizSetup(){
        List<Deck> quizDecks = new ArrayList<Deck>();

        quizDecks.add(d1);
        quizDecks.add(d2);

        q1 = new Quiz("music", quizDecks);
        Quiz.addTracker(q1.getQuizName(), q1);
    }
    
    @Test
    void showAnswer() {


        //Anonymous implementing class
        RunQuizOutputBoundary outputBound = new RunQuizOutputBoundary() {

            @Override
            public void prepareSuccessView(ShowAnswerOutputData outputData) {
                Assertions.assertArrayEquals(new String[]{f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()},
                        outputData.getFlashcardIdList());

                Assertions.assertEquals(2, outputData.getCurrCardIndex());

                Assertions.assertEquals("boop boop", outputData.getCurrCardAnswer());

                Assertions.assertEquals("boop boot", outputData.getUserAnswer());

            }

            @Override
            public void prepareSuccessView(ShowProblemOutputData outputData) {
                Assertions.assertArrayEquals(new String[]{f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()},
                        outputData.getFlashcardIdList());

                Assertions.assertEquals(1, outputData.getCurrCardIndex());

                Assertions.assertEquals("Who is music", outputData.getCurrCardQuestion());


            }


            @Override
            public void prepareSuccessView(StartQuizOutputData outputData) {
                Assertions.assertArrayEquals(new String[]{f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()},
                        outputData.getFlashcardIdList());

            }

            @Override
            public void quizFailView(String error) {

            }

        };

        //Set up the input data:
        String[] cardIds = {f1.getUniqueID(), f2.getUniqueID(), f3.getUniqueID()};
        int currCardIndex = 1;
        String userAnswer = "boop boot";

        ShowQuizCardInputData inputData = new ShowQuizCardInputData(cardIds, currCardIndex, userAnswer);


        //Create the interactor and run the use case:
        RunQuizInputBoundary interactor = new RunQuizInteractor(outputBound);
        interactor.showAnswer(inputData);
    }
}


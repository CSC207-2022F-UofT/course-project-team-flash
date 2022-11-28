/*
Author: Jamie Chew
 */

package editQuiz;

import entities.Deck;
import entities.Flashcard;
import entities.QandAFlashcard;
import entities.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import runQuiz.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EditQuizInteractorTest {

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
    void edit() {

        //Anonymous implementing class
        EditQuizOutputBoundary outputBound = new EditQuizOutputBoundary() {
            @Override
            public void prepareSuccessView(EditQuizOutputData outputData) {
                Assertions.assertEquals("moosic", outputData.getMessage());

            }

            @Override
            public void prepareFailView(EditQuizOutputData outputData) {
                Assertions.assertEquals(
                        "Quiz Name already exists. Please try a different name.",
                        outputData.getMessage());

            }
        };


        //Setup input data:
        String oldName = q1.getQuizName();
        String newName = "moosic";

        EditQuizInputData inputData = new EditQuizInputData(oldName, newName);

        //Create interactor and run the use case:
        EditQuizInteractor interactor = new EditQuizInteractor(outputBound);
        interactor.edit(inputData);

        List<Deck> q2Decks = new ArrayList<>();

        q2Decks.add(d1);
        q2Decks.add(d2);

        Quiz q2 = new Quiz("cisum", q2Decks);

        String oldName2 = "cisum";
        String newName2 = "moosic";

        EditQuizInputData inputData2 = new EditQuizInputData(oldName2, newName2);

        interactor.edit(inputData2);
    }

}
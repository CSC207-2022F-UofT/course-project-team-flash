package runQuiz;

import entities.Deck;
import entities.Flashcard;
import entities.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RunQuizInteractor implements RunQuizInputBoundary {


    final RunQuizOutputBoundary outputBoundary;

    public RunQuizInteractor(RunQuizOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }


    @Override
    public StartQuizOutputData startQuiz(StartQuizInputData inputData) {

        Quiz currQuiz = entities.Quiz.getQuiz(inputData.getQuizId());

        if(currQuiz == null){
            return outputBoundary.quizFailView("Quiz of name \"" + inputData.getQuizId() + "\" does not exist.");
        }

        List<String> flashcardIdList = fetchQuizCardIds(currQuiz);

        if (inputData.getIsRandomized()){
            Collections.shuffle(flashcardIdList);
        }

        String[] flashcardIds = flashcardIdList.toArray(new String[0]);

        StartQuizOutputData outputData = new StartQuizOutputData(flashcardIds);

        return outputBoundary.prepareSuccessView(outputData);
    }


    @Override
    public ShowProblemOutputData showProblem(ShowQuizCardInputData inputData) {

        Flashcard currCard = fetchCard(inputData);

        ShowProblemOutputData outputData = new ShowProblemOutputData(inputData.getFlashcardIdList(),
                inputData.getCurrCardIndex(),
                currCard.getQuestion()
                );

        return outputBoundary.prepareSuccessView(outputData);
    }


    @Override
    public ShowAnswerOutputData showAnswer(ShowQuizCardInputData inputData) {

        Flashcard currCard = fetchCard(inputData);

        ShowAnswerOutputData outputData = new ShowAnswerOutputData(inputData.getFlashcardIdList(),
                inputData.getCurrCardIndex(),
                inputData.getUserAnswer(),
                currCard.getAnswer());

        outputData.incCurrCardIndex(1);

        return outputBoundary.prepareSuccessView(outputData);
    }



    private Flashcard fetchCard(ShowQuizCardInputData inputData){
        return Flashcard.getTracker().get(inputData.getFlashcardIdList()[inputData.getCurrCardIndex()]);

    }


    private List<String> fetchQuizCardIds(Quiz quiz){

        List<String> flashcardIdList = new ArrayList<String>();

        for(Deck deck:quiz.getDecks()){
            for(Flashcard card:deck.getCards()){
                flashcardIdList.add(card.getUniqueID());
            }
        }

        return flashcardIdList;
    }
}
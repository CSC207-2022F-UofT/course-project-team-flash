package showAnswer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowAnswerInteractorTest {

    @Test
    public void ShowAnswerInteractorShowTest(){
        //Set up actual output
        ShowAnswerPresenter presenter = new ShowAnswerPresenter();
        ShowAnswerInteractor interactor = new ShowAnswerInteractor(presenter);

        String[] cardIdList = {"1", "2", "3", "4", "5"};
        int currIndex = 1;
        String userAnswer = "spaghetti";

        ShowAnswerInputData inputData = new ShowAnswerInputData(cardIdList, currIndex, userAnswer);

        ShowAnswerOutputData actual = interactor.show(inputData);

        //Set up expected output
        String[] expCardIdList = {"1", "2", "3", "4", "5"};
        int expCurrIndex = 2;
        String expUserAnswer = "spaghetti";

        //compare
        Assertions.assertArrayEquals(actual.getFlashcardIdList(), expCardIdList);
        Assertions.assertEquals(actual.getCurrCardIndex(), expCurrIndex);
        Assertions.assertEquals(actual.getUserAnswer(), expUserAnswer);
    }

}
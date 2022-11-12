package showAnswer;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ShowAnswerControllerTest {

    @Test
    public void ShowAnswerControllerShowTest(){

        //Set up actual output
        ShowAnswerPresenter presenter = new ShowAnswerPresenter();
        ShowAnswerInteractor interactor = new ShowAnswerInteractor(presenter);
        ShowAnswerController controller = new ShowAnswerController(interactor);

        String[] cardIdList = {"1", "2", "3", "4", "5"};
        int currIndex = 1;
        String userAnswer = "spaghetti";

        ShowAnswerOutputData actual = controller.show(cardIdList, currIndex, userAnswer);

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
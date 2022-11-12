package showProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ShowProblemControllerTest {
    @Test
    public void ShowProblemControllerShowTest(){

        //Set up actual output
        ShowProblemPresenter presenter = new ShowProblemPresenter();
        ShowProblemInteractor interactor = new ShowProblemInteractor(presenter);
        ShowProblemController controller = new ShowProblemController(interactor);

        String[] cardIdList = {"1", "2", "3", "4", "5"};
        int currIndex = 1;

        ShowProblemOutputData actual = controller.show(cardIdList, currIndex);

        //Set up expected output
        String[] expCardIdList = {"1", "2", "3", "4", "5"};
        int expCurrIndex = 1;

        //compare
        Assertions.assertArrayEquals(actual.getFlashcardIdList(), expCardIdList);
        Assertions.assertEquals(actual.getCurrCardIndex(), expCurrIndex);

    }
}
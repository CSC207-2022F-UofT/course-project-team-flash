package showProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ShowProblemInteractorTest {
    @Test
    public void ShowProblemInteractorShowTest(){
        //Set up actual output
        ShowProblemPresenter presenter = new ShowProblemPresenter();
        ShowProblemInteractor interactor = new ShowProblemInteractor(presenter);

        String[] cardIdList = {"1", "2", "3", "4", "5"};
        int currIndex = 1;

        ShowProblemInputData inputData = new ShowProblemInputData(cardIdList, currIndex);

        ShowProblemOutputData actual = interactor.show(inputData);

        //Set up expected output
        String[] expCardIdList = {"1", "2", "3", "4", "5"};
        int expCurrIndex = 1;


        //compare
        Assertions.assertArrayEquals(expCardIdList, actual.getFlashcardIdList());
        Assertions.assertEquals(expCurrIndex, actual.getCurrCardIndex());

    }
}
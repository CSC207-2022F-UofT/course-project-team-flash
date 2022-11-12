package showProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import showProblem.ShowProblemOutputData;

import static org.junit.jupiter.api.Assertions.*;

class ShowProblemPresenterTest {

    @Test
    public void ShowProblemPresenterSuccessViewTest(){
        String[] cardIdList = {"1", "2", "3", "4"};
        int currIndex = 1;

        ShowProblemOutputData outputData = new ShowProblemOutputData(cardIdList, currIndex);

        String[] expCardIdList = {"1", "2", "3", "4"};
        int expCurrIndex = 1;

        Assertions.assertArrayEquals(expCardIdList, outputData.getFlashcardIdList());
        Assertions.assertEquals(expCurrIndex, outputData.getCurrCardIndex());
    }
}
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
        ShowProblemPresenter presenter = new ShowProblemPresenter();

        String[] expCardIdList = {"1", "2", "3", "4"};
        int expCurrIndex = 1;

        Assertions.assertArrayEquals(expCardIdList, presenter.prepareSuccessView(outputData).getFlashcardIdList());
        Assertions.assertEquals(expCurrIndex, presenter.prepareSuccessView(outputData).getCurrCardIndex());
    }
}
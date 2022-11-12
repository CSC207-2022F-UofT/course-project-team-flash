package showProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ShowProblemOutputDataTest {
    @Test
    public void ShowProblemOutDataGetCardIdList(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;


        ShowProblemOutputData OutputData = new ShowProblemOutputData(cardIdList, currIndex);

        String[] expCardIdList = {"1", "2", "3"};

        Assertions.assertArrayEquals(OutputData.getFlashcardIdList(), cardIdList);

    }

    @Test
    public void ShowProblemOutputDataGetCurrIndex(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;


        ShowProblemOutputData OutputData = new ShowProblemOutputData(cardIdList, currIndex);

        int expCurrIndex = 1;

        Assertions.assertEquals(OutputData.getCurrCardIndex(), expCurrIndex);

    }
}
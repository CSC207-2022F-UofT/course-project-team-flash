package showProblem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShowProblemInputDataTest {
    @Test
    public void ShowProblemInputDataGetCardIdList(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;


        ShowProblemInputData inputData = new ShowProblemInputData(cardIdList, currIndex);

        String[] expCardIdList = {"1", "2", "3"};

        Assertions.assertArrayEquals(inputData.getFlashcardIdList(), cardIdList);

    }

    @Test
    public void ShowProblemInputDataGetCurrIndex(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;


        ShowProblemInputData inputData = new ShowProblemInputData(cardIdList, currIndex);

        int expCurrIndex = 1;

        Assertions.assertEquals(inputData.getCurrCardIndex(), expCurrIndex);

    }

}
package showAnswer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowAnswerInputDataTest {

    @Test
    public void ShowAnswerInputDataGetCardIdList(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;
        String userAnswer = "fettuccine";

        ShowAnswerInputData inputData = new ShowAnswerInputData(cardIdList, currIndex, userAnswer);

        String[] expCardIdList = {"1", "2", "3"};

        Assertions.assertArrayEquals(inputData.getFlashcardIdList(), cardIdList);

    }

    @Test
    public void ShowAnswerInputDataGetCurrIndex(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;
        String userAnswer = "fettuccine";

        ShowAnswerInputData inputData = new ShowAnswerInputData(cardIdList, currIndex, userAnswer);

        int expCurrIndex = 1;

        Assertions.assertEquals(inputData.getCurrCardIndex(), expCurrIndex);

    }

    @Test
    public void ShowAnswerInputDataGetUserAnswer(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;
        String userAnswer = "fettuccine";

        ShowAnswerInputData inputData = new ShowAnswerInputData(cardIdList, currIndex, userAnswer);

        String expUserAnswer = "fettuccine";

        Assertions.assertEquals(inputData.getUserAnswer(), expUserAnswer);

    }
}
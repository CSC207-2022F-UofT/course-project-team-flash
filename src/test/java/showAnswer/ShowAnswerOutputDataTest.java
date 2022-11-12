package showAnswer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowAnswerOutputDataTest {
    @Test
    public void ShowAnswerOutDataGetCardIdList(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;
        String userAnswer = "fettuccine";

        ShowAnswerOutputData OutputData = new ShowAnswerOutputData(cardIdList, currIndex, userAnswer);

        String[] expCardIdList = {"1", "2", "3"};

        Assertions.assertArrayEquals(OutputData.getFlashcardIdList(), cardIdList);

    }

    @Test
    public void ShowAnswerOutputDataGetCurrIndex(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;
        String userAnswer = "fettuccine";

        ShowAnswerOutputData OutputData = new ShowAnswerOutputData(cardIdList, currIndex, userAnswer);

        int expCurrIndex = 1;

        Assertions.assertEquals(OutputData.getCurrCardIndex(), expCurrIndex);

    }

    @Test
    public void ShowAnswerOutputDataGetUserAnswer(){
        String[] cardIdList = {"1", "2", "3"};
        int currIndex = 1;
        String userAnswer = "fettuccine";

        ShowAnswerOutputData OutputData = new ShowAnswerOutputData(cardIdList, currIndex, userAnswer);

        String expUserAnswer = "fettuccine";

        Assertions.assertEquals(OutputData.getUserAnswer(), expUserAnswer);

    }
}
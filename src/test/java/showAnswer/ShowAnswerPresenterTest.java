package showAnswer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShowAnswerPresenterTest {

    @Test
    public void ShowAnswerPresenterSuccessViewTest(){
        String[] cardIdList = {"1", "2", "3", "4"};
        int currIndex = 1;
        String userAnswer = "penne";

        ShowAnswerOutputData outputData = new ShowAnswerOutputData(cardIdList, currIndex, userAnswer);
        ShowAnswerPresenter presenter = new ShowAnswerPresenter();

        int expCurrIndex = 2;


        Assertions.assertEquals(expCurrIndex, presenter.prepareSuccessView(outputData).getCurrCardIndex());
    }

}
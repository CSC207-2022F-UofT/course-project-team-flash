package showAnswer;

public class ShowAnswerController {

    final ShowAnswerInputBoundary showAnswerInputBound;

    ShowAnswerController(ShowAnswerInputBoundary showAnswerInput){
        this.showAnswerInputBound = showAnswerInput;
    }


    ShowAnswerOutputData show(String[] flashcardIdList, int currCardIndex, String userAnswer){
        ShowAnswerInputData requestModel = new ShowAnswerInputData(flashcardIdList, currCardIndex, userAnswer);

        return showAnswerInputBound.show(requestModel);
    }

}

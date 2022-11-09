package showAnswer;

public class ShowAnswerController {

    final ShowAnswerInputBoundary showAnswerInput;

    ShowAnswerController(ShowAnswerInputBoundary showAnswerInput){
        this.showAnswerInput = showAnswerInput;
    }

    ShowAnswerOutputData show(String[] flashcardIdList, int currCardIndex, String userAnswer){
        ShowAnswerInputData requestModel = new ShowAnswerInputData(flashcardIdList, currCardIndex, userAnswer);

        return showAnswerInput.show(requestModel);
    }
}

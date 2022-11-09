package showProblem;

import java.util.ArrayList;

public class ShowProblemController {
    ShowProblemInputBoundary showProblemInput;

    public ShowProblemController(ShowProblemInputBoundary input){
        this.showProblemInput = input;
    }

    ShowProblemOutputData show(ArrayList<String> flashcardIdList, int currCardIndex){
        ShowProblemInputData requestModel = new ShowProblemInputData(flashcardIdList, currCardIndex);

        return showProblemInput.show(requestModel);
    }
}

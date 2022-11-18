//package showProblem;
//
//import runQuiz.ShowProblemOutputData;
//
//public class ShowProblemController {
//    ShowProblemInputBoundary showProblemInput;
//
//    public ShowProblemController(ShowProblemInputBoundary input){
//        this.showProblemInput = input;
//    }
//
//    ShowProblemOutputData show(String[] flashcardIdList, int currCardIndex){
//        ShowProblemInputData requestModel = new ShowProblemInputData(flashcardIdList, currCardIndex);
//
//        return showProblemInput.show(requestModel);
//    }
//}

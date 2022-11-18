//package showProblem;
//
//
//import entities.Flashcard;
//import runQuiz.ShowProblemOutputData;
//
//public class ShowProblemInteractor implements ShowProblemInputBoundary {
//
//    final ShowProblemOutputBoundary outputBoundary;
//
//    ShowProblemInteractor(ShowProblemOutputBoundary outPutBoundary){
//        this.outputBoundary = outPutBoundary;
//    }
//
//
//    @Override
//    public ShowProblemOutputData show(ShowProblemInputData userInputData) {
//
//        if(userInputData.getCurrCardIndex() == userInputData.getFlashcardIdList().length - 1){
//            return outputBoundary.prepareFailView("End of quiz.");
//        }
//
//        Flashcard currCard = Flashcard.getTracker().get(userInputData.getFlashcardIdList()
//                [userInputData.getCurrCardIndex()]);
//
//        ShowProblemOutputData outputData = new ShowProblemOutputData(userInputData.getFlashcardIdList(),
//                userInputData.getCurrCardIndex(),
//                currCard.getQuestion());
//
//        return outputBoundary.prepareSuccessView(outputData);
//    }
//
//
//}

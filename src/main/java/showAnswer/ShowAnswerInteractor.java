//package showAnswer;
//
//import entities.Flashcard;
//import runQuiz.ShowAnswerOutputData;
//
//public class ShowAnswerInteractor implements ShowAnswerInputBoundary {
//
//    final ShowAnswerOutputBoundary outputBoundary;
//
//    ShowAnswerInteractor(ShowAnswerOutputBoundary outputBoundary){
//        this.outputBoundary = outputBoundary;
//    }
//
//    @Override
//    public ShowAnswerOutputData show(ShowAnswerInputData userInputData) {
//
//        Flashcard currCard = Flashcard.getTracker().get(
//                userInputData.getFlashcardIdList()[userInputData.getCurrCardIndex()]);
//
//        ShowAnswerOutputData outputData = new ShowAnswerOutputData(userInputData.getFlashcardIdList(),
//                userInputData.getCurrCardIndex(),
//                userInputData.getUserAnswer(),
//                currCard.getAnswer());
//
//        return outputBoundary.prepareSuccessView(outputData);
//    }
//}

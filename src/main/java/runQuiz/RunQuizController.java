package runQuiz;

public class RunQuizController {

    final RunQuizInputBoundary runQuizInputBound;

    RunQuizController(RunQuizInputBoundary runQuizInputBound){
        this.runQuizInputBound = runQuizInputBound;
    }


    void showAnswer(String[] flashcardIdList, int currCardIndex, String userAnswer){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex, userAnswer);

        runQuizInputBound.showAnswer(inputData);
    }


    void showProblem(String[] flashcardIdList, int currCardIndex){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex);

        runQuizInputBound.showProblem(inputData);
    }


    void startQuiz(String quizId, boolean isRandomized){
        StartQuizInputData inputData = new StartQuizInputData(quizId, isRandomized);

        runQuizInputBound.startQuiz(inputData);
    }

}

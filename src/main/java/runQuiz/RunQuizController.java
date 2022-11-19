package runQuiz;

public class RunQuizController {

    final RunQuizInputBoundary runQuizInputBound;

    RunQuizController(RunQuizInputBoundary runQuizInputBound){
        this.runQuizInputBound = runQuizInputBound;
    }


    ShowAnswerOutputData showAnswer(String[] flashcardIdList, int currCardIndex, String userAnswer){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex, userAnswer);

        return runQuizInputBound.showAnswer(inputData);
    }


    ShowProblemOutputData showProblem(String[] flashcardIdList, int currCardIndex){
        ShowQuizCardInputData inputData = new ShowQuizCardInputData(flashcardIdList, currCardIndex);

        return runQuizInputBound.showProblem(inputData);
    }


    StartQuizOutputData startQuiz(String quizId, boolean isRandomized){
        StartQuizInputData inputData = new StartQuizInputData(quizId, isRandomized);

        return runQuizInputBound.startQuiz(inputData);
    }

}

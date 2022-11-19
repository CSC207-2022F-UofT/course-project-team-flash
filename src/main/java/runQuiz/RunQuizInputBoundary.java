package runQuiz;

public interface RunQuizInputBoundary {

    StartQuizOutputData startQuiz(StartQuizInputData inputData);

    ShowProblemOutputData showProblem(ShowQuizCardInputData inputData);

    ShowAnswerOutputData showAnswer(ShowQuizCardInputData inputData);

}

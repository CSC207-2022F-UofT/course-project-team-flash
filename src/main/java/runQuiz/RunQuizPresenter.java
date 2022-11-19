package runQuiz;

import screens.viewStates;
import screens.QuizNotFound;

public class RunQuizPresenter implements RunQuizOutputBoundary {

    @Override
    public ShowAnswerOutputData prepareSuccessView(ShowAnswerOutputData outputData) {
        outputData.setViewState(viewStates.SHOW_PROBLEM);

        return outputData;
    }

    @Override
    public ShowProblemOutputData prepareSuccessView(ShowProblemOutputData outputData) {

        if(outputData.noMoreProblems()){
            outputData.setViewState(viewStates.QUIZ_MENU);
        }
        else {
            outputData.setViewState(viewStates.SHOW_ANSWER);
        }

        return outputData;

    }

    @Override
    public StartQuizOutputData prepareSuccessView(StartQuizOutputData outputData) {
        outputData.setViewState(viewStates.SHOW_PROBLEM);

        return outputData;
    }

    public StartQuizOutputData quizFailView(String error){
        throw new QuizNotFound(error);
    }
}

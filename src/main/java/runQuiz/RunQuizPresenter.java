package runQuiz;

import screens.*;

import java.util.Arrays;

public class RunQuizPresenter implements RunQuizOutputBoundary {

    private ViewBoundary viewBound;

    RunQuizPresenter(ViewBoundary viewBound){
        this.viewBound = viewBound;
    }

    @Override
    public void prepareSuccessView(ShowAnswerOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_PROBLEM)
                .setCardIdArray(outputData.getFlashcardIdList())
                .setCurrCardIndex(outputData.getCurrCardIndex())
                .setUserAnswer(outputData.getUserAnswer())
                .setCardAnswer(outputData.getCurrCardAnswer())
                .build();

        viewBound.updateView(viewModel);
    }

    @Override
    public void prepareSuccessView(ShowProblemOutputData outputData) {

        if(outputData.noMoreProblems()){
            ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.QUIZ_MENU)
                    .setReturnString("End of quiz!")
                    .build();

            viewBound.updateView(viewModel);
        }

        else {
            ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_ANSWER)
                    .setCardIdArray(outputData.getFlashcardIdList())
                    .setCurrCardIndex(outputData.getCurrCardIndex())
                    .setReturnString(outputData.getCurrCardQuestion())
                    .build();

            viewBound.updateView(viewModel);
        }

        System.out.println("Not sure how we got here");



    }

    @Override
    public void prepareSuccessView(StartQuizOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_PROBLEM)
                .setCardIdArray(outputData.getFlashcardIdList())
                .setCurrCardIndex(outputData.getCurrCardIndex())
                .setReturnString(outputData.getFirstCardProblem())
                .build();

        viewBound.updateView(viewModel);
    }

    public void quizFailView(String error){
        throw new QuizNotFound(error);
    }
}

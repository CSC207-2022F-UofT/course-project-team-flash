package runQuiz;

import screens.*;

import java.util.Arrays;

public class RunQuizPresenter implements RunQuizOutputBoundary {

    private ViewBoundary viewBound;


    /**
     * Creates a RunQuizPresenter object given a ViewBoundary object.
     *
     * @param viewBound the interface between this presenter and the view.
     */
    public RunQuizPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }

    /**
     * Prepares the success view given a ShowAnswerOutputData, if the quiz exists.
     *
     * @param outputData the ShowAnswerOutputData associated with this problem
     */
    @Override
    public void prepareSuccessView(ShowAnswerOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_ANSWER)
                .setCardIdArray(outputData.getFlashcardIdList())
                .setCurrCardIndex(outputData.getCurrCardIndex())
                .setUserAnswer(outputData.getUserAnswer())
                .setCardAnswer(outputData.getCurrCardAnswer())
                .build();

        viewBound.updateView(viewModel);
    }

    /**
     * Prepares the success view given a ShowProblemOutputData, if the quiz exists.
     *
     * @param outputData the ShowProblemOutputData associated with this problem
     */
    @Override
    public void prepareSuccessView(ShowProblemOutputData outputData) {

        if (outputData.noMoreProblems()) {
            ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.QUIZ_MENU)
                    .setReturnString("End of quiz!")
                    .build();

            viewBound.updateView(viewModel);
        } else {
            ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_PROBLEM)
                    .setCardIdArray(outputData.getFlashcardIdList())
                    .setCurrCardIndex(outputData.getCurrCardIndex())
                    .setReturnString(outputData.getCurrCardQuestion())
                    .setCardOptions(outputData.getCardOptions())
                    .build();

            viewBound.updateView(viewModel);
        }

    }

    /**
     * Prepares the success view given a StartQuizOutputData, if the quiz exists.
     *
     * @param outputData the StartQuizOutputData associated with this quiz
     */
    @Override
    public void prepareSuccessView(StartQuizOutputData outputData) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.SHOW_PROBLEM)
                .setCardIdArray(outputData.getFlashcardIdList())
                .setCurrCardIndex(outputData.getCurrCardIndex())
                .setReturnString(outputData.getFirstCardProblem())
                .setCardOptions(outputData.getFirstCardOptions())
                .build();

        viewBound.updateView(viewModel);
    }

    /**
     * Prepare the fail view given outputData, if the quiz does not exist.
     *
     * @param error the description of this error
     */
    public void quizFailView(String error) {

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ERROR)
                .setReturnString(error)
                .build();

        viewBound.updateView(viewModel);
    }
}

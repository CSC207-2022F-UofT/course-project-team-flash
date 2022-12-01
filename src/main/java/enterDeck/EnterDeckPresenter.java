package enterDeck;

import screens.ViewBoundary;
import screens.ViewModel;
import screens.ViewState;

import java.util.ArrayList;
import java.util.List;

public class EnterDeckPresenter implements EnterDeckOutputBoundary {

    ViewBoundary viewBound;

    public EnterDeckPresenter(ViewBoundary viewBound) {
        this.viewBound = viewBound;
    }
    @Override
    public void prepareSuccessView(EnterDeckOutputData outputData) {
        List<String> types = new ArrayList<>();
        List<String> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();

        for (List<String> info : outputData.getCardInfo()) {
            types.add(info.get(0));
            questions.add(info.get(1));
            answers.add(info.get(2));
        }

        ViewModel viewModel = new ViewModel.ViewModelBuilder(ViewState.ENTER_DECK)
                .setMultipleCardTypes(types)
                .setMultipleCardQuestions(questions)
                .setMultipleCardAnswers(answers)
                .build();

        viewBound.updateView(viewModel);
    }
}

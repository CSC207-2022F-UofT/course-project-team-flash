package startQuiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StartQuizInteractor implements StartQuizInputBoundary{
    final StartQuizOutputBoundary outputBoundary;

    final StartQuizDsGateway dsGateway;

    private StartQuizInteractor(StartQuizOutputBoundary outPutBoundary, StartQuizDsGateway dsGateway){
        this.outputBoundary = outPutBoundary;
        this.dsGateway = dsGateway;
    }

    @Override
    public StartQuizOutputData start(StartQuizInputData userInputData) {

        String[] flashcardIds = dsGateway.fetchQuizCardIds(userInputData.getQuizId());

        if(flashcardIds == null){
            return outputBoundary.prepareFailView("No quiz found");
        }

        if (userInputData.getIsRandomized()){

            List<String> flashcardIdList = Arrays.asList(flashcardIds);

            Collections.shuffle(flashcardIdList);

            flashcardIdList.toArray(flashcardIds);
        }

        StartQuizOutputData outputData = new StartQuizOutputData(flashcardIds);

        return outputBoundary.prepareSuccessView(outputData);


    }
}

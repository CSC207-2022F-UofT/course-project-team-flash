package deleteQuiz;

import entities.Quiz;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteQuizInteractorTest {
    @Test
    public void deleteSingleQuiz(){
        String quizName = "DeleteQuizTest1";
        Quiz quiz = new Quiz(quizName, null);
        Quiz.addTracker(quizName, quiz);
        DeleteQuizOutputBoundary presenter = new DeleteQuizPresenter(null){
            @Override
            public void prepareSuccessView(DeleteQuizOutputData outputData){
                Assertions.assertEquals(outputData.getQuizName(), "DeleteQuizTest1");
                Assertions.assertEquals(outputData.getMessage(), "Successfully removed quiz.");
            }

            @Override
            public void prepareFailView(DeleteQuizOutputData outputData){
                Assertions.fail(outputData.getMessage());
            }
        };
        DeleteQuizInputBoundary interactor = new DeleteQuizInteractor(presenter);
        DeleteQuizInputData inputData = new DeleteQuizInputData(quizName);
        interactor.deleteQuiz(inputData);
    }

    @Test
    public void deleteNonExistingQuiz(){
        DeleteQuizOutputBoundary presenter = new DeleteQuizPresenter(null){
            @Override
            public void prepareSuccessView(DeleteQuizOutputData outputData){
                Assertions.fail("Cannot delete nothing!");
            }

            @Override
            public void prepareFailView(DeleteQuizOutputData outputData){
                Assertions.assertNull(outputData.getQuizName());
                Assertions.assertEquals(outputData.getMessage(), "This quiz name does not exist.");
            }
        };
        DeleteQuizInputBoundary interactor = new DeleteQuizInteractor(presenter);
        DeleteQuizInputData inputData = new DeleteQuizInputData("DeleteQuizTest2");
        interactor.deleteQuiz(inputData);
    }
}
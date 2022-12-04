/*
 * Author: Andrew Nguyen
 * Documentation Author: Andrew Nguyen
 * Date: November 27/22
 *
 * Interactor that makes the required changes to the quiz entity
 */
package editQuiz;

import entities.Quiz;

public class EditQuizInteractor implements EditQuizInputBoundary{

    private final EditQuizOutputBoundary outputBoundary;

    /**
     * Creates a new EditQuizInteractor with the given output boundary and card factory.
     *
     * @param outputBoundary an instance of an EditQuizOutputBoundary
     */
    public EditQuizInteractor(EditQuizOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    /**
     * Changes the name of the quiz
     *
     * @param inputData the EditQuizInputData for this interactor
     */
    @Override
    public void edit(EditQuizInputData inputData) {
        if (Quiz.getTracker().containsKey(inputData.getNewName())) {
            EditQuizOutputData outputData = new EditQuizOutputData("Quiz Name already exists. Please try a different name.");
            outputBoundary.prepareFailView(outputData);
        } else {
            Quiz quiz = Quiz.getQuiz(inputData.getOldName());
            quiz.setQuizName(inputData.getNewName());

            Quiz.removeTracker(inputData.getOldName());
            Quiz.addTracker(inputData.getNewName(), quiz);

            EditQuizOutputData outputData = new EditQuizOutputData(inputData.getNewName(), inputData.getOldName());
            outputBoundary.prepareSuccessView(outputData);
        }

    }
}

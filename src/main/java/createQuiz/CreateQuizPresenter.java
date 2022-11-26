/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains the implementation of the CreateQuizPresenter,
 * which implements CreateQuizOutputBoundary.
 */

package createQuiz;

public class CreateQuizPresenter implements CreateQuizOutputBoundary{

    /**
     * Prepare the success view given outputData, if the quiz is created and stored successfully.
     *
     * @param outputData the CreateQuizOutputData associated with this created quiz
     */
    @Override
    public void prepareSuccessView(CreateQuizOutputData outputData){

    }
    /**
     * Prepare the fail view given outputData, if the quiz cannot be created or stored successfully.
     *
     * @param outputData the CreateQuizOutputData associated with this created quiz
     */
    @Override
    public void prepareFailView(CreateQuizOutputData outputData){
    }

}
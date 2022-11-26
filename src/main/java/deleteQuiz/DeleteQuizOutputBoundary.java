/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 25/22
 *
 * This file contains an interface named DeleteQuizOutputBoundary.
 * It has two interface methods named prepareSuccessView and prepareFailView.
 */

package deleteQuiz;

public interface DeleteQuizOutputBoundary {

    void prepareSuccessView(DeleteQuizOutputData outputData);

    void prepareFailView(DeleteQuizOutputData outputData);
}
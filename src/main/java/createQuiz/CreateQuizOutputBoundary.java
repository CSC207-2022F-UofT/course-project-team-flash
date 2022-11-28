/*
 * Author: Jasmine Tsoi
 * Documentation Author: Jasmine Tsoi
 * Date: November 21/22
 *
 * This file contains an interface named CreateQuizOutputBoundary.
 * It has two interface methods named prepareSuccessView and prepareFailView.
 */

package createQuiz;

public interface CreateQuizOutputBoundary {

    void prepareSuccessView(CreateQuizOutputData outputData);

    void prepareFailView(CreateQuizOutputData outputData);
}
package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * The output boundary for edit card systems
 */

public interface EditCardOutputBoundary {

    void prepareSuccessView(EditCardOutputData editCardOutputData);

    void prepareFailView(EditCardOutputData editCardOutputData);
}

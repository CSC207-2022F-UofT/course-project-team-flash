package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * This interface allows cards to be edited by higher level classes
 */

import createCard.CreateCardInputData;

public interface EditCardInputBoundary {

    void edit(EditCardInputData inputData);
}

package editCard;/*
 * Author: Albert Yan
 * Date: October 31/22
 * This interface allows cards to be edited by higher level classes
 */

import createCard.CreateCardInputData;

/**
 * This file contains an interface named EditCardInputBoundary with a abstract method edit
 */
public interface EditCardInputBoundary {

    void edit(EditCardInputData inputData);
}

package screens;

public interface ViewBoundary {

    void setViewState(viewStates viewState);

    void storeUserAnswer(String userAnswer);

    void storeCurrId(int currCardIndex);

    void storeFlashcardList(String[] flashcardIdList);

    void storeDeckName(String deckName);
}

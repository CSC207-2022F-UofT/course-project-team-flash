package exportDeck;

import java.util.List;

public class ExportDeckDsInputData {
    private final String fileLocation;
    private final String deckExportName;
    private final List<String> deckCards;

    public ExportDeckDsInputData(String fileLocation, String deckName, List<String> deckCards) {
        this.fileLocation = fileLocation;
        this.deckExportName = deckName;
        this.deckCards = deckCards;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public String getDeckExportName() {
        return deckExportName;
    }

    public List<String> getDeckCards() {
        return deckCards;
    }
}

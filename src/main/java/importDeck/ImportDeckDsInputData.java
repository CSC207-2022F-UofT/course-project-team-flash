/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 26/22
 * This is the input data for the gateway
 */

package importDeck;

public class ImportDeckDsInputData {
    private final String filePath;

    /**
     * Constructor for the gateway input data
     * @param filePath where the file is located
     */
    public ImportDeckDsInputData(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the location of the file
     */
    public String getFilePath(){
        return filePath;
    }
}

/*
* Author: Aldo Bani
* Date: November 9/22
* This is the input data needed for the deck import system
*/

package importDeck;

public class ImportDeckInputData {
    private String fileName;
    private String fileContents;

    /**
     * Creates a data object for deck import input.
     * @param fileName name of the file
     * @param fileContents contents of the file
     */
    public ImportDeckInputData(String fileName, String fileContents){
        this.fileName = fileName;
        this.fileContents = fileContents;
    }

    /**
     * @return name of the file
     */
    String getFileName(){
        return fileName;
    }

    /**
     * @return contents of the file
     */
    String getFileContents(){
        return fileContents;
    }
}

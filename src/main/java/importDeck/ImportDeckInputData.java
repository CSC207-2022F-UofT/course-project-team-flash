/*
* Author: Aldo Bani
* Date: November 9/22
* This is the input data needed for the deck import system
*/

package importDeck;

public class ImportDeckInputData {
    private String fileName;
    private String fileContents;

    public ImportDeckInputData(String fileName, String fileContents){
        this.fileName = fileName;
        this.fileContents = fileContents;
    }

    String getFileName(){
        return fileName;
    }

    String getFileContents(){
        return fileContents;
    }
}

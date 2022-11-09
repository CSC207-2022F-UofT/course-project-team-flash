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

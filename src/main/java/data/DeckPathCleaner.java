/*
 * Author: Aldo Bani
 * Documentation Author: Aldo Bani
 * Date: November 26/22
 */
package data;

/**
 * Helper Method to clean up filepath
 */
public class DeckPathCleaner {
    /**
     * Removes path and extension from a file
     * @param filePath where the file is located
     * @return clean name of the file
     */
    public static String cleanName(String filePath){
        String[] splitPath = filePath.replace("\\", "/").split("/");
        String deckFileName = splitPath[splitPath.length-1];
        try {
            return deckFileName.substring(0, deckFileName.lastIndexOf('.'));
        }
        catch (StringIndexOutOfBoundsException e){
            return deckFileName;
        }
    }
}

package com.core;
import java.io.FileOutputStream;
import java.io.IOException;

public class SenderInCSV {
    private final int STARTING_COUNT = 0;
    private final String DELIMITER=" ; ";
    private final String PROCENT_AND_TRANSFER="%\n";
    private final Double HUNDRED_PROCENT=100.0;

    private final String ENCODING="Cp1252";
    private final boolean ENTRY_FROM_A_NEW_LINE = true;

    private final String EXCEPTION_STRING="Error while reading file: ";

    public void sendData(java.util.Scanner scannerFilesNames){
        java.io.OutputStreamWriter push=null;
        String fileName=scannerFilesNames.next();

        try{
            push = new java.io.OutputStreamWriter(new FileOutputStream(fileName,ENTRY_FROM_A_NEW_LINE),ENCODING);
            SortingWords sortingWords=new SortingWords();
            sortingWords.sorting(scannerFilesNames);
            for(int i=STARTING_COUNT;i<sortingWords.wordsAndNumbers().length;i++){
                StringBuilder wordFrequencyPercent=new StringBuilder(sortingWords.wordsAndNumbers()[i].returnWord()+DELIMITER+
                        sortingWords.wordsAndNumbers()[i].returnWordCount()+DELIMITER+
                        ((double) sortingWords.wordsAndNumbers()[i].returnWordCount())*HUNDRED_PROCENT/
                                ((double)sortingWords.countWords()) + PROCENT_AND_TRANSFER);
                push.write(wordFrequencyPercent.toString());
            }
        }
        catch (IOException e) {
            System.err.println(EXCEPTION_STRING + e.getLocalizedMessage());
        }
        finally {
            if (null != push) {
                try {
                    push.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}

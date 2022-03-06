package com.company;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExportStringToFileCSV {

    public void export_string_to_File_CSV(java.util.Scanner scanner_files_names){
        final java.io.OutputStreamWriter NOT_FILE=null;
        java.io.OutputStreamWriter push=NOT_FILE;
        String file_name=scanner_files_names.next();

        try{
            final String ENCODING="Cp1252";
            final boolean ENTRY_FROM_A_NEW_LINE = true;
            push = new java.io.OutputStreamWriter(new FileOutputStream(file_name,ENTRY_FROM_A_NEW_LINE),ENCODING);
        }
        catch (IOException e) {
            final String ERROR_NOT_FOUND="Error while reading file: " + e.getLocalizedMessage();
            System.err.println(ERROR_NOT_FOUND);
        }
        finally {
            if (NOT_FILE != push) {
                try {
                    final int STARTING_COUNT = 0;
                    final String DELIMITER=" ; ";
                    final String PROCENT_AND_TRANSFER="%\n";
                    final Double HUNDRED_PROCENT=100.0;

                    SortingWords sorting_words=new SortingWords();
                    sorting_words.sorting(scanner_files_names);

                    for(int i=STARTING_COUNT;i<sorting_words.words().length;i++){
                            StringBuilder word_frequency_percent=new StringBuilder(sorting_words.words()[i]+DELIMITER+
                                    sorting_words.key_count()[i]+DELIMITER+
                                            ((double) sorting_words.key_count()[i])*HUNDRED_PROCENT/
                                                    ((double)sorting_words.count_words()) + PROCENT_AND_TRANSFER);
                            push.write(word_frequency_percent.toString());
                    }
                    push.close();
                } catch (IOException e) {
                    e.printStackTrace(System.err);
                }
            }
        }
    }
}

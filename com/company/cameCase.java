package com.company;
import java.io.FileOutputStream;
import java.io.IOException;

public class cameCase {
    private final int STARTING_COUNT = 0;
    private final String DELIMITER=" ; ";
    private final String PROCENT_AND_TRANSFER="%\n";
    private final Double HUNDRED_PROCENT=100.0;

    private final String ENCODING="Cp1252";
    private final boolean ENTRY_FROM_A_NEW_LINE = true;

    private final String EXCEPTION_STRING="Error while reading file: ";

    public void export_string_to_File_CSV(java.util.Scanner scanner_files_names){
        java.io.OutputStreamWriter push=null;
        String file_name=scanner_files_names.next();

        try{
            push = new java.io.OutputStreamWriter(new FileOutputStream(file_name,ENTRY_FROM_A_NEW_LINE),ENCODING);
            SortingWords sorting_words=new SortingWords();
            sorting_words.sorting(scanner_files_names);
            for(int i=STARTING_COUNT;i<sorting_words.words_and_numbers().length;i++){
                StringBuilder word_frequency_percent=new StringBuilder(sorting_words.words_and_numbers()[i].return_word()+DELIMITER+
                        sorting_words.words_and_numbers()[i].return_word_count()+DELIMITER+
                        ((double) sorting_words.words_and_numbers()[i].return_word_count())*HUNDRED_PROCENT/
                                ((double)sorting_words.count_words()) + PROCENT_AND_TRANSFER);
                push.write(word_frequency_percent.toString());
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

package com.company;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;




public class ReadFileTXT {

    private StringBuilder file_text;
    public String give_file_text(){
        return file_text.toString();
    }

    public void reading(java.util.Scanner scanner_files_names){

        file_text=new StringBuilder("");
        Reader read=null;
        String file_name=scanner_files_names.next();
        try{
            final String ENCODING="Cp1252";
            read = new InputStreamReader(new FileInputStream(file_name),ENCODING);
        }
        catch (IOException e) {
            final String ERROR_NOT_FOUND="Error while reading file: " + e.getLocalizedMessage();
            System.err.println(ERROR_NOT_FOUND);
        }
        finally {
            if (null != read)
            {
                try
                {
                    int c;
                    final int STOPING=-1;
                    while((c=read.read())!=STOPING){
                        file_text.append((char) c);
                    }
                    read.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace(System.err);
                }
            }

        }
    }
}

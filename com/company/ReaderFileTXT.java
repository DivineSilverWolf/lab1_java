package com.company;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;




public class ReaderFileTXT {
    private final String ENCODING="Cp1252";
    private final String EXCEPTION_STRING="Error while reading file: ";
    private final int STOPING=-1;

    private StringBuilder file_text;
    public String giveFileText(){
        return file_text.toString();
    }

    public void reading(java.util.Scanner scanner_files_names){

        file_text=new StringBuilder();
        Reader read=null;
        String file_name=scanner_files_names.next();
        try{
            read = new InputStreamReader(new FileInputStream(file_name),ENCODING);
            int c;
            while((c=read.read())!=STOPING){
                file_text.append((char) c);
            }
        }
        catch (IOException e) {
            System.err.println(EXCEPTION_STRING + e.getLocalizedMessage());
        }
        finally {
            if (null != read)
            {
                try
                {
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

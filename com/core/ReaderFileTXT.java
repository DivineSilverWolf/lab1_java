package com.core;
import java.io.IOException;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;




public class ReaderFileTXT {
    private final String ENCODING="Cp1252";
    private final String EXCEPTION_STRING="Error while reading file: ";
    private final int STOPING=-1;

    private StringBuilder fileText;
    public String giveFileText(){
        return fileText.toString();
    }

    public void reading(java.util.Scanner scannerFilesNames){

        fileText=new StringBuilder();
        Reader read=null;
        String fileName=scannerFilesNames.next();
        try{
            read = new InputStreamReader(new FileInputStream(fileName),ENCODING);
            int symbol;
            while((symbol=read.read())!=STOPING){
                fileText.append((char) symbol);
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

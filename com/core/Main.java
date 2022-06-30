package com.core;
import java.util.Scanner;
public class Main {
    private static final int NUMBERofFILE_NAMES=2;


    private static final int CSV_NAME_FILE=0;
    private static final int TXT_NAME_FILE=1;
    private static final int JUNK_DATA=2;
    private static final String FileNAME_SEPARATOR="\n";
    private static final String DATA_ENTERED="введено ";
    private static final String NECESSARY=" слов должно быть 2 слова через пробел";
    private static final String CAUSE_OF_ERROR=" возможно вы забыли пробел, или ввести данные";

    public static void main(String[] args) {

        if(args.length==NUMBERofFILE_NAMES) {


            Scanner scannerFilesNames = new Scanner(args[CSV_NAME_FILE] + FileNAME_SEPARATOR
                    + args[TXT_NAME_FILE]);
            SenderInCSV Start = new SenderInCSV();
            Start.sendData(scannerFilesNames);
            scannerFilesNames.close();
        }
        else{
            System.out.print(args.length>JUNK_DATA ? DATA_ENTERED + args.length + NECESSARY :
                    DATA_ENTERED + args.length + CAUSE_OF_ERROR);
        }
    }
}

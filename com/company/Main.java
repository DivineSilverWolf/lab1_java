package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        final int NUMBERofFILE_NAMES=2;

        if(args.length==NUMBERofFILE_NAMES) {


            final int CSV_NAME_FILE=0;
            final int TXT_NAME_FILE=1;
            final String FileNAME_SEPARATOR="\n";


            Scanner scanner_files_names = new Scanner(args[CSV_NAME_FILE] + FileNAME_SEPARATOR
                    + args[TXT_NAME_FILE]);
            ExportStringToFileCSV Start = new ExportStringToFileCSV();
            Start.export_string_to_File_CSV(scanner_files_names);
            scanner_files_names.close();
        }
        else{

            final String ERROR_ARGS_LENGTH=args.length>2 ? "введено " + args.length + " слов должно быть 2 слова через пробел" :
                    "введено " + args.length + "возможно вы забыли пробел, или ввести данные";


            System.out.print(ERROR_ARGS_LENGTH);
        }
    }
}

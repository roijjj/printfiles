package javaprintrecords;

import java.awt.print.*;
import java.util.ArrayList;

/**
 *
 * @author owatc
 */
public class JavaPrintRecords {

    public static void main(String[] args) {
        
        ArrayList<String> RecPrint = new ArrayList<String>();
        RecPrint.add("test");
        RecPrint.add("this");
        RecPrint.add("print");
        RecPrint.add("function");
        RecPrint.add("to see if it works correctly");

        PrintRecords bob = new PrintRecords(RecPrint);
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(bob);
        boolean ok = job.printDialog();
        if (ok) {
            try {
                 job.print();
            } catch (PrinterException ex) {
              /* The job did not successfully complete */
            }
        }
    }
}

package javaprintrecords;

import java.awt.*;
import java.awt.print.*;
import java.util.*;

/**
 *
 * @author OWATC
 */
public class PrintRecords implements Print {
    
    ArrayList<String> RecPrint;
    public PrintRecords(ArrayList<String> record)
    {
        RecPrint = record;
    }
    
    @Override
    public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {
 
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
 
        /* User (0,0) is typically outside the image area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D)g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        int fontSize = g.getFont().getSize();
        int lineCount  = 0;
 
        for (String Record : RecPrint)
        {
            lineCount++;
            /* Now we perform our rendering */
            g.drawString(Record, 100 , 100 + (lineCount * fontSize));
        }
 
        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
}

package syskathelpproject.syskathelpproject.export;


import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import syskathelpproject.syskathelpproject.entities.logiciel;
 
 
public class LogicielPDFExporter {
	
    private List<logiciel> listlogiciels;
     
    public LogicielPDFExporter(List<logiciel> listlogiciels) {
        this.listlogiciels = listlogiciels;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(4);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        cell.setPhrase(new Phrase(" ID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Logiciel ", font));
        table.addCell(cell);
         
        
        cell.setPhrase(new Phrase("Version", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Technologies", font));
        table.addCell(cell);
         
             
    }
     
    private void writeTableData(PdfPTable table) {
        for (logiciel logiciel : listlogiciels) {
            table.addCell(String.valueOf(logiciel.getIdL()));
            table.addCell(logiciel.getNom());
            table.addCell(logiciel.getVersion());
            table.addCell(logiciel.getTech());
           
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.BLUE);
         
        Paragraph p = new Paragraph("List logiciels", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}


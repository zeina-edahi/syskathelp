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

import syskathelpproject.syskathelpproject.entities.Ingenieur;
 
public class IngenieurPDFExporter {
	
    private List<Ingenieur> listIngenieurs;
     
    public IngenieurPDFExporter(List<Ingenieur> listIngenieurs) {
        this.listIngenieurs = listIngenieurs;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
         
        cell.setPhrase(new Phrase("ID", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Nom ", font));
        table.addCell(cell);
         
        
        cell.setPhrase(new Phrase("prenom", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Telephone", font));
        table.addCell(cell);       
    }
     
    private void writeTableData(PdfPTable table) {
        for (Ingenieur Ingenieur : listIngenieurs) {
            table.addCell(String.valueOf(Ingenieur.getIdI()));
            table.addCell(Ingenieur.getNoming());
            table.addCell(Ingenieur.getPrenom());
            table.addCell(Ingenieur.getEmail());
            table.addCell(String.valueOf(Ingenieur.getTelephone()));
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(BaseColor.BLUE);
         
        Paragraph p = new Paragraph("List Ingenieurs", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 4.5f, 2.5f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}


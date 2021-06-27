package syskathelpproject.syskathelpproject.export;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import syskathelpproject.syskathelpproject.entities.Ingenieur;

public class ExcelExporterIngenieur {
private  XSSFWorkbook xssfworkbook;
private List<Ingenieur> Ingenieurs;
private XSSFSheet xssfsheet;


private void headerLine(){
	 xssfsheet =  xssfworkbook.createSheet("Ingenieurs details");
	Row row = xssfsheet.createRow(0);
	
	CellStyle cellstyle = xssfworkbook.createCellStyle();
	XSSFFont font = xssfworkbook.createFont();
	font.setBold(true);
	font.setFontHeight(16);
	cellstyle.setFont(font);
	createCell(row,0,"ID",cellstyle);
	createCell(row,1,"NOM ",cellstyle);
	createCell(row,2,"Prenom",cellstyle);
	createCell(row,3,"Email",cellstyle);
	createCell(row,4,"Telephone",cellstyle);
	
}


private void createCell(Row row, int countColum ,Object value, CellStyle cellstyle) {
	// TODO Auto-generated method stub
	
	xssfsheet.autoSizeColumn(countColum);
	Cell cell = row.createCell(countColum);
	if(value instanceof Long) {
		cell.setCellValue((Long) value);
		}
	else if(value instanceof String) {
		
		cell.setCellValue((String) value);
	}else {
		
		cell.setCellValue((int) value);
	}
	cell.setCellStyle(cellstyle);
}
private void writeDataLines()
{
	int rowCount =1;
	
	CellStyle style = xssfworkbook.createCellStyle();
	XSSFFont font = xssfworkbook.createFont();
	font.setFontHeight(18);
   style.setFont(font);
for(Ingenieur Ingenieurs: Ingenieurs) {
	Row row = xssfsheet.createRow(rowCount++);
	int countColumn =0;
	createCell(row,countColumn++,Ingenieurs.getIdI(),style);
	createCell(row,countColumn++,Ingenieurs.getNom(),style);
	createCell(row,countColumn++,Ingenieurs.getPrenom(),style);
	createCell(row,countColumn++,Ingenieurs.getEmail(),style);
	createCell(row,countColumn++,Ingenieurs.getTelephone(),style);

}

}

public ExcelExporterIngenieur(List<Ingenieur>Ingenieurs) {
	
	this.Ingenieurs=Ingenieurs;
	xssfworkbook = new XSSFWorkbook();
	
}

public void exportData(HttpServletResponse response) throws IOException {
	
	headerLine();
	writeDataLines();
	
	ServletOutputStream outputstream = response.getOutputStream();
	xssfworkbook.write(outputstream);
	xssfworkbook.close();
	outputstream.close();
	
}
}

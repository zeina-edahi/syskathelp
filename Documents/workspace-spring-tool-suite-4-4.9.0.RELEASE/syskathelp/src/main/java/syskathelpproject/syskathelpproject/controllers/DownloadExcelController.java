package syskathelpproject.syskathelpproject.controllers;



import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import syskathelpproject.syskathelpproject.dao.ClientRepository;
import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.entities.Client;
import syskathelpproject.syskathelpproject.entities.Ingenieur;
import syskathelpproject.syskathelpproject.entities.logiciel;
import syskathelpproject.syskathelpproject.export.ExcelExporter;
import syskathelpproject.syskathelpproject.export.ExcelExporterIngenieur;
import syskathelpproject.syskathelpproject.export.ExcelExporterLogiciel;


@Controller
public class DownloadExcelController {
	
	@Autowired
	private ClientRepository clientRepository; 
	@Autowired
	private LogicielRepository logicielRepository; 
	
	@Autowired
	private IngenieurRepository ingenieurRepository; 
	
	
	
	@GetMapping("/exportclient")
	public void exporToExcel(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/octet-stream");
		
		String header = "Content-Disposition";
		
		String headerValue="attachment; filename=Clients.xlsx";
		response.setHeader(header, headerValue);
		
		List<Client> clients = (List<Client>)clientRepository.findAll();
		ExcelExporter excelexporter = new ExcelExporter(clients);
		
		excelexporter.exportData(response);
		
	}
	@GetMapping("/exportingenieur")
	public void exporIngenieurToExcel(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/octet-stream");
		
		String header = "Content-Disposition";
		
		String headerValue="attachment; filename=Ingenieurs.xlsx";
		response.setHeader(header, headerValue);
		
		List<Ingenieur> Ingenieurs = (List<Ingenieur>)ingenieurRepository.findAll();
		ExcelExporterIngenieur excelexporter = new ExcelExporterIngenieur(Ingenieurs);
		
		excelexporter.exportData(response);
		
	}
	@GetMapping("/exportlogiciel")
	public void exporLogicielToExcel(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/octet-stream");
		
		String header = "Content-Disposition";
		
		String headerValue="attachment; filename=Logiciels.xlsx";
		response.setHeader(header, headerValue);
		
		List<logiciel> logiciels = (List<logiciel>)logicielRepository.findAll();
		ExcelExporterLogiciel excelexporter = new ExcelExporterLogiciel(logiciels);
		
		excelexporter.exportData(response);
		
	}
	
}
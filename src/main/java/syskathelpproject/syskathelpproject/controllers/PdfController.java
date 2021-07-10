package syskathelpproject.syskathelpproject.controllers;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import  com.itextpdf.text.DocumentException;


import syskathelpproject.syskathelpproject.dao.ClientRepository;
import syskathelpproject.syskathelpproject.dao.IngenieurRepository;
import syskathelpproject.syskathelpproject.dao.LogicielRepository;
import syskathelpproject.syskathelpproject.entities.Client;
import syskathelpproject.syskathelpproject.entities.Ingenieur;
import syskathelpproject.syskathelpproject.entities.logiciel;
import syskathelpproject.syskathelpproject.export.ClientPDFExporter;
import syskathelpproject.syskathelpproject.export.IngenieurPDFExporter;
import syskathelpproject.syskathelpproject.export.LogicielPDFExporter;



@Controller

public class PdfController {
	
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    LogicielRepository logicielRepository;
    @Autowired
    IngenieurRepository ingenieurRepository;


    @GetMapping("/exportclientpdf")
   	    public void exportToPDF(HttpServletResponse response) throws IOException, DocumentException{
   	        response.setContentType("application/pdf");
   	        
   	         
   	        String headerKey = "Content-Disposition";
   	        String headerValue = "attachment; filename=Clients.pdf";
   	        response.setHeader(headerKey, headerValue);
   	         
   	        List<Client> listClients = clientRepository.findAll();
   	         
   	        ClientPDFExporter exporter = new ClientPDFExporter(listClients);
   	        exporter.export(response);
   	         
   	    }
    
    @GetMapping("/exportlogicielpdf")
	    public void exportToPDFlogiciel(HttpServletResponse response) throws IOException, DocumentException{
	        response.setContentType("application/pdf");
	        
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Logiciels.pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<logiciel> listlogiciels = logicielRepository.findAll();
	         
	        LogicielPDFExporter exporter = new LogicielPDFExporter(listlogiciels);
	        exporter.export(response);
	         
	    }
    
    
    @GetMapping("/exportIngenieurpdf")
	    public void exportToPDFIngenieur(HttpServletResponse response) throws IOException, DocumentException{
	        response.setContentType("application/pdf");
	        
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=Ingenieurs.pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Ingenieur> listIngenieurs = ingenieurRepository.findAll();
	         
	        IngenieurPDFExporter exporter = new IngenieurPDFExporter(listIngenieurs);
	        exporter.export(response);
	         
	    }
}
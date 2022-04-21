package com.rgg.wementis.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgg.wementis.services.impl.PDFGeneratorServiceImpl;
import com.rgg.wementis.utils.Utils;

@RestController
@RequestMapping("/v1")
public class PDFExportController {

	@Autowired
	private PDFGeneratorServiceImpl pdfGeneratorService;
	
	public PDFExportController(PDFGeneratorServiceImpl pdfGeneratorService) {
		this.pdfGeneratorService = pdfGeneratorService;
	}
	
	@GetMapping("/pdf/generate")
	public void generatePDF(HttpServletResponse response) {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=informe_" + Utils.currentDate() + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		pdfGeneratorService.export(response);
	}
}

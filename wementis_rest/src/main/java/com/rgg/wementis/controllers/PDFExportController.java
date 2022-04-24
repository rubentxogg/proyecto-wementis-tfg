package com.rgg.wementis.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/pdf/generate", params = {"fechaInforme", "paciente", "fechaNacimiento", "genero", "psicologo", "motivoConsulta", 
			"observacionesGenerales", "analisisResultados", "conclusiones", "recomendaciones"})
	public void generatePDF(HttpServletResponse response, 
			@RequestParam(value = "fechaInforme", required = true) String fechaInforme,
			@RequestParam(value = "paciente", required = true) String paciente,
			@RequestParam(value = "fechaNacimiento", required = true) String fechaNacimiento,
			@RequestParam(value = "genero", required = true) String genero,
			@RequestParam(value = "psicologo", required = true) String psicologo,
			@RequestParam(value = "motivoConsulta", required = true) String motivoConsulta,
			@RequestParam(value = "observacionesGenerales", required = true) String observacionesGenerales,
			@RequestParam(value = "analisisResultados", required = true) String analisisResultados, 
			@RequestParam(value = "conclusiones", required = true) String conclusiones, 
			@RequestParam(value = "recomendaciones", required = true) String recomendaciones) {
		response.setContentType("application/pdf");
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=informe_" + Utils.currentDate() + ".pdf";
		response.setHeader(headerKey, headerValue);
		
		pdfGeneratorService.export(response, fechaInforme, paciente, fechaNacimiento, genero, psicologo, motivoConsulta, observacionesGenerales,
				analisisResultados, conclusiones, recomendaciones);
	}
}

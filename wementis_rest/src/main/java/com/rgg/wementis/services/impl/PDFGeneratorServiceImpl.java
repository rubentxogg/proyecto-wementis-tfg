package com.rgg.wementis.services.impl;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.rgg.wementis.services.interfaces.IPDFGeneratorService;

@Service
public class PDFGeneratorServiceImpl implements IPDFGeneratorService{

	@Override
	public void export(HttpServletResponse response, String fechaInforme, String paciente, String fechaNacimiento, String genero, String psicologo,
			String motivoConsulta, String observacionesGenerales, String analisisResultados, String conclusiones, String recomendaciones) {
		try(Document document = new Document(PageSize.A4)) {
			PdfWriter.getInstance(document, response.getOutputStream());
			
			document.open();
			
			Font fontTittle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTittle.setSize(18);
			
			Paragraph paragraph = new Paragraph("INFORME PSICOLÓGICO CLÍNICO", fontTittle);
			paragraph.setAlignment(Element.ALIGN_LEFT);
			
			Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
			fontParagraph.setSize(12);
			
			Paragraph paragraph2 = new Paragraph(paciente);
			paragraph2.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph3 = new Paragraph(fechaNacimiento);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph4 = new Paragraph(genero);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph5 = new Paragraph(psicologo);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph6 = new Paragraph(motivoConsulta);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph7 = new Paragraph(observacionesGenerales);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph8 = new Paragraph(analisisResultados);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph9 = new Paragraph(conclusiones);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			Paragraph paragraph10 = new Paragraph(recomendaciones);
			paragraph3.setAlignment(Element.ALIGN_LEFT);
			
			document.add(paragraph);
			document.add(paragraph2);
			document.add(paragraph3);
			document.add(paragraph4);
			document.add(paragraph5);
			document.add(paragraph6);
			document.add(paragraph7);
			document.add(paragraph8);
			document.add(paragraph9);
			document.add(paragraph10);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}

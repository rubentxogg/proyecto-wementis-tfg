package com.rgg.wementis.services.impl;

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
	public void export(HttpServletResponse response) {
		try(Document document = new Document(PageSize.A4)) {
			PdfWriter.getInstance(document, response.getOutputStream());
			
			document.open();
			
			Font fontTittle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTittle.setSize(18);
			
			Paragraph paragraph = new Paragraph("This is a tittle.", fontTittle);
			paragraph.setAlignment(Element.ALIGN_CENTER);
			
			Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
			fontParagraph.setSize(12);
			
			Paragraph paragraph2 = new Paragraph("This is a paragraph", fontParagraph);
			paragraph2.setAlignment(Element.ALIGN_LEFT);
			
			document.add(paragraph);
			document.add(paragraph2);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}

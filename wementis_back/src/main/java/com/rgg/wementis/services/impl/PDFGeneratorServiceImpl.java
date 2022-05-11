package com.rgg.wementis.services.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.draw.DottedLineSeparator;
import com.lowagie.text.pdf.draw.LineSeparator;
import com.lowagie.text.pdf.draw.VerticalPositionMark;
import com.rgg.wementis.services.interfaces.IPDFGeneratorService;

@Service
public class PDFGeneratorServiceImpl implements IPDFGeneratorService{

	@Override
	public void export(HttpServletResponse response, String fechaInforme, String paciente, String fechaNacimiento, String genero, String psicologo,
			String motivoConsulta, String observacionesGenerales, String analisisResultados, String conclusiones, String recomendaciones) {
		try(Document document = new Document(PageSize.A4)) {
			PdfWriter.getInstance(document, response.getOutputStream());
			
			document.open();
			
			Image logo = Image.getInstance(getClass().getClassLoader().getResource("logo.png"));
			logo.scaleAbsolute(40f, 40f);
			logo.setAlignment(Element.ALIGN_TOP);
			
			DottedLineSeparator dottedline = new DottedLineSeparator();
	        dottedline.setOffset(-2);
	        dottedline.setGap(2f);
			
			Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTitle.setSize(18);
			
			Font fontTitle2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTitle2.setSize(14);
			
			Font fontParagraphBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontParagraphBold.setSize(12);
			
			Font fontParagraphRegular = FontFactory.getFont(FontFactory.HELVETICA);
			fontParagraphRegular.setSize(12);
			
			Paragraph title = new Paragraph("INFORME PSICOLÓGICO CLÍNICO", fontTitle);
			title.setAlignment(Element.ALIGN_LEFT);
			title.add(new Chunk(new VerticalPositionMark()));
			title.add(fechaInforme);
			
			LineSeparator lineSeparator = new LineSeparator();
			lineSeparator.setOffset(15f);
			Chunk lineBreak = new Chunk(lineSeparator);
			
			Paragraph datosFiliacionTitle = new Paragraph("I.DATOS DE FILIACIÓN", fontTitle2);
			datosFiliacionTitle.setSpacingAfter(10f);
			datosFiliacionTitle.add(dottedline);
			
			Paragraph nombreYApellidosParagraph = new Paragraph("Nombre y apellidos         :     ", fontParagraphBold);
			nombreYApellidosParagraph.add(new Chunk(paciente, fontParagraphRegular));
			nombreYApellidosParagraph.setSpacingAfter(10f);
			
			
			Paragraph fechaNacimientoParagraph = new Paragraph("Fecha de nacimiento       :     ", fontParagraphBold);
			fechaNacimientoParagraph.add(new Chunk(fechaNacimiento, fontParagraphRegular));
			fechaNacimientoParagraph.setSpacingAfter(10f);
			
			Paragraph sexoParagraph = new Paragraph("Sexo                                  :     ", fontParagraphBold);
			sexoParagraph.add(new Chunk(genero, fontParagraphRegular));
			sexoParagraph.setSpacingAfter(10f);
			
			Paragraph referenteParagraph = new Paragraph("Referente                          :     ", fontParagraphBold);
			referenteParagraph.add(new Chunk("A petición del propio examinado.", fontParagraphRegular));
			referenteParagraph.setSpacingAfter(10f);
			
			Paragraph motivoEvaluacionParagraph = new Paragraph("Motivo de evaluación      :     ", fontParagraphBold);
			motivoEvaluacionParagraph.add(new Chunk("Determinar la salud mental(área emocional y área de personalidad) con la finalidad de descartar la presencia de algún trastorno de personalidad(moderados a graves) o trastornos psiquiátricos.", fontParagraphRegular));
			motivoEvaluacionParagraph.setSpacingAfter(10f);
			
			Paragraph examinadorParagraph = new Paragraph("Examinador (psicólogo) :     ", fontParagraphBold);
			examinadorParagraph.add(new Chunk(psicologo, fontParagraphRegular));
			examinadorParagraph.setSpacingAfter(10f);

			Paragraph motivoConsultaTitle = new Paragraph("II.MOTIVO DE CONSULTA", fontTitle2);
			motivoConsultaTitle.setSpacingAfter(10f);
			motivoConsultaTitle.add(dottedline);
			
			Paragraph motivoConsultaParagraph = new Paragraph(motivoConsulta, fontParagraphRegular);
			motivoConsultaParagraph.setSpacingAfter(10f);
			
			Paragraph observacionesGeneralesTitle = new Paragraph("III.OBSERVACIONES GENERALES", fontTitle2);
			observacionesGeneralesTitle.setSpacingAfter(10f);
			observacionesGeneralesTitle.add(dottedline);
			
			Paragraph observacionesGeneralesParagraph = new Paragraph(observacionesGenerales, fontParagraphRegular);
			observacionesGeneralesParagraph.setSpacingAfter(10f);
			
			Paragraph analisisResultadosTitle = new Paragraph("IV.ANÁLISIS DE LOS RESULTADOS", fontTitle2);
			analisisResultadosTitle.setSpacingAfter(10f);
			analisisResultadosTitle.add(dottedline);
			
			Paragraph analisisResultadosParagraph = new Paragraph(analisisResultados, fontParagraphRegular);
			analisisResultadosParagraph.setSpacingAfter(10f);
			
			Paragraph conclusionesTitle = new Paragraph("V.CONCLUSIONES", fontTitle2);
			conclusionesTitle.setSpacingAfter(10f);
			conclusionesTitle.add(dottedline);
			
			Paragraph conclusionesParagraph = new Paragraph(conclusiones, fontParagraphRegular);
			conclusionesParagraph.setSpacingAfter(10f);
			
			Paragraph recomendacionesTitle = new Paragraph("VI.RECOMENDACIONES", fontTitle2);
			recomendacionesTitle.setSpacingAfter(10f);
			recomendacionesTitle.add(dottedline);
			
			Paragraph recomendacionesParagraph = new Paragraph(recomendaciones, fontParagraphRegular);
			recomendacionesParagraph.setSpacingAfter(10f);
			
			document.add(logo);
			document.add(title);
			document.add(lineBreak);
			
			document.add(datosFiliacionTitle);
			document.add(nombreYApellidosParagraph);
			document.add(fechaNacimientoParagraph);
			document.add(sexoParagraph);
			document.add(referenteParagraph);
			document.add(motivoEvaluacionParagraph);
			document.add(examinadorParagraph);
			
			document.add(motivoConsultaTitle);
			document.add(motivoConsultaParagraph);
			
			document.add(observacionesGeneralesTitle);
			document.add(observacionesGeneralesParagraph);
			
			document.add(analisisResultadosTitle);
			document.add(analisisResultadosParagraph);
			
			document.add(conclusionesTitle);
			document.add(conclusionesParagraph);
			
			document.add(recomendacionesTitle);
			document.add(recomendacionesParagraph);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}

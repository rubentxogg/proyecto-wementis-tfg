package com.rgg.wementis.services.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
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
			
			Font fontTittle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTittle.setSize(18);
			
			Font fontTittle2 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontTittle2.setSize(14);
			
			Font fontParagraphBold = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
			fontParagraphBold.setSize(12);
			
			Font fontParagraphRegular = FontFactory.getFont(FontFactory.HELVETICA);
			fontParagraphRegular.setSize(12);
			
			Paragraph tittle = new Paragraph("INFORME PSICOLÓGICO CLÍNICO", fontTittle);
			tittle.setAlignment(Element.ALIGN_LEFT);
			tittle.add(new Chunk(new VerticalPositionMark()));
			tittle.add(fechaInforme);
			
			LineSeparator lineSeparator = new LineSeparator();
			lineSeparator.setOffset(6);
			Chunk lineBreak = new Chunk(lineSeparator);
			
			Paragraph datosFiliacionTittle = new Paragraph("I.DATOS DE FILIACIÓN", fontTittle2);
			datosFiliacionTittle.setSpacingAfter(10f);
			
			Paragraph nombreYApellidosParagraph = new Paragraph("Nombre y apellidos:", fontParagraphBold);
			nombreYApellidosParagraph.add(new Chunk(paciente, fontParagraphRegular));
			nombreYApellidosParagraph.setSpacingAfter(10f);
			
			
			Paragraph fechaNacimientoParagraph = new Paragraph("Fecha de nacimiento:", fontParagraphBold);
			fechaNacimientoParagraph.add(new Chunk(fechaNacimiento, fontParagraphRegular));
			fechaNacimientoParagraph.setSpacingAfter(10f);
			
			Paragraph sexoParagraph = new Paragraph("Sexo:", fontParagraphBold);
			sexoParagraph.add(new Chunk(genero, fontParagraphRegular));
			sexoParagraph.setSpacingAfter(10f);
			
			Paragraph referenteParagraph = new Paragraph("Referente:", fontParagraphBold);
			referenteParagraph.add(new Chunk("A petición del propio examinado.", fontParagraphRegular));
			referenteParagraph.setSpacingAfter(10f);
			
			Paragraph motivoEvaluacionParagraph = new Paragraph("Motivo de evaluación:", fontParagraphBold);
			motivoEvaluacionParagraph.add(new Chunk("Determinar la salud mental(área emocional y área de personalidad) con la finalidad de descartar la presencia de algún trastorno de personalidad(moderados a graves) o trastornos psiquiátricos.", fontParagraphRegular));
			motivoEvaluacionParagraph.setSpacingAfter(10f);
			
			Paragraph examinadorParagraph = new Paragraph("Examinador (psicólogo):", fontParagraphBold);
			examinadorParagraph.add(new Chunk(psicologo, fontParagraphRegular));
			examinadorParagraph.setSpacingAfter(10f);

			Paragraph motivoConsultaTittle = new Paragraph("II.MOTIVO DE CONSULTA", fontTittle2);
			motivoConsultaTittle.setSpacingAfter(10f);
			
			Paragraph motivoConsultaParagraph = new Paragraph(motivoConsulta, fontParagraphRegular);
			motivoConsultaParagraph.setSpacingAfter(10f);
			
			Paragraph observacionesGeneralesTittle = new Paragraph("III.OBSERVACIONES GENERALES", fontTittle2);
			observacionesGeneralesTittle.setSpacingAfter(10f);
			
			Paragraph observacionesGeneralesParagraph = new Paragraph(observacionesGenerales, fontParagraphRegular);
			observacionesGeneralesParagraph.setSpacingAfter(10f);
			
			Paragraph analisisResultadosTittle = new Paragraph("IV.ANÁLISIS DE LOS RESULTADOS", fontTittle2);
			analisisResultadosTittle.setSpacingAfter(10f);
			
			Paragraph analisisResultadosParagraph = new Paragraph(analisisResultados, fontParagraphRegular);
			analisisResultadosParagraph.setSpacingAfter(10f);
			
			Paragraph conclusionesTittle = new Paragraph("V.CONCLUSIONES", fontTittle2);
			conclusionesTittle.setSpacingAfter(10f);
			
			Paragraph conclusionesParagraph = new Paragraph(conclusiones, fontParagraphRegular);
			conclusionesParagraph.setSpacingAfter(10f);
			
			Paragraph recomendacionesTittle = new Paragraph("VI.RECOMENDACIONES", fontTittle2);
			recomendacionesTittle.setSpacingAfter(10f);
			
			Paragraph recomendacionesParagraph = new Paragraph(recomendaciones, fontParagraphRegular);
			recomendacionesParagraph.setSpacingAfter(10f);
			
			document.add(tittle);
			document.add(lineBreak);
			
			document.add(datosFiliacionTittle);
			document.add(nombreYApellidosParagraph);
			document.add(fechaNacimientoParagraph);
			document.add(sexoParagraph);
			document.add(referenteParagraph);
			document.add(motivoEvaluacionParagraph);
			document.add(examinadorParagraph);
			
			document.add(motivoConsultaTittle);
			document.add(motivoConsultaParagraph);
			
			document.add(observacionesGeneralesTittle);
			document.add(observacionesGeneralesParagraph);
			
			document.add(analisisResultadosTittle);
			document.add(analisisResultadosParagraph);
			
			document.add(conclusionesTittle);
			document.add(conclusionesParagraph);
			
			document.add(recomendacionesTittle);
			document.add(recomendacionesParagraph);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}	
}

package com.rgg.wementis.services.interfaces;

import javax.servlet.http.HttpServletResponse;

public interface IPDFGeneratorService {

	public void export(HttpServletResponse response, String fechaInforme, String paciente, String fechaNacimiento, String genero, String psicologo,
			String motivoConsulta, String observacionesGenerales, String analisisResultados, String conclusiones, String recomendaciones);
}

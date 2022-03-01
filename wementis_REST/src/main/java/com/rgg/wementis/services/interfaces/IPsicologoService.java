package com.rgg.wementis.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.rgg.wementis.beans.Psicologo;
import com.rgg.wementis.entities.PsicologoEntity;

public interface IPsicologoService {

	public Iterable<PsicologoEntity> getPsicologos();

	public Optional<PsicologoEntity> getPsicologoPorId(Integer id);

	public List<Psicologo> getPsicologosPorCampos(String id, String nombre, String apellidos, String email,
			String telefono, String fechaCreacion);
	
	public void actualizarPsicologo(PsicologoEntity psicologo);
	
	public void insertarPsicologo(PsicologoEntity psicologo);
	
	public void borrarPsicologo(Integer id);
}

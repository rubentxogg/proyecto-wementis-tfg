package com.rgg.wementis.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgg.wementis.beans.Psicologo;
import com.rgg.wementis.entities.PsicologoEntity;
import com.rgg.wementis.repositories.PsicologoRepository;
import com.rgg.wementis.services.interfaces.IPsicologoService;
import com.rgg.wementis.utils.Utils;

@Service
public class PsicologoServiceImpl implements IPsicologoService{

	@Autowired
	private PsicologoRepository psicologoRepository;
	
	@Override
	public Iterable<PsicologoEntity> getPsicologos() {
		return psicologoRepository.findByActivo(1);
	}

	@Override
	public Optional<PsicologoEntity> getPsicologoPorId(Integer id) {
		return psicologoRepository.findById(id);
	}

	@Override
	public List<Psicologo> getPsicologosPorCampos(String id, String nombre, String apellidos, String email,
			String telefono, String fechaCreacion) {
		return psicologoRepository.getPsicologosPorCampos(id, nombre, apellidos, email, telefono, fechaCreacion);
	}

	@Override
	public void actualizarPsicologo(PsicologoEntity psicologo) {
		psicologoRepository.save(psicologo);
	}

	@Override
	public void insertarPsicologo(PsicologoEntity psicologo) {
		psicologo.setFechaCreacion(Utils.currentDate());
		psicologoRepository.save(psicologo);
	}

	@Override
	public void borrarPsicologo(Integer id) {
		PsicologoEntity psicologo = psicologoRepository.findById(id).get();
		psicologo.setActivo(0);
		psicologoRepository.save(psicologo);
	}

}

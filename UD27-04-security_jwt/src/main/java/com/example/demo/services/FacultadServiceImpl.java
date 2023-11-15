package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;

@Service
public class FacultadServiceImpl implements IFacultadService {
	@Autowired
	IFacultadDAO iFacultadDAO;

	@Override
	public List<Facultad> listar() {
		return iFacultadDAO.findAll();

	}

	@Override
	public Facultad guardar(Facultad facultad) {
		return iFacultadDAO.save(facultad);

	}

	@Override
	public Facultad porIdentificador(int codigo) {
		return iFacultadDAO.findById(codigo).get();

	}

	@Override
	public Facultad actualizar(Facultad facultad) {
		return iFacultadDAO.save(facultad);

	}

	@Override
	public void eliminar(int codigo) {
		iFacultadDAO.deleteById(codigo);		
		
	}

}

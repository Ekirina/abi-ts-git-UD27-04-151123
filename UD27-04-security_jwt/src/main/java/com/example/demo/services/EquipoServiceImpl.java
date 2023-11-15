package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;

@Service
public class EquipoServiceImpl implements IEquipoService{
	@Autowired
	IEquipoDAO iEquipoDAO;

	@Override
	public List<Equipo> listar() {
		return iEquipoDAO.findAll();

	}

	@Override
	public Equipo guardar(Equipo equipo) {
		return iEquipoDAO.save(equipo);

	}

	@Override
	public Equipo porIdentificador(String num_serie) {
		return iEquipoDAO.findById(num_serie).get();

	}

	@Override
	public Equipo actualizar(Equipo equipo) {
		return iEquipoDAO.save(equipo);

	}

	@Override
	public void eliminar(String num_serie) {
		iEquipoDAO.deleteById(num_serie);				
		
	}
	
}

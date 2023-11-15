package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;

@Service
public class InvestigadorServiceImpl implements IInvestigadorService {
	@Autowired
	IInvestigadorDAO iInvestigadorDAO;

	@Override
	public List<Investigador> listar() {
		return iInvestigadorDAO.findAll();

	}

	@Override
	public Investigador guardar(Investigador investigador) {
		return iInvestigadorDAO.save(investigador);

	}

	@Override
	public Investigador porIdentificador(String dni) {
		return iInvestigadorDAO.findById(dni).get();

	}

	@Override
	public Investigador actualizar(Investigador investigador) {
		return iInvestigadorDAO.save(investigador);

	}

	@Override
	public void eliminar(String dni) {
		iInvestigadorDAO.deleteById(dni);		
		
	}
	

}

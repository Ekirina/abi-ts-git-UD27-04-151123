package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service
public class ReservaServiceImpl implements IReservaService{
	@Autowired
	IReservaDAO iReservaDAO;

	@Override
	public List<Reserva> listar() {
		return iReservaDAO.findAll();

	}

	@Override
	public Reserva guardar(Reserva reserva) {
		return iReservaDAO.save(reserva);

	}

	@Override
	public Reserva porIdentificador(int id) {
		return iReservaDAO.findById(id).get();

	}

	@Override
	public Reserva actualizar(Reserva reserva) {
		return iReservaDAO.save(reserva);

	}

	@Override
	public void eliminar(int id) {
		iReservaDAO.deleteById(id);				
		
	}
	
}

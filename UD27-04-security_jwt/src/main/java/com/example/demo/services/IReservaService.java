package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Reserva;

public interface IReservaService {
	//Métodos CRUD
	public List<Reserva> listar(); //Listar All 

	public Reserva guardar(Reserva reserva);	//Guarda 

	public Reserva porIdentificador(int id); //Leer datos 

	public Reserva actualizar(Reserva reserva); //Actualiza datos 

	public void eliminar(int id);// Elimina datos

}

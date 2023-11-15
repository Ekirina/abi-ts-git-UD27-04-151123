package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Investigador;

public interface IInvestigadorService {
	//Métodos CRUD

	public List<Investigador> listar(); //Listar All 

	public Investigador guardar(Investigador investigador);	//Guarda 

	public Investigador porIdentificador(String dni); //Leer datos 

	public Investigador actualizar(Investigador investigador); //Actualiza datos 

	public void eliminar(String dni);// Elimina datos
}

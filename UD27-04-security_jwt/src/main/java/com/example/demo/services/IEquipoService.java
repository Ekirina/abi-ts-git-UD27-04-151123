package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Equipo;

public interface IEquipoService {
	//Método CRUD
	
	public List<Equipo> listar(); //Listar All 
	
	public Equipo guardar(Equipo equipo);	//Guarda 
	
	public Equipo porIdentificador(String num_serie); //Leer datos 
	
	public Equipo actualizar(Equipo equipo); //Actualiza datos 
	
	public void eliminar(String num_serie);// Elimina datos
}

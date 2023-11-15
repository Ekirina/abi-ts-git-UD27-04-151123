package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadService {
	//Métodos CRUD
	public List<Facultad> listar(); //Listar All 

	public Facultad guardar(Facultad facultad);	//Guarda 

	public Facultad porIdentificador(int codigo); //Leer datos 

	public Facultad actualizar(Facultad facultad); //Actualiza datos 

	public void eliminar(int codigo);// Elimina datos
}

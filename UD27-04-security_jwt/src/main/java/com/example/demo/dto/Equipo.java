package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="equipo")
public class Equipo {
	@Id
	private String num_serie;
	@Column(name = "nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "codigo_facultad")
	private Facultad facultad;
	
	@OneToMany
	@JoinColumn(name = "num_serie")
	private List <Reserva> reserva;
	
	//Constructores
	public Equipo() {
		
	}

	public Equipo(String num_serie, String nombre, Facultad facultad, List<Reserva> reserva) {
		super();
		this.num_serie = num_serie;
		this.nombre = nombre;
		this.facultad = facultad;
		this.reserva = reserva;
	}

	
	//Getters y setters

	public String getNum_serie() {
		return num_serie;
	}

	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	//Método String
	
	@Override
	public String toString() {
		return "Equipo [num_serie=" + num_serie + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}
	
	
}

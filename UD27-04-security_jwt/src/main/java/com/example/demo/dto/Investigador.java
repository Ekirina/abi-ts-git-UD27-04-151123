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
@Table(name="investigador")
public class Investigador {
	@Id
	private String dni;
	@Column(name="nom_apels")
	private String nom_apels;
	
	@ManyToOne
	@JoinColumn(name="codigo_facultad")
	private Facultad facultad;
	
	@OneToMany
	@JoinColumn(name="dni")
	private List<Reserva> reserva;
	
	//Constructores
	public Investigador() {
		
	}

	public Investigador(String dni, String nom_apels, Facultad facultad, List<Reserva> reserva) {
		super();
		this.dni = dni;
		this.nom_apels = nom_apels;
		this.facultad = facultad;
		this.reserva = reserva;
	}
	//Getters y setters

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
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
	
	
	
}

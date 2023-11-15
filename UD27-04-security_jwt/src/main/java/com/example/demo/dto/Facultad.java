package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="facultad")
public class Facultad {
	@Id
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="codigo_facultad")
	private List <Equipo> equipo;
	
	@OneToMany
	@JoinColumn(name="codigo_facultad")
	private List <Investigador> investigador;
	
	//Constructores
	public Facultad() {
		
	}

	public Facultad(int codigo, String nombre, List<Equipo> equipo, List<Investigador> investigador) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.equipo = equipo;
		this.investigador = investigador;
	}

	
	
	//Getters y setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipo() {
		return equipo;
	}

	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}

	
	
	//Método String
	
	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
}

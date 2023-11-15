package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Equipo;
import com.example.demo.services.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {
	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipo")
	public List<Equipo> listarEquipo(){
		return equipoServiceImpl.listar();
	}
	@PostMapping("/equipo")
	public Equipo salvarEquipo(@RequestBody Equipo equipo) {
		
		return equipoServiceImpl.guardar(equipo);
	}
	@GetMapping("/equipo/{id}")
	public Equipo investigadorXID(@PathVariable(name="num_serie")String num_serie) {
		Equipo Equipo_xid = new Equipo();
		Equipo_xid = equipoServiceImpl.porIdentificador(num_serie);
		System.out.println("Equipo XID: "+Equipo_xid);
		return Equipo_xid;
	}
	@PutMapping("/equipo/{id}")
	public Equipo actualizarEquipo(@PathVariable(name="codigo")String num_serie, @RequestBody Equipo equipo) {
		Equipo Equipo_seleccionado= new Equipo();
		Equipo Equipo_actualizado= new Equipo();

		Equipo_seleccionado= equipoServiceImpl.porIdentificador(num_serie);

		Equipo_seleccionado.setNombre(equipo.getNombre());
		Equipo_seleccionado.setFacultad(equipo.getFacultad());

		Equipo_actualizado = equipoServiceImpl.actualizar(Equipo_seleccionado);

		System.out.println("El equipo actualizado es: "+ Equipo_actualizado);

		return Equipo_actualizado;
	}
	@DeleteMapping("/equipo/{id}")
	public void eliminarEquipo(@PathVariable(name="num_serie")String num_serie) {
		equipoServiceImpl.eliminar(num_serie);
	}
}

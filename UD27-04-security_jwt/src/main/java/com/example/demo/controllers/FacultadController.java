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

import com.example.demo.dto.Facultad;
import com.example.demo.services.FacultadServiceImpl;

@RestController
@RequestMapping("/api")
public class FacultadController {
	@Autowired
	FacultadServiceImpl facultadServiceImpl;
	@GetMapping("/facultad")
	public List<Facultad> listarFacultad(){
		return facultadServiceImpl.listar();
	}
	@PostMapping("/facultad")
	public Facultad salvarFacultad(@RequestBody Facultad facultad) {
		
		return facultadServiceImpl.guardar(facultad);
	}
	@GetMapping("/facultad/{id}")
	public Facultad facultadXID(@PathVariable(name="codigo")int codigo) {
		Facultad Facultad_xid = new Facultad();
		Facultad_xid = facultadServiceImpl.porIdentificador(codigo);
		System.out.println("Facultad XID: "+Facultad_xid);
		return Facultad_xid;
	}
	@PutMapping("/facultad/{id}")
	public Facultad actualizarFacultad(@PathVariable(name="codigo")int codigo, @RequestBody Facultad facultad) {
		Facultad Facultad_seleccionado= new Facultad();
		Facultad Facultad_actualizado= new Facultad();

		Facultad_seleccionado= facultadServiceImpl.porIdentificador(codigo);

		Facultad_seleccionado.setNombre(facultad.getNombre());

		Facultad_actualizado = facultadServiceImpl.actualizar(Facultad_seleccionado);

		System.out.println("La facultad actualizada es: "+ Facultad_actualizado);

		return Facultad_actualizado;
	}
	@DeleteMapping("/facultad/{id}")
	public void eliminarFacultad(@PathVariable(name="codigo")int codigo) {
		facultadServiceImpl.eliminar(codigo);
	}
}
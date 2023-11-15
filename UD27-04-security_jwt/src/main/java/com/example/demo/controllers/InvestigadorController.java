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

import com.example.demo.dto.Investigador;
import com.example.demo.services.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigador")
	public List<Investigador> listarInvestigador(){
		return investigadorServiceImpl.listar();
	}
	@PostMapping("/investigador")
	public Investigador salvarInvestigador(@RequestBody Investigador investigador) {
		
		return investigadorServiceImpl.guardar(investigador);
	}
	@GetMapping("/investigador/{id}")
	public Investigador investigadorXID(@PathVariable(name="dni")String dni) {
		Investigador Investigador_xid = new Investigador();
		Investigador_xid = investigadorServiceImpl.porIdentificador(dni);
		System.out.println("Investigador XID: "+Investigador_xid);
		return Investigador_xid;
	}
	@PutMapping("/investigador/{id}")
	public Investigador actualizarInvestigador(@PathVariable(name="codigo")String dni, @RequestBody Investigador investigador) {
		Investigador Investigador_seleccionado= new Investigador();
		Investigador Investigador_actualizado= new Investigador();

		Investigador_seleccionado= investigadorServiceImpl.porIdentificador(dni);

		Investigador_seleccionado.setNom_apels(investigador.getNom_apels());
		Investigador_seleccionado.setFacultad(investigador.getFacultad());

		Investigador_actualizado = investigadorServiceImpl.actualizar(Investigador_seleccionado);

		System.out.println("El investigador es: "+ Investigador_actualizado);

		return Investigador_actualizado;
	}
	@DeleteMapping("/investigador/{id}")
	public void eliminarInvestigador(@PathVariable(name="codigo")String dni) {
		investigadorServiceImpl.eliminar(dni);
	}
}

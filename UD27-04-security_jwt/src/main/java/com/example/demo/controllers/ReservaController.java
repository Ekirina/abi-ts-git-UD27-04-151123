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

import com.example.demo.dto.Reserva;
import com.example.demo.services.ReservaServiceImpl;


@RestController
@RequestMapping("/api")
public class ReservaController {
	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reserva")
	public List<Reserva> listarReserva(){
		return reservaServiceImpl.listar();
	}
	@PostMapping("/reserva")
	public Reserva salvarReserva(@RequestBody Reserva reserva) {
		
		return reservaServiceImpl.guardar(reserva);
	}
	@GetMapping("/reserva/{id}")
	public Reserva reservaXID(@PathVariable(name="id")int id) {
		Reserva Reserva_xid = new Reserva();
		Reserva_xid = reservaServiceImpl.porIdentificador(id);
		System.out.println("Reserva XID: "+Reserva_xid);
		return Reserva_xid;
	}
	@PutMapping("/reserva/{id}")
	public Reserva actualizarReserva(@PathVariable(name="id")int id, @RequestBody Reserva reserva) {
		Reserva Reserva_seleccionado= new Reserva();
		Reserva Reserva_actualizado= new Reserva();

		Reserva_seleccionado= reservaServiceImpl.porIdentificador(id);

		Reserva_seleccionado.setInvestigador(reserva.getInvestigador());
		Reserva_seleccionado.setEquipo(reserva.getEquipo());
		Reserva_seleccionado.setComienzo(reserva.getComienzo());
		Reserva_seleccionado.setFin(reserva.getFin());

		Reserva_actualizado = reservaServiceImpl.actualizar(Reserva_seleccionado);

		System.out.println("La reserva actualizada es: "+ Reserva_actualizado);

		return Reserva_actualizado;
	}
	@DeleteMapping("/reserva/{id}")
	public void eliminarReserva(@PathVariable(name="id")int id) {
		reservaServiceImpl.eliminar(id);
	}

}

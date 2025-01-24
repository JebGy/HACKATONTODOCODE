package com.example.backendmedico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendmedico.models.ModeloPaqueteServicioWrap;
import com.example.backendmedico.models.ModeloPaqueteServicios;
import com.example.backendmedico.services.ServicioPaqueteServicios;

@RestController
public class ControladorPaqueteServicios {
	
	@Autowired
	private ServicioPaqueteServicios servServicioPaquete;
	
	@GetMapping("/api/paquetes/listarTodo")
	public List<ModeloPaqueteServicioWrap> listarTodos(){
		return servServicioPaquete.listarTodosLosPaquetes();
	}
	
	@GetMapping("/api/paquetes/listarsolopaquetes")
	public List<ModeloPaqueteServicios> listarSoloPaquetes(){
		return servServicioPaquete.listarPaquetesSinDetalle();
	}
	
	@PostMapping("/api/paquetes/agregarpaquete")
	public void agregarPaquete(@RequestBody ModeloPaqueteServicios datosPaquete){
		 servServicioPaquete.agregarPaqueteServicios(datosPaquete);
	}
	
	@PostMapping("/api/paquetes/daralta")
	public void darAltaPaqueteServicios(@RequestParam String codigoPaquete){
		 servServicioPaquete.darAltaPaqueteServicio(codigoPaquete);
	}
	
	@PostMapping("/api/paquetes/darbaja")
	public void darBajaPaqueteServicios(@RequestParam String codigoPaquete){
		 servServicioPaquete.darBajaPaqueteServicio(codigoPaquete);
	}
	
	@PostMapping("/api/paquetes/editar")
	public void editarPaqueteServicios(@RequestBody ModeloPaqueteServicios datosPaquete){
		 servServicioPaquete.editarPaqueteServicio(datosPaquete);
	}
	
}

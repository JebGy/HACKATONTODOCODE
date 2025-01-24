package com.example.backendmedico.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendmedico.models.ModeloServicio;
import com.example.backendmedico.services.ServicioServicios;

@RestController()
public class ControladorServicios {
	
	@Autowired
	private ServicioServicios servicioServicios;

	@GetMapping("/api")
	public String mainMethod() {
		return "Hola Seguidores";
	}
	
	@PostMapping("/api/agregarServicio")
	public String agregarServicioEndPoint(@RequestBody ModeloServicio modelo) {
		ModeloServicio modeloAEnviar = new ModeloServicio(modelo.getCodigoServicio(),
				modelo.getCodigoPaqueteServicio(),
				modelo.getNombreServico(), 
				modelo.getDescripciónServicio(),
				modelo.getPrecioServicio(),
				modelo.getIsEnable());
		servicioServicios.agregarNuevoServicio(modeloAEnviar);
		
		return "OK";
	}
	
	@GetMapping("/api/listarServicios")
	public List<ModeloServicio> retornarListaServicios(){
		return servicioServicios.consultarServicioTodos();
	}
	
	@GetMapping("/api/buscarServicio")
	public ModeloServicio retornarUnSoloServicio(@RequestParam String codigo) {
		ModeloServicio modeloARetornar =servicioServicios.consultarServicioUnoPorId(codigo);
		return modeloARetornar;
	}
}













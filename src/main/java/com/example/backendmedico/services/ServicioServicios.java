package com.example.backendmedico.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendmedico.models.ModeloServicio;
import com.example.backendmedico.repositories.RepositorioServicio;

@Service
public class ServicioServicios {

	@Autowired
	private RepositorioServicio repoServicio;

	public List<ModeloServicio> consultarServicioTodos() {
		return repoServicio.findAll();
	}

	public ModeloServicio consultarServicioUnoPorNombre(String nombreServicio) {
		return repoServicio.findBynombreServico(nombreServicio);
	}

	public ModeloServicio consultarServicioUnoPorId(String codigoServicio) {
		return repoServicio.findByCodigoServicio(codigoServicio);
	}

	public void agregarNuevoServicio(ModeloServicio modelo) {
		repoServicio.save(modelo);
	}

	public List<ModeloServicio> encontrarPorPaquewteAsociado(String codigoPaquete) {
		return repoServicio.findAllBycodigoPaqueteServicio(codigoPaquete);
	}

	public void darAltaServicio(String codigoServicio) {
		ModeloServicio modeloAActualizar = repoServicio.findByCodigoServicio(codigoServicio);
		modeloAActualizar.setIsEnable(true);
		repoServicio.save(modeloAActualizar);
	}

	public void darBajaServicio(String codigoServicio) {
		ModeloServicio modeloAActualizar = repoServicio.findByCodigoServicio(codigoServicio);
		modeloAActualizar.setIsEnable(false);
		repoServicio.save(modeloAActualizar);
	}

	public void editarServicio(ModeloServicio modeloActualizado) {
		repoServicio.save(modeloActualizado);
	}
}

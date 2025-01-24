package com.example.backendmedico.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendmedico.models.ModeloPaqueteServicioWrap;
import com.example.backendmedico.models.ModeloPaqueteServicios;
import com.example.backendmedico.models.ModeloServicio;
import com.example.backendmedico.repositories.RepositorioPaqueteServicios;
import com.example.backendmedico.repositories.RepositorioServicio;

@Service
public class ServicioPaqueteServicios {
	@Autowired
	private RepositorioPaqueteServicios repoPaqueteServicios;

	@Autowired
	private ServicioServicios servicioServicios;

	public void agregarPaqueteServicios(ModeloPaqueteServicios paquete) {
		repoPaqueteServicios.save(paquete);
	}

	public List<ModeloPaqueteServicios> listarPaquetesSinDetalle() {
		return repoPaqueteServicios.findAll();
	}

	public List<ModeloPaqueteServicioWrap> listarTodosLosPaquetes() {
		List<ModeloPaqueteServicios> listaPaquetesServicios = repoPaqueteServicios.findAll();
		List<ModeloPaqueteServicioWrap> listaDePaquetesConServicios = new ArrayList<ModeloPaqueteServicioWrap>();

		for (ModeloPaqueteServicios modeloPaqueteServicios : listaPaquetesServicios) {
			ModeloPaqueteServicioWrap modeloWrap = new ModeloPaqueteServicioWrap();
			modeloWrap.setCodigoPaquete(modeloPaqueteServicios.getCodigoPaquete());
			modeloWrap.setPrecioPaquete(modeloPaqueteServicios.getPrecioPaquete());
			modeloWrap.setIsEnable(modeloPaqueteServicios.getIsEnable());

			if (!listaDePaquetesConServicios.contains(modeloWrap)) {
				List<ModeloServicio> listaProv = new ArrayList<ModeloServicio>();
				List<ModeloServicio> listaServicios = servicioServicios
						.encontrarPorPaquewteAsociado(modeloWrap.getCodigoPaquete());
				for (ModeloServicio modeloPaqueteServicioWrap : listaServicios) {
					listaProv.add(modeloPaqueteServicioWrap);
				}

				Double precioTotal = listaProv.stream().mapToDouble(ModeloServicio::getPrecioServicio).sum();
				Double precioDescuento = precioTotal * 0.15;
				Double precioFinal = precioTotal - precioDescuento;
				modeloWrap.setPrecioPaquete(precioFinal);
				agregarPaqueteServicios(
						new ModeloPaqueteServicios().builder()
						.codigoPaquete(modeloWrap.getCodigoPaquete())
						.precioPaquete(precioFinal)
						.isEnable(modeloWrap.getIsEnable()).build()
						);
				modeloWrap.setListadoDeServiciosRelacionados(listaProv);
				listaDePaquetesConServicios.add(modeloWrap);
			}
		}

		return listaDePaquetesConServicios;
	}

	public void darAltaPaqueteServicio(String codigoPaquete) {
		ModeloPaqueteServicios modeloAActualizar = repoPaqueteServicios.findByCodigoPaquete(codigoPaquete);
		modeloAActualizar.setIsEnable(true);
		repoPaqueteServicios.save(modeloAActualizar);
	}

	public void darBajaPaqueteServicio(String codigoPaquete) {
		ModeloPaqueteServicios modeloAActualizar = repoPaqueteServicios.findByCodigoPaquete(codigoPaquete);
		modeloAActualizar.setIsEnable(false);
		repoPaqueteServicios.save(modeloAActualizar);
	}

	public void editarPaqueteServicio(ModeloPaqueteServicios modeloActualizado) {
		repoPaqueteServicios.save(modeloActualizado);
	}
}

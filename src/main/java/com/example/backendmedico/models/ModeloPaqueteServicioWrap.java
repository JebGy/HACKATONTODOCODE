package com.example.backendmedico.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModeloPaqueteServicioWrap extends ModeloPaqueteServicios{
	private List<ModeloServicio> listadoDeServiciosRelacionados;
}

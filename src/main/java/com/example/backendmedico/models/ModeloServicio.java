package com.example.backendmedico.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModeloServicio {
	@Id
	private String codigoServicio;
	private String codigoPaqueteServicio;
	private String nombreServico;
	private String descripciónServicio;
	private Double precioServicio;
	private Boolean isEnable;	
	
}

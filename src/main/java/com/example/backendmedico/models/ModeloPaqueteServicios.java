package com.example.backendmedico.models;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ModeloPaqueteServicios {
	
	@Id
	private String codigoPaquete;
	private double precioPaquete;
	private Boolean isEnable;
}

package com.example.backendmedico.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.backendmedico.models.ModeloPaqueteServicios;
import com.example.backendmedico.models.ModeloServicio;

@EnableJpaRepositories
public interface RepositorioServicio extends JpaRepository<ModeloServicio, String>{
	ModeloServicio findBynombreServico(String nombreServicio);
	ModeloServicio findByCodigoServicio(String codigoServicio);
	List<ModeloServicio> findAllBycodigoPaqueteServicio(String codigoPaqueteServicio);
}

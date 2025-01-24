package com.example.backendmedico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.backendmedico.models.ModeloPaqueteServicios;

@Repository
public interface RepositorioPaqueteServicios extends JpaRepository<ModeloPaqueteServicios, String>{

	ModeloPaqueteServicios findByCodigoPaquete(String codigoPaquete);

}

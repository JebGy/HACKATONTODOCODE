package com.example.backendmedico.repositories;

import com.example.backendmedico.models.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorModel, String> {}

package com.example.backendmedico.repositories;

import com.example.backendmedico.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface PatientRepository extends JpaRepository<PatientModel, String> {
	PatientModel getPatientByDni(final String dni);

//	List<PatientModel> filterPatients(
//		@Param("first_name") String firstName,
//		@Param("last_name") String lastName,
//		@Param("email") String email,
//		@Param("dni") String dni
//	);

	List<PatientModel> findPatientsByFirstNameOrLastNameOrEmailOrDni(
		@Param("first_name") String firstName,
		@Param("last_name") String lastName,
		@Param("email") String email,
		@Param("dn") String dni
	);
}

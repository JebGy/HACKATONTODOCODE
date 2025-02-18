package com.example.backendmedico.repositories;

import com.example.backendmedico.models.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository
	extends JpaRepository<PatientModel, String>, JpaSpecificationExecutor<PatientModel> {
	PatientModel getPatientByDni(String dni);

	//	List<PatientModel> filterPatients(
	//		@Param("first_name") String firstName,
	//		@Param("last_name") String lastName,
	//		@Param("email") String email,
	//		@Param("dni") String dni
	//	);

//	List<PatientModel> findPatientsByFirstNameOrLastNameOrEmailOrDni(
//		@Param("first_name") String firstName,
//		@Param("last_name") String lastName,
//		@Param("email") String email,
//		@Param("dni") String dni,
//		@Param("offset") short offset,
//		@Param("limit") short limit
//	);
}

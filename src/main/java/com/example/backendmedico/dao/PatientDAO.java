package com.example.backendmedico.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.example.backendmedico.models.PatientModel;

public interface PatientDAO {
	List<PatientModel> getAllPatients(Pageable page);

	PatientModel getPatientById(String patientId);

	PatientModel addPatient(PatientModel patient);

	PatientModel updatePatient(PatientModel patient);

	Integer deletePatient(String patientId);

	PatientModel getPatientByDni(String dni);

	List<PatientModel> filterPatients(Map<String, String> valuesToFilter, Pageable page);
}

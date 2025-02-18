package com.example.backendmedico.services;

import com.example.backendmedico.models.PatientModel;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PatientService {
	List<PatientModel> getAllPatients(Pageable page);

	PatientModel getPatientById(String patientId);

	PatientModel addPatient(PatientModel patient);

	PatientModel updatePatient(String patientId, PatientModel patient);

	Integer deletePatient(String patientId);

	PatientModel getPatientByDni(String dni);

	List<PatientModel> filterPatients(Map<String, String> valuesToFilter, Pageable page);
}
